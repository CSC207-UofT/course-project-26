package main.consoleui;

import main.controller.RegisterController;
import main.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import presenter.RegisterPresenter;

import java.util.Scanner;


/**
 * Console UI to ask user for registry input
 */

@Component
public class Register {
    @Autowired
    private RegisterController registerController;

    private final RegisterPresenter registerPresenter = new RegisterPresenter();

    public User registerUser(Scanner scanner) {
        registerPresenter.askUsername();
        String username = scanner.nextLine();

        registerPresenter.askDesiredPassword();
        String password = scanner.nextLine();

        registerPresenter.askFirstName();
        String firstname = scanner.nextLine();

        registerPresenter.askLastName();
        String lastname = scanner.nextLine();

        registerPresenter.askEmail();
        String email = scanner.nextLine();

        registerPresenter.askAddress();
        String address = scanner.nextLine();

        User loggedInStudent = registerController.register(username, password, firstname, lastname, email, address);

        if (loggedInStudent != null) {
            registerPresenter.loginSuccessMessage(loggedInStudent.getUsername());
            return loggedInStudent;
        }

        registerPresenter.registrationFailedMessage();

        return null;
    }
}

