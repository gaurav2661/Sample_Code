package springframework.sfgdi.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springframework.sfgdi.Services.ConstructorInjectedGreetingService;
import springframework.sfgdi.Services.PrimaryGreetingService;
import springframework.sfgdi.Services.PropertyInjectedGreetingService;
import springframework.sfgdi.Services.SetterInjectedGreetingService;

@Configuration
public class GreetingServiceConfig {

    //these are user defined beans
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
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
