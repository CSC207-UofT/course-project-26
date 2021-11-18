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

    public void showUserPortal(Scanner scanner, String username) {
        System.out.println("\n\n=== STUDENT PORTAL ===" +
                "\n1) Type 'profile' to show your student information" +
                "\n2) Type 'update' to update your info" +
                "\n3) Type 'exit' to exit the system" +
                "\n==================");

        printAskForCommandMessage();
        String command = scanner.nextLine();

        while (!command.equals("exit")) {
            if (command.equals("profile")) {
                userController.displayStudent(username);

            } else if (command.equals("update")) {
                System.out.print("Enter first name, last name, email and address separated by comma " +
                        "(for example: tien,han,hantien2002@gmail.com,123 Happy Street)\n Enter here => ");
                String[] info = scanner.nextLine().split(",");
                String firstName = info[0];
                String lastName = info[1];
                String email = info[2];
                String address = info[3];

                User newStudentInfo = User.builder().username(username).firstName(firstName).lastName(lastName).email(email).address(address).build();

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