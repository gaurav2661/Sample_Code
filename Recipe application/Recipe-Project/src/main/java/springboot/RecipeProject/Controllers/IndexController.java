package springboot.RecipeProject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.RecipeProject.Domain.Category;
import springboot.RecipeProject.Domain.UnitOfMeasure;
import springboot.RecipeProject.repositories.CategoryRepository;
import springboot.RecipeProject.repositories.UnitOfMeasureRepository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","index","index.html"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("cup");

        System.out.printf("Category id is : " + categoryOptional.get().getId());
        System.out.println("unit of measure id is : " + unitOfMeasureOptional.get().getId());
        
        return "index";
    }
}
