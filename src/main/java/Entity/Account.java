package Entity;

import java.io.Serializable;
import java.util.UUID;

/**
 * Represents an account in the system; an abstract class that is extended by the User and Admin classes
 *
 * id: the unique identifier for an Account
 * username: the username for an Account
 * password: the password for an Account
 */

public abstract class Account implements Serializable {
    private String id;
    private String username;
    private String password;

    /**
     * Creates an Account
     * @param username the username of the account
     * @param password the password of the account
     */
    public Account(String username, String password) {
        UUID inputId = UUID.randomUUID();  // creates a UUID at instantiation
        this.id = String.valueOf(inputId);
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the account's ID
     * @return a String that represents the account's ID
     */
    public String getId() {
        return id;
    }

    public void setId(String accountId) {
        this.id = accountId;}

    /**
     * Gets the account's username
     * @return a String that represents the account's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the account's password
     * @return a String that represents the account's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Changes this account's username
     * @param username the new username of this account
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Changes this account's password
     * @param password the new password of this account
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a String that describes this account; abstract method to be implemented in the User and Admin classes
     * @return a String representation of the account
     */
    public abstract String toString();

}
