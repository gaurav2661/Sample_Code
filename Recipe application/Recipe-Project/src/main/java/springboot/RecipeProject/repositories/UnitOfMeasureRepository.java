package springboot.RecipeProject.repositories;

import org.springframework.data.repository.CrudRepository;
import springboot.RecipeProject.Domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}

