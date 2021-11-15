import java.util.Scanner;

import ConsoleUI. Register;
import Entity.User;

public class Main {
    /**
     * Action by user is required
     */

    public static void main(String[] args){
        Register new_register = new Register();

        System.out.println("Welcome to UofT Marketplace! Would you like to register? Please type Register or Cancel");

        Scanner sc = new Scanner(System.in);

        String reg_or_cancel = sc.nextLine();

        if (reg_or_cancel.equals("Register")) {
            System.out.println("Hey there! Please enter your username.");
            String in_username = sc.nextLine();
            System.out.println("Please enter your password.");
            String in_password = sc.nextLine();
            System.out.println("Please enter your email.");
            String in_email = sc.nextLine();
            System.out.println("Last step! Please enter your location in the form of your address");
            String in_location = sc.nextLine();
            System.out.println("You're all set! Thanks for your patience :) Enjoy the Marketplace!");

            User new_user = new Entity.User(in_username, in_password, in_email, in_location);
            new_register.addUser(new_user);
        }
        if (reg_or_cancel.equals("Cancel")){
            System.exit(0);
        }
    }
}
