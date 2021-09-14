package Thrillio.Dao;

import Thrillio.DataStore;
import Thrillio.Entities.User;

public class UserDao {
    public User[] getUsers(){
        return DataStore.getUsers();
    }
}
