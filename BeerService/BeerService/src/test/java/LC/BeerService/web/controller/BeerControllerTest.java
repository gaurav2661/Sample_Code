package LC.BeerService.web.controller;

import LC.BeerService.web.model.BeerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
    }

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/"+ UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = new BeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON).content(beerDtoJson)).andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto beerDto = new BeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/"+UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
                .andExpect(status().isNoContent());
    }
}