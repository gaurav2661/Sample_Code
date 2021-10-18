package springframework.petclinic.services.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import springframework.petclinic.Model.Owner;
import springframework.petclinic.repositories.OwnerRepository;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    Owner owner = new Owner();
    @Autowired
    OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {

        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(),new PetServiceMap());
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }

    @Test
    void save() {
        Owner owner = new Owner();
        owner.setId(3L);
        assertEquals(owner.getId(),ownerServiceMap.save(owner).getId());
    }

    @Test
    void findById() {
        Owner owner1= ownerServiceMap.findById(1L);

        assertEquals(1,owner1.getId());
    }

    @Test
    void findByLastName() {
        Owner owner1 = new Owner();
        owner1.setId(3L);
        owner1.setLastName("shergill");
        ownerServiceMap.save(owner1);


        assertEquals(owner1.getLastName(),ownerServiceMap.findByLastName("shergill").getLastName());
    }
}