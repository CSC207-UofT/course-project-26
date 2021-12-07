package main.consoleui;

import main.controller.LoginController;
import main.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import presenter.LPresenter;
import presenter.LoginPresenter;

import java.util.Scanner;


/**
 * Console UI to ask user for login input
 */

@Component
public class Login {
    @Autowired
    private LoginController loginController;

    private final LoginPresenter loginPresenter = new LoginPresenter();

    public User loginUser(Scanner scanner) {
        loginPresenter.askUsername();
        String userName = scanner.nextLine();

        loginPresenter.askPassword();
        String password = scanner.nextLine();

        User loggedInStudent = loginController.login(userName, password);

        if (loggedInStudent != null) {
            loginPresenter.loginSuccessMessage(loggedInStudent.getUsername());
            return loggedInStudent;
        }

        loginPresenter.loginFailedMessage();

        return null;
    }
}