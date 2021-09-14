package Thrillio.Managers;

import Thrillio.Dao.UserDao;
import Thrillio.Entities.User;

public class UserManager {
    /**
     * making private constructor static because to access it from static method
     *  If it’s made private, then it can only be accessed inside the class.
     */
    private static UserManager instance = new UserManager();
    private static UserDao dao = new UserDao();

    private UserManager() {
    }

    /**
     * only way to access the created instance of user manager class
     * as its constructor is private only one instance is created
     * this is called singleton pattern
     */

    public static UserManager getInstance() {
        return instance;
    }

    public User createUser(long Id,
                           String Email,
                           String Password,
                           String first_Name,
                           String last_Name,
                           int Gender,
                           String user_Type) {

        User user = new User();
        user.setEmail(Email);
        user.setUser_Type(user_Type);
        user.setFirst_Name(first_Name);
        user.setGender(Gender);
        user.setID(Id);
        user.setPassword(Password);
        user.setLast_Name(last_Name);

        return user;

    }
    public User[] getUsers(){
        return dao.getUsers();
    }
}



