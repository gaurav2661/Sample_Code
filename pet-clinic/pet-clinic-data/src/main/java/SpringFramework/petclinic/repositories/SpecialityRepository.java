package springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.petclinic.Model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
