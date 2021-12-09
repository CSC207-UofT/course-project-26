package main.presenter;

import org.springframework.stereotype.Component;

/**
 * A main.presenter that prints messages for Registration information
 */
@Component
public class RegisterPresenter implements LPresenter{

    public void askUsername(){
        System.out.print(" Enter your desired user name => ");
    }

    public void askDesiredPassword(){
        System.out.print(" Enter your desired password => ");
    }

    public void askFirstName(){
        System.out.print(" Enter your firstname => ");
    }

    public void askLastName(){
        System.out.print(" Enter your lastname => ");
    }

    public void askEmail(){
        System.out.print(" Enter your UofT email address => ");
    }

    public void askAddress(){
        System.out.print(" Enter your address in Toronto => ");
    }

    public void registrationFailedMessage(){
        System.out.println(" Registration failed, please try again");
    }

    public void printInvalidUsername(){System.out.println("The username has been taken!");}

    public void printInvalidEmail(){System.out.println("This email address has already been registered.");}

    @Override
    public void loginSuccessMessage(String name){
        System.out.printf(" User %s successfully logged-in%n", name);
    }

}
