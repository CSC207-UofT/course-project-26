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

        String info = String.format(
                "Id: %s \n" + "Username: %s \n" + "Email: %s \n" + "Address: %s \n",
                user.getId(), user.getUsername(), user.getEmail(), user.getaddress());
        System.out.println(info);
    }

    public boolean updateStudent(User newUser) {
        User oldStudent = studentService.getUserByUsername(newUser.getUsername());

        if (oldStudent != null && StringUtils.isAlpha(newUser.getUsername())
                && StringUtils.isAlpha(newUser.getEmail())
                && StringUtils.isAlpha(newUser.getaddress())) {
            oldStudent.setUsername(newUser.getUsername());
            oldStudent.setEmail(newUser.getEmail());
            oldStudent.setaddress(newUser.getaddress());

            studentService.saveOrUpdate(oldStudent);

            return true;
        }

        return false;
    }
}