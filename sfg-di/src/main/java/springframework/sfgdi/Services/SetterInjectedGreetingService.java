package springframework.sfgdi.Services;

import org.springframework.stereotype.Service;


public class SetterInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreetings() {
        return "Hello World----Setter";
    }
}
