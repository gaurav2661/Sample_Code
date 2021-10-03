package springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.petclinic.Model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {

}
