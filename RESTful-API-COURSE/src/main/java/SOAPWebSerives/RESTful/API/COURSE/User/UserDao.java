package SOAPWebSerives.RESTful.API.COURSE.User;

import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class UserDao {

    private static List<User> userList = new ArrayList<>();

    private static int Count = 984;

    static {
        User user1 = new User(980,"MAYANK","SINGH","mayank@gmail.com",9089786756L);
        User user2 = new User(981,"SOURAV","SINGH","sourav@gmail.com",4556677889L);
        User user3 = new User(982,"RAJESH","KUMAR","rajesh@gmail.com",1223344556L);
        User user4 = new User(983,"ASHISH","SINGH","ashish@gmail.com",9898099887L);
        User user5 = new User(984,"SHIVAM","KUMAR","shivam@gmail.com",9998877609L);



        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);


    }

    public List<User> findAll(){
        return userList;
    }
    public User save(User user){
        if(user.getId()==null){
            user.setId(++Count);
        }
        userList.add(user);
        return user;
    }
    public User findById(Integer id){
        for(User user:userList){
            if(Objects.equals(user.getId(), id)){
                return user;
            }
        }return null;
    }
 }
