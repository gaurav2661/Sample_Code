package SOAPWebSerives.RESTful.API.COURSE.User;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * we can create a status code for individual exception like this
 * and can also make  generic exception handling for all resources
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String s) {
        super(s);
    }
}

