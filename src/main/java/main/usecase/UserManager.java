package main.usecase;

import main.entity.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.entity.User;


public class UserManager implements AccountManager{
    private final Map<String, User> userIdToUser = new HashMap<>();  // a HashMap with user IDs as keys and User entities as values

    /**
     * Creates an instance of UserManager with a list of Users allUsers
     * @param allUsers a List of Users that the UserManager instance will initially contain
     */
    public UserManager(List<User> allUsers) {
        for (User user: allUsers) {
            this.userIdToUser.put(user.getUsername(), user);
        }
    }


    /**
     * Return a Map of all Users, with user IDs as keys and User entities as values
     * @return Map<String, User> of all Users in the system
     */
    public Map<String, User> getUserIdToUser() {
        return this.userIdToUser;
    }

    private void addUser(String userId, User user) {
        Map<String, User> hm = getUserIdToUser();
        hm.put(userId, user);
    }

    /**
     * Returns the User object with the given userId
     * @param userId the ID of a User
     * @return the User with this user ID
     */
    @Override
    public User findAccountById(String userId) {
        return this.userIdToUser.get(userId);
    }

    /**
     * Returns the username of the User associated with a given userId
     * @param userId the user ID to look up
     * @return the associated username
     */
    @Override
    public String usernameById(String userId) {
        return findAccountById(userId).getUsername();
    }

    /**
     * Checks whether bookId in the userId's shoppingcart
     * @param userId the user ID of a user
     * @param bookId the item ID of a book
     * @return true iff book Id in the given user Id's user's shoppingcart
     */
    public boolean bookIdInShoppingcart(String userId, String bookId) {
        return ShoppingcartByUserId(userId).contains(bookId);
    }

    /**
     * Returns books IDs in shoppingcart associated with this userId
     * @param userId the user ID of a user
     * @return an ArrayList of ints representing shoppingcart of items belonging to this user ID
     */
    public List<String> ShoppingcartByUserId(String userId) {
        User user = findAccountById(userId);
        return user.getShoppingcart();
    }

    /**
     * Adds a book ID to the userId of User's inventory
     * @param userId the user ID of the User
     * @param bookId the book ID of a book to be added to the User's inventory
     */
    public void addToInventory(String userId, String bookId) {
        User user = findAccountById(userId);
        if (user == null) return;
        user.addToInventory(bookId);
    }

    /**
     * Removes a bookId from the userId's User's inventory if it exists, removes the item from all user's shoppingcart
     * @param userId the user ID of the User
     * @param bookId the item ID of an Item to be removed from the User's inventory
     */
    public void removeFromInventory(String userId, String bookId) {
        User user = findAccountById(userId);
        List<String> ids = findUserByShoppingcart(bookId);
        for (String id: ids) {
            removeFromShoppingcart(id, bookId);
        }
        user.removeFromInventory(bookId);
    }

    /**
     * Adds an bookId to the userId's User's shoppingcart if it doesn't already exist
     * @param userId the user ID of the User
     * @param bookId the book ID of a book to be added to the User's shoppingcart
     */
    public boolean addToShoppingcart(String userId, String bookId) {
        User user = findAccountById(userId);
        if (user.getShoppingcart().contains(bookId)) {
            return false;
        } else if (user.getInventory().contains(bookId)) {
            return false;
        } else {
            user.addToshoppingcart(bookId);
            return true;
        }
    }

    /**
     * Removes an bookId from the userId of the User's shoppingcart if it exists
     * @param userId the user ID of the User
     * @param bookId the item ID of an Item to be removed from the User's shoppingcart
     */
    public void removeFromShoppingcart(String userId, String bookId) {
        User user = findAccountById(userId);
        user.removeFromshoppingcart(bookId);
    }

    /**
     * Changes the username of a user with this userId
     * @param userId the user ID of a user
     * @param username the new username to change to
     */
    @Override
    public void changeUsername(String userId, String username) {
        findAccountById(userId).setUsername(username);
    }

