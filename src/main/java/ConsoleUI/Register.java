package ConsoleUI;

import Controller.LoginController;
import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;


/**
 * Console UI to ask user for login input
 */

@Component
public class Register {
    @Autowired
    private LoginController loginController;

    public User registerUser(Scanner scanner) {
        System.out.print(" Enter your desired user name => ");
        String userName = scanner.nextLine();

        System.out.print(" Enter your desired password => ");
        String password = scanner.nextLine();

        System.out.print(" Enter your email address => ");
        String email = scanner.nextLine();

        System.out.print(" Enter your address in Toronto => ");
        String address = scanner.nextLine();

        User loggedInStudent = loginController.register(userName, password, email, address);

        if (loggedInStudent != null) {
            System.out.println(String.format(" User %s successfully registered and logged-in", loggedInStudent.getUsername()));
            return loggedInStudent;
        }

        System.out.println(" Register unsuccessfully, please try again");

        return null;
    }
}

