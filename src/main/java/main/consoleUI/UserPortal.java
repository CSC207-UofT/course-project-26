package main.consoleUI;

import main.controller.UserController;
import main.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Console UI to act as a student portal for user to perform activties such as
 * showing account info, updating account info
 */
@Component
public class UserPortal {
    @Autowired
    private UserController userController;

    private void printAskForCommandMessage() {
        System.out.print(" Enter command (profile,update,exit)=> ");
    }

    public void showUserPortal(Scanner scanner, User user) {
        System.out.println("\n\n=== STUDENT PORTAL ===" +
                "\n1) Type 'profile' to show your user information" +
                "\n2) Type 'update' to update your info" +
                "\n3) Type 'exit' to exit the system" +
                "\n==================");

        printAskForCommandMessage();
        String command = scanner.nextLine();

        while (!command.equals("exit")) {
            if (command.equals("profile")) {
                userController.displayStudent(user.getUsername());

            } else if (command.equals("update") && !user.getUsername().equals("Guest")) {
                System.out.print("Enter first name, last name and address separated by comma " +
                        "(for example: tien,han, 123 Happy Street)\n Enter here => ");
                String[] info = scanner.nextLine().split(",");
                String firstName = info[0];
                String lastName = info[1];
                String address = info[2];

                User newStudentInfo = User.builder().username(user.getUsername()).password(user.getPassword()).firstName(firstName).lastName(lastName).email(user.getEmail()).address(address).build();

                if (userController.updateStudent(newStudentInfo)) {
                    System.out.println("Student info successfully updated!");
                } else {
                    System.out.println("Student info update failed!");
                }
            } else {
                System.out.println("No such command!");
            }

            printAskForCommandMessage();
            command = scanner.nextLine();
        }

        // command is not equal to 'exit'
        System.exit(1);
    }
}