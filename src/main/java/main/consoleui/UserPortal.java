package main.consoleui;

import main.controller.UserController;
import main.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import presenter.UserPortalPresenter;

import java.util.Scanner;

/**
 * Console UI to act as a student portal for user to perform activties such as
 * showing account info, updating account info
 */
@Component
public class UserPortal {
    @Autowired
    private UserController userController;

    @Autowired
    private ListingPortal listingPortal;

    private final UserPortalPresenter userPortalPresenter = new UserPortalPresenter();

    public void showUserPortal(Scanner scanner, User user) {
        userPortalPresenter.showStudentPortal();

        userPortalPresenter.printAskForCommandMessage();
        String command = scanner.nextLine();

        while (!command.equals("exit")) {
            if (command.equals("profile")) {
                userController.displayStudent(user.getUsername());

            } else if (command.equals("update") && !user.getUsername().equals("Guest")) {
                userPortalPresenter.printUpdateExample();
                String[] info = scanner.nextLine().split(",");
                String firstName = info[0];
                String lastName = info[1];
                String address = info[2];

                User newStudentInfo = User.builder().username(user.getUsername()).password(user.getPassword()).firstName(firstName).lastName(lastName).email(user.getEmail()).address(address).build();

                if (userController.updateStudent(newStudentInfo)) {
                    userPortalPresenter.printUpdateSuccess();
                } else {
                    userPortalPresenter.printUpdateFailed();
                }
            } else if (command.equals("listing") && user.getUsername().equals("Guest")) {
                listingPortal.ListingGuest(scanner);
            } else if (command.equals("listing") && !user.getUsername().equals("Guest")) {
                listingPortal.ListingUser(scanner, user);
            } else {
                userPortalPresenter.incorrectCommandMessage();
            }

            userPortalPresenter.printAskForCommandMessage();
            command = scanner.nextLine();
        }

        // command is not equal to 'exit'
        System.exit(1);
    }
}