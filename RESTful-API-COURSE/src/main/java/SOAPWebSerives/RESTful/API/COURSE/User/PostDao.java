package SOAPWebSerives.RESTful.API.COURSE.User;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class PostDao {

    private static List<Post> postList = new ArrayList<>();

    static {
        Post post1 = new Post(124,"post 1",new Date(),"post 1 body");
        Post post2 = new Post(125,"post 2",new Date(),"post 2 body");
        Post post3 = new Post(126,"post 3",new Date(),"post 3 body");
        Post post4 = new Post(127,"post 4",new Date(),"post 4 body");
        Post post5 = new Post(128,"post 5",new Date(),"post 5 body");
        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
        postList.add(post4);
        postList.add(post5);

    }
    public List<Post> findAllPosts(){
        return postList;
    }
    public Post findById(Integer postId){
        for(int i =0;i<postList.size();i++){
            if(postList.get(i).getPostId()==postId){
                return postList.get(i);
            }
        }return null;
    }




}

