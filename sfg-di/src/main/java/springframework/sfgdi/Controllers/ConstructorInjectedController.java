package springframework.sfgdi.Controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import springframework.sfgdi.Services.GreetingService;
@Controller
public class ConstructorInjectedController {
    private final GreetingService greetingService;
    //if there is no qualifier then primary bean will be injected in the constructorinjectedcontroller


    public ConstructorInjectedController(@Qualifier("constructorInjectedGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    public String getGreeting(){
        return greetingService.sayGreetings();
    }

}

