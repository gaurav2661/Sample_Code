package springframework.sfgdi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import springframework.sfgdi.Services.GreetingService;
@Controller
public class PropertyInjectedController {
    @Qualifier("propertyInjectedGreetingService")
    @Autowired

    public GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreetings();
    }

}
