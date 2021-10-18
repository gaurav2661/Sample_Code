package SOAPWebSerives.RESTful.API.COURSE.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Component
public class UserDao {
    @Autowired
    PostDao postDao;

    private static List<User> userList = new ArrayList<>();
    private static List<Post> postList = new ArrayList<>();



    private static int Count = 984;

    static {    Post post1 = new Post(124,"post 1",new Date(),"post 1 body");
        Post post2 = new Post(125,"post 2",new Date(),"post 2 body");
        Post post3 = new Post(126,"post 3",new Date(),"post 3 body");
        Post post4 = new Post(127,"post 4",new Date(),"post 4 body");
        Post post5 = new Post(128,"post 5",new Date(),"post 5 body");
        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
        postList.add(post4);
        postList.add(post5);

        User user1 = new User(980,"MAYANK","SINGH","mayank@gmail.com",9089786756L);
        User user2 = new User(981,"SOURAV","SINGH","sourav@gmail.com",4556677889L);
        User user3 = new User(982,"RAJESH","KUMAR","rajesh@gmail.com",1223344556L);
        User user4 = new User(983,"ASHISH","SINGH","ashish@gmail.com",9898099887L);
        User user5 = new User(984,"SHIVAM","KUMAR","shivam@gmail.com",9998877609L);
        User user6 =new User(985,"SHABU","THAKUR","shabu@gmail.com",864783939L);
        user1.addUserPosts(post1);
        user1.addUserPosts(post2);
        user1.addUserPosts(post3);
        user1.addUserPosts(post4);
        user1.addUserPosts(post5);





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
    public User deleteById(Integer id){
        Iterator<User> userIterator =userList.iterator();
        while (userIterator.hasNext()){
            User user = userIterator.next();
                    if(Objects.equals(user.getId(), id)){
                        userIterator.remove();
                        return user;
                    }
        }return null;
    }

 }
