package springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.petclinic.Model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
