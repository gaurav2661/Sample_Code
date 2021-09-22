package springframework.sfgdi.Services;

import org.springframework.stereotype.Service;


public class ConstructorInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreetings() {
        return "Hello World---constructor";
    }
}
