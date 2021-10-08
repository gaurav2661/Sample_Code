package SOAPWebSerives.RESTful.API.COURSE.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
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
        return userDaoById;
    }
    @PostMapping(path = "/createUser")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = userDao.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
         return ResponseEntity.created(location).build();
        /**
         * this will change the HTTP status to 201 (Created).
         */
    }

}
