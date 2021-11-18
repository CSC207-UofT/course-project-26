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
public class LoginController {
    @Autowired
    private UserService userService;

    public User login(String username, String password) {

        User user = userService.getUserByUsername(username);

        if (user != null && password.equals(user.getPassword())) {
            return user;
        }

        return null;
    }
}

