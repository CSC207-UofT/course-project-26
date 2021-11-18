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
public class StudentPortal {
    @Autowired
    private UserController studentController;

    public void showStudentPortal(Scanner scanner, String username, String password) {
        System.out.println("\n\n=== STUDENT PORTAL ===" +
                "\n1) Type 'profile' to show your student information" +
                "\n2) Type 'update' to update your info" +
                "\n3) Type 'exit' to exit the system" +
                "\n==================");

        printAskForCommandMessage();
        String command = scanner.nextLine();

        while (!command.equals("exit")) {
            if (command.equals("profile")) {
                studentController.displayStudent(username);
            } else if (command.equals("update")) {
                System.out.print("Enter username and email and address separated by comma (for example: david123@gmail.com, 101 Happy Street)\n Enter here => ");
                String[] info = scanner.nextLine().split(",");
                String email = info[0];
                String address = info[1];

                User newStudentInfo = User.builder().username(username).password(password).email(email).address(address).build();
//                User newStudentInfo = User.builder().username(username).password(password).email(email).address(address).build();

                if (studentController.updateStudent(newStudentInfo)) {
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

    private void printAskForCommandMessage() {
        System.out.print(" Enter command (profile,update,exit)=> ");
    }
}
