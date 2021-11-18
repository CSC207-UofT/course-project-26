package main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    private String username;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String address;

    /**
     * Creates an instance of User
     *
     * @param username the user's username
     * @param firstName the user's firstName
     * @param lastName the user's lastName
     */
    public User(String username, String firstName, String lastName, String email, String address) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    /**
     * Sets the user's address
     *
     * @param address the new address for User
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the address of a User
     *
     * @return the String representation of the User's address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Sets the user's email
     *
     * @param email the new email for User
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the email of a User
     *
     * @return the String representation of the User's email
     */
    public String getEmail() {
        return this.email;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {


        private String username;

        private String password;

        private String firstName;

        private String lastName;

        private String email;

        private String address;

        public UserBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public UserBuilder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public UserBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(username, firstName, lastName, email, address);
        }

    }

}


