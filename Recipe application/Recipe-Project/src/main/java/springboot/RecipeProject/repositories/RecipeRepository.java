package springboot.RecipeProject.repositories;

import org.springframework.data.repository.CrudRepository;
import springboot.RecipeProject.Domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
