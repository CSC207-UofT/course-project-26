package main.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends Account implements Serializable {

    @ElementCollection
    private List<String> inventory = new ArrayList<>();  // a list of books IDs; each book ID must be unique

    @ElementCollection
    private List<String> shoppingcart = new ArrayList<>();

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
    public User(String username, String password, String firstName, String lastName, String email, String address) {
        super();
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public User() {

    }

    /**
     * Returns the user's inventory of items, represented by unique IDs
     *
     * @return an List of Strings representing the user's inventory of book IDs
     */
    public List<String> getInventory() {
        return inventory;
    }

    /**
     * Returns the user's shoppingcart of books, represented by unique IDs
     *
     * @return an list of Strings representing the user's shoppingcart of books IDs
     */
    public List<String> getShoppingcart() {
        return shoppingcart;
    }

    /**
     * Sets the user's inventory list to a given ArrayList of books IDs
     *
     * @param inventory a List of books IDs that this user's inventory will be set to
     */
    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }

    /**
     * Sets the user's shoppingcart list to a given ArrayList of books IDs
     *
     * @param shoppingcart a List of books IDs that this user's shoppingcart will be set to
     */
    public void setShoppingcart(List<String> shoppingcart) {
        this.shoppingcart = shoppingcart;
    }

    /**
     * Adds a book ID to the user's inventory if it doesn't already exist
     *
     * @param bookId the book ID of a book that this user is willing to sell
     * @return true iff the book ID is added to the user's inventory
     */
    public boolean addToInventory(String bookId) {
        if (inventory.contains(bookId)) {
            return false;
        } else {
            inventory.add(bookId);
            return true;
        }
    }

    /**
     * Removes a book ID from the user's inventory if it exists
     *
     * @param bookId the book ID of an Item that this user would like to remove from their inventory
     * @return true iff the book ID is present in and removed from the user's inventory
     */
    public boolean removeFromInventory(String bookId) {
        if (!inventory.contains(bookId)) {
            return false;
        } else {
            inventory.remove(bookId);
            return true;
        }
    }

    /**
     * Adds a book ID to the user's shoppingcart if it doesn't already exist
     *
     * @param bookId the book ID of a book that this user is wishing to buy
     * @return true iff the item ID is added to the user's wishlist
     */
    public boolean addToshoppingcart(String bookId) {
        if (shoppingcart.contains(bookId)) {
            return false;
        } else {
            shoppingcart.add(bookId);
            return true;
        }
    }

    /**
     * Removes a book ID from the user's wishlist if it exists
     *
     * @param bookId the ID of a book that this user would like to remove from their shoppingcart
     * @return true iff the book ID is present in and removed from the user's shoppingcart
     */
    public boolean removeFromshoppingcart(String bookId) {
        if (!shoppingcart.contains(bookId)) {
            return false;
        } else {
            shoppingcart.remove(bookId);
            return true;
        }
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

    /**
     * Returns a String that describes this user by their username and current status
     *
     * @return a String representation of the user
     */

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

    @Override
    public String toString() {
        return "Username: " + getUsername() + "\nEmail: " + getEmail() + "\nAddress: " +
                getAddress() ;
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

        public UserBuilder password(final String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(username, password, firstName, lastName, email, address);
        }

    }

}


