package SOAPWebSerives.RESTful.API.COURSE.User;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Post {
    private Integer postId;
    private String title;
    private Date timeOfPost;
    private String bodyOfPost;

    public Post() {
    }

    public Post(Integer PostId,String title, Date timeOfPost, String bodyOfPost) {
        this.title = title;
        this.timeOfPost = timeOfPost;
        this.bodyOfPost = bodyOfPost;
        this.postId=PostId;
    }

    public Integer getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public Date getTimeOfPost() {
        return timeOfPost;
    }

    public String getBodyOfPost() {
        return bodyOfPost;
    }
}
