package springframework.petclinic.services.SpringJpaData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springframework.petclinic.Model.Owner;
import springframework.petclinic.repositories.OwnerRepository;
import springframework.petclinic.repositories.PetRepository;
import springframework.petclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
    Owner owner = new Owner();
    owner.setId(2L);
        Owner owner2 = new Owner();
        owner.setId(3L);
        owners.add(owner2);
        owners.add(owner);
        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> set = (Set<Owner>) ownerRepository.findAll();
        assertEquals(2,set.size());
        assertNotNull(owners);
    }

    @Test
    void findById() {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName("smith");
        when(ownerRepository.findById(any())).thenReturn(java.util.Optional.of(owner));
        Owner smith = ownerSDJpaService.findById(1L);
        //assertEquals("smith", smith.getLastName());
        assertEquals(1,smith.getId());
    }

    @Test
    void save() {
        Owner savedOwner = new Owner();
        savedOwner.setId(2L);
        when(ownerRepository.save(any())).thenReturn(savedOwner);

        Owner s = ownerSDJpaService.save(savedOwner);

        assertEquals(2,s.getId());
    }

    @Test
    void delete() {
        Owner deletedOwner = new Owner();
        deletedOwner.setId(3L);
        ownerSDJpaService.delete(deletedOwner);
        verify(ownerRepository).delete(any());
    }


    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName("smith");
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner smith = ownerSDJpaService.findByLastName("smith");
        assertEquals("smith",smith.getLastName());
    }
}