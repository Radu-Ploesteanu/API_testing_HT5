package org.example.userstest;


import org.example.entities.User;
import org.example.steps.UserServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class UserServiceTest {

    @Test
    public void getAllUsersTest() {
        List<User> users = UserServiceSteps.getAllUsers();
        Assert.assertEquals(users.size(), 10, "The amount of users doesn't equal to actual user number");
    }

    @Test
//    @Test(dependsOnMethods = "getAllUsersTest")       //->> this is to make sure they both work (server issue)
    public void createUserTest () {
        User expectedUser = createUser();
        User actualUser = UserServiceSteps.createUser(expectedUser);

        Assert.assertEquals(actualUser.getName(), expectedUser.getName(), "The two users do not match");
    }

    private User createUser() {
        Random random = new Random();
//        BEFORE
//        User user = new User();
//        user.setId(222);
//        user.setEmail("testEmail" + random.nextInt() + "@gmail.com")
//        user.setName("test" + random.nextInt());
//        user.setStatus("Active");

//        return new User();

//        With @Accessors from lombok
        return new User()
                .setName("test" + random.nextInt())
                .setEmail("testEmail" + random.nextInt() + "@gmail.com")
                .setGender("Male")
                .setStatus("active");
    }
}
