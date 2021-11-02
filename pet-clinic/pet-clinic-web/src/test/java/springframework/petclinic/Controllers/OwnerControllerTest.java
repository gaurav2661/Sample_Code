package springframework.petclinic.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import springframework.petclinic.Model.Owner;
import springframework.petclinic.services.OwnerService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController ownerController;

    MockMvc mockMvc;

    Set<Owner> owners = new HashSet<>();
    @BeforeEach
    void setUp() {

        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        owner1.setId(1L);
        owner2.setId(2L);
        owners.add(owner1);
        owners.add(owner2);
         mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void listOwners() throws Exception {

        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners")).andExpect(status().is(200))
                .andExpect(view().name("owners/index")).andExpect(model().attribute("owners",hasSize(2)));


    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/find")).andExpect(status().is(200))
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));

        verifyZeroInteractions(ownerService);
    }
    @Test
    void processFindFormReturnMany() throws Exception{
        Owner owner1 = new Owner();
        owner1.setId(1L);
        Owner owner2 = new Owner();
        owner1.setId(2L);
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(owner1,owner2));

        mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("owners",hasSize(2)));
    }
    @Test
    void processFindFormReturnOne() throws Exception{
        Owner owner1 = new Owner();
        owner1.setId(1L);
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(owner1));

        mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/1"))
                .andExpect(model().attribute("owners",hasSize(2)));
    }
    @Test
    void displayOwner() throws Exception{
        Owner owner1 = new Owner();
        owner1.setId(1L);
        when(ownerService.findById(anyLong())).thenReturn(owner1);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners/123")).andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner",hasProperty("id",is(1L))));
    }
}