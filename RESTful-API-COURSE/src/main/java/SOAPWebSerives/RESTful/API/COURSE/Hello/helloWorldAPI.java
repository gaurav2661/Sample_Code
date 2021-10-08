package SOAPWebSerives.RESTful.API.COURSE.Hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class helloWorldAPI {
    @RequestMapping(method = RequestMethod.GET,path = "/helloWorld")
    public String helloWorld(){
        return "HELLO GAURAV";
    }
    @GetMapping(path = "/helloWorld/getMapping")
    public String helloBean(){
        return "you are using get mapping now";
    }
    @GetMapping(path = "/helloWorld/getMapping/Bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World Bean");
        /**
         * This will return object in JSON format.
         *
         * It is a common mistake to call a JSON object literal "a JSON object".
         *
         * JSON cannot be an object. JSON is a string format.
         *
         * The data is only JSON when it is in a string format.
         *
         * When it is converted to a JavaScript variable, it becomes a JavaScript object.
         */
    }
    @GetMapping(path = "/helloWorld/getMapping/yourMessage/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {

        return new HelloWorldBean(String.format("Hello World Bean,%s",name));
    }
}
