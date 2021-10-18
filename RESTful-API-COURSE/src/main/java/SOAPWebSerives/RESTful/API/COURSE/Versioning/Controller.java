package SOAPWebSerives.RESTful.API.COURSE.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value = "/person",params = "version=1")
    public Person1 person1(){
        return new Person1("Gaurav Singh");
    }
    @GetMapping(value = "/person",params = "version=2")
    public Person2 person2(){
        return new Person2(new Name("Gaurav","Singh"));
    }
}
