package springframework.petclinic.services.SpringJpaData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springframework.petclinic.Model.Owner;
import springframework.petclinic.repositories.OwnerRepository;
import springframework.petclinic.repositories.PetRepository;
import springframework.petclinic.repositories.PetTypeRepository;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {
        ownerSDJpaService = new OwnerSDJpaService(ownerRepository,petRepository,petTypeRepository);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName("smith");
        Owner smith = ownerSDJpaService.findByLastName("smith");
    }
}