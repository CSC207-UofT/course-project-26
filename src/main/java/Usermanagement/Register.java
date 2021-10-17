package Usermanagement;

import java.util.ArrayList;

import Users.User;

public class Register {


//    * Store the information password
//    * Store a list of User.md in a file
//    * Add/remove User.md in a file - method
//    * Getter for all information in the file - getter
//    * Read the file that stored all the information for User.md

    private ArrayList<User> userList = new ArrayList<>();

    public void addUser(User user) {
            userList.add(user);
    }

}
