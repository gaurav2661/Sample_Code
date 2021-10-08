package springframework.petclinic.services.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springframework.petclinic.Model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    Owner owner = new Owner();

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
        
    }

    @Test
    void findById() {
        Owner owner1= ownerServiceMap.findById(1L);

        assertEquals(1,owner1.getId());
    }

    @Test
    void findByLastName() {
    }
}