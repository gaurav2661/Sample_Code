package SOAPWebSerives.RESTful.API.COURSE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    public static final Contact DEFAULT_CONTACT = new Contact("", "", "");
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API title","awseome description","1.0","tos", "DEFAULT_CONTACT","apache","dont know");


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
    }
}
