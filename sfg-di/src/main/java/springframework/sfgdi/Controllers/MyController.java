package springframework.sfgdi.Controllers;

import org.springframework.stereotype.Controller;
import springframework.sfgdi.Services.GreetingService;

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
       return greetingService.sayGreetings();
    }
}
