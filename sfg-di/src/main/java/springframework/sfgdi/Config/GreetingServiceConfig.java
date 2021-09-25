package springframework.sfgdi.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import springframework.sfgdi.DataSource.FakeDataSource;
import springframework.sfgdi.Repository.EnglishGreetingRepository;
import springframework.sfgdi.Repository.EnglishGreetingRepositoryImpl;
import springframework.sfgdi.Services.*;
import springframework.sfgdi.pets.PetServiceFactory;
import springframework.sfgdi.pets.Petservice;

@Configuration
public class GreetingServiceConfig {

    //these are user defined beans
    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }
    @Bean("petservice")
    @Profile({"dog","default"})
    Petservice dogPetService(PetServiceFactory petServiceFactory)
    {
        return petServiceFactory.getPetService("dog");
    }
    @Bean
    @Profile("cat")
    Petservice catPetService(PetServiceFactory petServiceFactory)
    {
        return petServiceFactory.getPetService("cat");
    }
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Profile({"ES","default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }
    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }
    @Bean
    ConstructorInjectedGreetingService constructorInjectedGreetingService(){
        return new ConstructorInjectedGreetingService();
    }
    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }
}
