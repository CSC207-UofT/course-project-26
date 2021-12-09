package main;

import main.entity.User;
import main.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import main.consoleui.Register;
import main.consoleui.Login;
import main.consoleui.UserPortal;
import main.presenter.LoginPresenter;

import java.util.Objects;
import java.util.Scanner;

/**
 * Main application starting point.
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
    private UserPortal userPortal;

    @Autowired
    private UserService userService;

    private final LoginPresenter loginPresenter = new LoginPresenter();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        boolean userIsLoggedIn = false;
        Scanner scanner = new Scanner(System.in);
        User loggedInStudent = null;

        loginPresenter.welcomeMessage();
        String selection = scanner.nextLine();

        if (Objects.equals(selection, "2")) {
            while (!userIsLoggedIn) {
                loggedInStudent = login.loginUser(scanner);
                userIsLoggedIn = loggedInStudent != null;
            }
            userPortal.showUserPortal(scanner, loggedInStudent);
        } else if (Objects.equals(selection, "1")) {
            while (!userIsLoggedIn) {
                loggedInStudent = register.registerUser(scanner);
                userIsLoggedIn = loggedInStudent != null;
            }
        } else {
            loggedInStudent = userService.getUserByUsername("Guest");
        }
        userPortal.showUserPortal(scanner, loggedInStudent);

    }
}