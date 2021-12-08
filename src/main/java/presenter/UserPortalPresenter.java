package presenter;

import main.entity.User;
import org.springframework.stereotype.Component;


/**
 * A presenter that prints messages for UserPortal's
 */
@Component
public class UserPortalPresenter {

    public void showStudentPortal(){
        System.out.println("\n\n=== STUDENT PORTAL ===" +
                "\n1) Type 'profile' to show your user information" +
                "\n2) Type 'update' to update your info" +
                "\n3) Type 'listing' to view, sell, or buy books (guests can only view the listing)" +
                "\n4) Type 'exit' to exit the system" +
                "\n==================");
    }

    public void printAskForCommandMessage() {
        System.out.print(" Enter command (profile,update,listing,exit)=> ");
    }

    public void printUpdateExample(){
        System.out.print("Enter first name, last name and address separated by comma " +
                "(for example: tien,han, 123 Happy Street)\n Enter here => ");
    }

    public void printUpdateSuccess(){System.out.println("Student info successfully updated!");}

    public void printUpdateFailed(){System.out.println("Student info update failed!");}

    public void incorrectCommandMessage(){System.out.println("No such command!");}

    public void printInvalidEmail(){System.out.println("Invalid uoft email");}

    public void printStudentInfo(User user) {
        String info = String.format("Username: %s \n" + "First Name: %s \n" +
                        "Last Name: %s \n" + "Email: %s \n" + "Address: %s \n",
                user.getUsername(), user.getFirstName(),
                user.getLastName(), user.getEmail(), user.getAddress());
        System.out.println(info);
    }

    public void printInvalidInput(){System.out.println("Invalid input");}

}
