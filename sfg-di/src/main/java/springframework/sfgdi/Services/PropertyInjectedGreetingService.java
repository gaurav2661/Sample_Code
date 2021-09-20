package springframework.sfgdi.Services;

import org.springframework.stereotype.Service;

@Service
public class PropertyInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreetings() {
        return "Hello World---Property";
    }
}
