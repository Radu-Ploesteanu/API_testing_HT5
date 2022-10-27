package org.example.steps;

import org.example.entities.User;
import org.example.service.UserService;

import java.util.List;

import static org.example.service.uritemplate.UserServiceUri.USERS;

// we move general logic which can be used for 2 or more ...
public class UserServiceSteps {

    private static final UserService USER_SERVICE = UserService.getInstance();

    public static List<User> getAllUsers () {
        return USER_SERVICE
                .getRequest(USERS)
                .jsonPath()
                .getList("", User.class);
    }

    public static User createUser(User expectedUser) {
        return USER_SERVICE
                .postRequest(USERS, expectedUser)
                .as(User.class);
    }
}
