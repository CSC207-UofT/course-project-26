package main.presenter;

import org.springframework.stereotype.Component;

/**
 * A main.presenter that prints messages for login information
 */
@Component
public class LoginPresenter implements LPresenter {

    public void welcomeMessage(){
        System.out.println("=== Welcome to UofT BookStore: ===" +
                "\nPlease enter 1 to register, 2 to login, or any key to continue as guest\n  Enter here => ");
    }

    public void askUsername(){
        System.out.print(" Enter username => ");
    }

    public void askPassword(){
        System.out.print(" Enter password => ");
    }

    @Override
    public void loginSuccessMessage(String name){
        System.out.printf(" User %s successfully logged-in%n", name);
    }

    public void loginFailedMessage(){
        System.out.println(" Invalid username or incorrect password, please try again");
    }



}
