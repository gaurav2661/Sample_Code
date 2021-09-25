package springframework.petclinic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","index", "templates/index.html"})
    public String index(){
        System.out.println("hello  save");
        return "index";
    }
    @RequestMapping("/oups")
    public String oopsHandler(){
        return "notImplemented";
    }

}
