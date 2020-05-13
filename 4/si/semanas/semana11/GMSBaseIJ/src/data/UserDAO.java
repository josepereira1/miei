package data;

import business.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    Map<String, User> users;

    public UserDAO(){
        users = new HashMap<>();
        users.put("Joana", new User("Joana", "example@email.com", "password"));
        users.put("José", new User("José", "example@email.com", "password"));
        users.put("André", new User("André", "example@email.com", "password"));
        users.put("Ricardo", new User("Ricardo", "example@email.com", "password"));
        users.put("João", new User("João", "example@email.com", "password"));
        users.put("Sílvia", new User("Sílvia", "example@email.com", "password"));
    }

    public boolean login(String username, String password){
        if(users.containsKey(username)) {
            if(users.get(username).getPassword().equals(password))return true;
            else return false;
        }else return false;
    }
}
