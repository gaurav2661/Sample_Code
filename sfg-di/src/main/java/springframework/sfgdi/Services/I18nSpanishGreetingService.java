package springframework.sfgdi.Services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public class I18nSpanishGreetingService implements GreetingService{
    @Override
    public String sayGreetings() {
        return "Hola mundo- ES";
    }
}
