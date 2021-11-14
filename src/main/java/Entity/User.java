package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends Account implements Serializable {
    private List<String> inventory = new ArrayList<>();  // a list of item IDs; each item ID must be unique
    private List<String> wishlist = new ArrayList<>();  // a list of item IDs; each item ID must be unique
    private String email;
    private String address;

    /**
     * Creates an instance of User
     *
     * @param username the user's username
     * @param password the user's password
     */
    public User(String username, String password, String email, String address) {
        super(username, password);
        setId("@User" + getId());
        this.email = email;
        this.address = address;
    }

    /**
     * Returns the user's inventory of items, represented by unique IDs
     *
     * @return an List of Strings representing the user's inventory of item IDs
     */
    public List<String> getInventory() {
        return inventory;
    }

    /**
     * Returns the user's wishlist of items, represented by unique IDs
     *
     * @return an list of Strings representing the user's wishlist of item IDs
     */
    public List<String> getWishlist() {
        return wishlist;
    }

    /**
     * Sets the user's inventory list to a given ArrayList of item IDs
     *
     * @param inventory a List of item IDs that this user's inventory will be set to
     */
    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }

    /**
     * Sets the user's wishlist list to a given ArrayList of item IDs
     *
     * @param wishlist a List of item IDs that this user's wishlist will be set to
     */
    public void setWishlist(List<String> wishlist) {
        this.wishlist = wishlist;
    }

    /**
     * Adds an Listing ID to the user's inventory if it doesn't already exist
     *
     * @param ListingId the item ID of an Item that this user is willing to lend
     * @return true iff the item ID is added to the user's inventory
     */
    public boolean addToInventory(String ListingId) {
        if (inventory.contains(ListingId)) {
            return false;
        } else {
            inventory.add(ListingId);
            return true;
        }
    }

    /**
     * Removes an Listing ID from the user's inventory if it exists
     *
     * @param ListingId the item ID of an Item that this user would like to remove from their inventory
     * @return true iff the item ID is present in and removed from the user's inventory
     */
    public boolean removeFromInventory(String ListingId) {
        if (!inventory.contains(ListingId)) {
            return false;
        } else {
            inventory.remove(ListingId);
            return true;
        }
    }

    /**
     * Adds an Listing ID to the user's wishlist if it doesn't already exist
     *
     * @param ListingId the item ID of an Item that this user is wishing to buy
     * @return true iff the item ID is added to the user's wishlist
     */
    public boolean addToWishlist(String ListingId) {
        if (wishlist.contains(ListingId)) {
            return false;
        } else {
            wishlist.add(ListingId);
            return true;
        }
    }

    /**
     * Removes an Listing ID from the user's wishlist if it exists
     *
     * @param ListingId the item ID of an Item that this user would like to remove from their wishlist
     * @return true iff the item ID is present in and removed from the user's wishlist
     */
    public boolean removeFromWishlist(String ListingId) {
        if (!wishlist.contains(ListingId)) {
            return false;
        } else {
            wishlist.remove(ListingId);
            return true;
        }
    }

    /**
     * Sets the user's address
     *
     * @param address the new address for User
     */
    public void setaddress(String address) {
        this.address = address;
    }

    /**
     * Gets the address of a User
     *
     * @return the String representation of the User's address
     */
    public String getaddress() {
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
    @Override
    public String toString() {
        return "Username: " + getUsername() + "\nAccount type: User" + "\nEmail: " + getEmail() + "\nAddress: " +
                getaddress() ;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {

        private String username;
        private String password;
        private String email;
        private String address;

        public UserBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(final String password) {
            this.password = password;
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
            return new User(username, password, email, address);
        }

    }

}