    /**
     * Changes the password of a user with this userId
     * @param userId the user ID of a user
     * @param password the new username to change to
     */
    @Override
    public void changePassword(String userId, String password) {
        findAccountById(userId).setPassword(password);
    }

    /**
     * Gets a list of usernames
     * @return a list of String of usernames in this system
     */
    @Override
    public List<String> getUsernames() {
        List<String> usernamesList = new ArrayList<>();
        for (User user: userIdToUser.values()) {
            usernamesList.add(user.getUsername());
        }
        return usernamesList;
    }

    /**
     * Checks if the username exists in the UserManager
     * @param username the username of a User
     * @return true iff username is in the UserManager
     */
    @Override
    public boolean checkUsername(String username) {
        return getUsernames().contains(username);
    }

    /**
     * Checks if the inputted password is correct
     * @param userId the ID of a user
     * @param password the password input received from a user
     * @return true iff the password input matches the userid's password
     */
    @Override
    public boolean checkPassword(String userId, String password) {
        User user = findAccountById(userId);
        return user.getPassword().equals(password);
    }

    /**
     * Returns userId whose inventory contain bookId
     * @param bookId Id of an item
     * @return the userId whose inventory contains the Item
     */
    public String findUserByItemInventory(String bookId) {
        for (Map.Entry <String, User> entry : getUserIdToUser().entrySet()) {
            if (entry.getValue().getInventory().contains(bookId)){
                return  entry.getKey();
            }
        }
        return "";
    }

    /**
     * Returns userIds whose shoopingcart contains bookId
     * @param bookId Id of an item
     * @return the List of userId's whose shoopingcart contains the bookId
     */
    public List<String> findUserByShoppingcart(String bookId) {
        List<String> ids = new ArrayList<>();
        for (Map.Entry <String, User> entry : getUserIdToUser().entrySet()) {
            if (entry.getValue().getShoppingcart().contains(bookId)){
                ids.add(entry.getKey());
            }
        }
        return ids;
    }

    /**
     * Finds User in the same city and country
     * @param city the city chosen by the user
     * @param country the country chosen by user
     * @return all userIds whose corresponding user with the same city and country as given
     */
    public ArrayList<String> userIdsSameCity(String city, String country) {
        ArrayList<String> al = new ArrayList<>();
        for (Map.Entry <String, User> entry : getUserIdToUser().entrySet()) {
            String[] cityAndCountry = entry.getValue().getAddress().split("-");
            String desiredCity = cityAndCountry[0].trim();
            String desiredCountry = cityAndCountry[1].trim();
            if (desiredCity.equalsIgnoreCase(city.trim()) && desiredCountry.equalsIgnoreCase(country.trim())) {
                al.add(entry.getKey());
            }
        }
        return al;
    }

    /**
     * Returns the cityAddress of a User based on user ID
     * @param userId the Id of an user
     * @return the cityAddress chosen by the user
     */
    public String findPlaceByUserId(String userId) {
        return findAccountById(userId).getAddress();
    }

    /**
     * Creates new User entity
     * @param username the username of the new User
     * @param email the email address of the new User
     * @param address the city of the new User
     * @return the id of the new User
     */
    public String createNewUser(String username, String firstName, String lastName, String email, String address) {
        User newUser = new User(username, firstName, lastName, email, address);
        addUser(newUser.getUsername(), newUser);
        return newUser.getUsername();
    }

    /**
     * Return a list of account (User) objects
     * @return List of account (User) objects
     */
    @Override
    public List<Account> getAccountList() {
        List<Account> al = new ArrayList<>();
        for (Map.Entry <String, User> entry : getUserIdToUser().entrySet()) {
            al.add(entry.getValue());
        }
        return al;
    }

    /**
     * Return a list of account (user) ids
     * @return List of Strings of user IDs
     */
    @Override
    public List<String> getAccountIdList() {
        return new ArrayList<>(getUserIdToUser().keySet());
    }


}
