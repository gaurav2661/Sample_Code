package SOAPWebSerives.RESTful.API.COURSE.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.hateoas.HateoasProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.server.core.ControllerEntityLinks;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserResource {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    UserDao userDao;
    @GetMapping(path = "/retrieveAllUsers")
    public List<User> retrieveAllUsers(){
        return userDao.findAll();
    }
    @GetMapping(path = "/retrieveUser/{id}")
    public User retrieveUser(@PathVariable Integer id){
        User userDaoById = userDao.findById(id);
        if(userDaoById==null){
            throw new UserNotFoundException("id : "+id);
        }

        //"All users",SERVER_PATH +"/users"
        //HATEOAS


        return userDaoById;
    }
    @PostMapping(path = "/createUser")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userDao.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
         return ResponseEntity.created(location).build();
        /**
         * this will change the HTTP status to 201 (Created).
         */
    }
    @DeleteMapping (path = "/deleteUser/{id}")
    public void deleteUser(@PathVariable Integer id){
        User userDa = userDao.deleteById(id);
        if(userDa==null){
            throw new UserNotFoundException("id : "+id);
        }
    }
    @GetMapping(path = "/hello-world-internationalization")
    public String helloWorld(@RequestHeader(name = "Accept-Language",required = false) Locale locale){
        return messageSource.getMessage("good.morning.message",null,locale);
    }



}
