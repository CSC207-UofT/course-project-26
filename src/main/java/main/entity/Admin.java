package main.entity;

import java.io.Serializable;

public class Admin extends Account implements Serializable {
    /**
     * Creates an instance of Admin
     * @param username the Admin's username
     * @param password the Admin's password
     */
    public Admin(String username, String password) {
        super(username, password);
        setId("@Admin" + getId());
    }

    /**
     * Represents the current admin by their username and account type
     * @return the username and account type separated by a newline
     */
    @Override
    public String toString() {
        return "Username: " + getUsername() + "\nAccount type: Administrative";
    }
}
