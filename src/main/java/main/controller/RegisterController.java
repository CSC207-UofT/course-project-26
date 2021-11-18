package main.controller;

import main.entity.User;
import main.gateway.UserGateway;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class RegisterController {

    @Autowired
    private UserService studentService;
    private UserGateway usergateway;

    public User register(String username, String password, String firstname, String lastname,
                         String email, String address) {

        List<User> users = usergateway.findAll();

        for (User user: users){
            if (user.getUsername().equals(username)) {
                System.out.println("The username has been taken!");
            }
        }

        User new_user = new User(username, firstname, lastname, email, address);
        usergateway.saveOrUpdate(new_user);
        return new_user;

    }
}
