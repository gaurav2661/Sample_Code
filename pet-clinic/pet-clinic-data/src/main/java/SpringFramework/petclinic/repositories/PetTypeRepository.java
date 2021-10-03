package springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.petclinic.Model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
