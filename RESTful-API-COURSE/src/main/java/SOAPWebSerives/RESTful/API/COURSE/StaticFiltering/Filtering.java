package SOAPWebSerives.RESTful.API.COURSE.StaticFiltering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Filtering {
    @GetMapping(path = "/filtering-static")
    public someBean returnSomeBean(){
        return new someBean("value1","value2","value3");
    }
}
