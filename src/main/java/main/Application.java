package main;

import main.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import main.consoleUI.Register;
import main.consoleUI.Login;
import main.consoleUI.StudentPortal;

import java.util.Objects;
import java.util.Scanner;


/**
 *  Main application starting point.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory
            .getLogger(Application.class);

    @Autowired
    private Register register;

    @Autowired
    private Login login;

    @Autowired
    private StudentPortal studentPortal;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        boolean userIsLoggedIn = false;
        Scanner scanner = new Scanner(System.in);
        User loggedInStudent = null;

        System.out.println("Please enter 1 to register, 2 to login, or any key to continue as guest");
        String selection = scanner.nextLine();
        if (Objects.equals(selection, "2")){
                while (!userIsLoggedIn) {
                    loggedInStudent = login.loginUser(scanner);
                    userIsLoggedIn = loggedInStudent != null;
                }
                studentPortal.showStudentPortal(scanner, loggedInStudent.getUsername());
        } else if (Objects.equals(selection, "1")) {
            while (!userIsLoggedIn) {
                loggedInStudent = register.registerUser(scanner);
                userIsLoggedIn = loggedInStudent != null;
            }
        } else{
                while (true) {
                    studentPortal.showStudentPortal(scanner, "guest");
                    }
                }
        while (true) {
            studentPortal.showStudentPortal(scanner, loggedInStudent.getUsername());
        }

    }

}





