package main.controller;

import main.entity.User;
import main.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {
    @Autowired
    private UserService studentService;

    public void displayStudent(String username) {
        User user = studentService.getUserByUsername(username);

        String info = String.format("Username: %s \n" + "First Name: %s \n" +
                        "Last Name: %s \n" + "Email: %s \n" + "Address: %s \n",
                user.getUsername(), user.getFirstName(),
                user.getLastName(), user.getEmail(), user.getAddress());
        System.out.println(info);
    }


    public boolean updateStudent(User newUser) {
        User oldUser = studentService.getUserByUsername(newUser.getUsername());

        if (oldUser != null && StringUtils.isAlpha(newUser.getFirstName())
                && StringUtils.isAlpha(newUser.getLastName())
                && StringUtils.isAlpha(newUser.getEmail())
                && StringUtils.isAlpha(newUser.getAddress())) {

            oldUser.setFirstName(newUser.getFirstName());
            oldUser.setLastName(newUser.getLastName());
            oldUser.setEmail(newUser.getEmail());
            oldUser.setAddress(newUser.getAddress());

            studentService.saveOrUpdate(oldUser);

            return true;
        }

        return false;
    }

}