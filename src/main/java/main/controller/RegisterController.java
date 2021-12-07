package main.controller;

import main.entity.User;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import presenter.RegisterPresenter;

import java.util.List;
import java.util.Objects;

@Component
public class RegisterController {

    @Autowired
    private UserService studentService;

    private final RegisterPresenter registerPresenter = new RegisterPresenter();

    public User register(String username, String password, String firstname, String lastname,
                         String email, String address) {

        List<User> users = studentService.findAll();

        for (User user: users){
            if (user.getUsername().equals(username)) {
                registerPresenter.printInvalidUsername();
                return null;
            }
            if (Objects.equals(user.getEmail(), email)){
                registerPresenter.printInvalidEmail();
                return null;
            }
        }

        User new_user = studentService.createUser(username, password, firstname, lastname, email, address);
        studentService.saveOrUpdate(new_user);
        return new_user;

    }
}
