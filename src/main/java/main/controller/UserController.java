package main.controller;

import main.entity.User;
import main.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import main.presenter.UserPortalPresenter;

@Component
public class UserController {

    @Autowired
    private UserService studentService;

    private final UserPortalPresenter userPortalPresenter = new UserPortalPresenter();

    public void displayStudent(String username) {
        User user = studentService.getUserByUsername(username);
        userPortalPresenter.printStudentInfo(user);
    }


    public boolean updateStudent(User newUser) {
        User oldUser = studentService.getUserByUsername(newUser.getUsername());

        String email = newUser.getEmail();
        boolean email_is_valid = email.matches("^[a-zA-Z0-9.]+@mail.utoronto.[a-zA-Z0-9]+$");

        if (!email_is_valid) {
            userPortalPresenter.printInvalidEmail();
        }

        if (oldUser != null && StringUtils.isAlpha(newUser.getFirstName())
                && StringUtils.isAlpha(newUser.getLastName())
                && email_is_valid
                && !newUser.getAddress().isEmpty()) {

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