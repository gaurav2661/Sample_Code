package springboot.RecipeProject.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
    @GetMapping("books")
    public List<Book> getAllBooks(){
        return Arrays.asList(new Book(67L,"mastering spring 5.0","micheal jackson"));
    }
}
