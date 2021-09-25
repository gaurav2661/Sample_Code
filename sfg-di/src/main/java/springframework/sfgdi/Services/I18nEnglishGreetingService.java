package springframework.sfgdi.Services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.sfgdi.Repository.EnglishGreetingRepository;

public class I18nEnglishGreetingService implements GreetingService{
    private final EnglishGreetingRepository englishGreetingRepository;
    public I18nEnglishGreetingService (EnglishGreetingRepository englishGreetingRepository){
        this.englishGreetingRepository=englishGreetingRepository;
    }
    @Override
    public String sayGreetings() {
        return "Hello -EN";
    }
}
