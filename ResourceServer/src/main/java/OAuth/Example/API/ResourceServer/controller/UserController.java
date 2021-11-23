package OAuth.Example.API.ResourceServer.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Secured("ROLE_developer")
//    @PreAuthorize("hasRole('developer')")
    @GetMapping("/status/check")
    public String status(){
        return "Working!!";
    }
//    @Secured("ROLE_developer")
    @DeleteMapping(path = "/delete/{id}")
    public String  deleteUser(@PathVariable String  id){
        return "User deleted with id :"+id;
    }
}
