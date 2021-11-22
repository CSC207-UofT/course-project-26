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

        List<User> users = studentService.findAll();

        for (User user: users){
            if (user.getUsername().equals(username)) {
                System.out.println("The username has been taken!");
                return null;
            }
            if (Objects.equals(user.getEmail(), email)){
                System.out.println("This email address has already been registered.");
                return null;
            }
        }

        User new_user = studentService.createUser(username, password, firstname, lastname, email, address);
        studentService.saveOrUpdate(new_user);
        return new_user;

    }
}
