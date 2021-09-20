package springframework.sfgdi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import springframework.sfgdi.Services.GreetingService;
@Controller
public class SetterInjectedController {

    @Qualifier("setterInjectedGreetingService")
    @Autowired
    private GreetingService greetingService;


    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    public String getGreeting(){
        return greetingService.sayGreetings();
    }

}
