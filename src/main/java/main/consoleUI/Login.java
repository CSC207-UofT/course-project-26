package main.consoleUI;

import main.controller.LoginController;
import main.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;


/**
 * Console UI to ask user for login input
 */

@Component
public class Login {
    @Autowired
    private LoginController loginController;

    public User loginUser(Scanner scanner) {
        System.out.print(" Enter user name => ");
        String userName = scanner.nextLine();

        System.out.print(" Enter password => ");
        String password = scanner.nextLine();

//        System.out.print(" Enter email => ");
//        String email = scanner.nextLine();
//
//        System.out.print(" Enter address => ");
//        String address = scanner.nextLine();

        User loggedInStudent = loginController.login(userName, password
//                , email, address
        );

        if (loggedInStudent != null) {
            System.out.println(String.format(" User %s successfully logged-in", loggedInStudent.getUsername()));
            return loggedInStudent;
        }

        System.out.println(" Invalid userName of password");

        return null;
    }
}
