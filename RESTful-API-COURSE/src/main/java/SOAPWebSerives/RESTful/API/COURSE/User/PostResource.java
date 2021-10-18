package SOAPWebSerives.RESTful.API.COURSE.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostResource {
    @Autowired
    PostDao postDao;
    @Autowired
    UserDao userDao;

    @GetMapping(path = "/retrieveposts")
    public List<Post> retrievePosts(){
        return postDao.findAllPosts();
    }
    @GetMapping(path = "findpost/{postid}")
    public Post findPost(@PathVariable Integer postid){
        return postDao.findById(postid);
    }
    @GetMapping(path = "finduser/{userId}/findpost/{postId}")
    public Post findPostOfUser(@PathVariable Integer userId,@PathVariable Integer postId){
        User user = userDao.findById(userId);
        if(user==null){
            throw new UserNotFoundException("id : "+userId);
        }
        else{
            List<Post> postList= user.getUserPosts();
            for(int i =0;i<postList.size();i++){
                if(postList.get(i).getPostId()==postId){
                    return postList.get(i);
                }
                else {
                    throw new UserNotFoundException("id : "+postId);
                }
            }return null;
        }

    }
}
