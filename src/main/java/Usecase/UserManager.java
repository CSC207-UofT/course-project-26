package Usecase;

import Entity.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Entity.Account;
import Entity.User;


public class UserManager implements AccountManager{
    private Map<String, User> userIdToUser = new HashMap<>();  // a HashMap with user IDs as keys and User entities as values

    /**
     * Creates an instance of UserManager with a list of Users allUsers
     * @param allUsers a List of Users that the UserManager instance will initially contain
     */
    public UserManager(List<User> allUsers) {
        for (User user: allUsers) {
            this.userIdToUser.put(user.getId(), user);
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
        return userIdToUser.get(userId);
    }

    private User findUserByUsername(String username) {
        Map<String, String> userUsernameToId = new HashMap<>();
        for (Map.Entry <String, User> entry : getUserIdToUser().entrySet()) {
            userUsernameToId.put(entry.getValue().getUsername(), entry.getKey());
        }
        String userId = userUsernameToId.get(username);
        return findAccountById(userId);
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
     * Returns the userID of the User associated with a given username
     * @param username the username to look up
     * @return the associated user ID
     */
    public String userIdByUsername(String username) {
        return findUserByUsername(username).getId();
    }

    /**
     * Checks whether itemId in the userId's wishlist
     * @param userId the user ID of a user
     * @param itemId the item ID of an item
     * @return true iff item Id in the given user Id's user's wishlist
     */
    public boolean itemIdInWishlist(String userId, String itemId) {
        return wishlistByUserId(userId).contains(itemId);
    }

    /**
     * Returns a wishlist item IDs associated with this userId
     * @param userId the user ID of a user
     * @return an ArrayList of ints representing wishlist of items belonging to this user ID
     */
    public List<String> wishlistByUserId(String userId) {
        User user = findAccountById(userId);
        return user.getWishlist();
    }

    /**
     * Adds an item ID to the userId of User's inventory
     * @param userId the user ID of the User
     * @param itemId the item ID of an Item to be added to the User's inventory
     */
    public void addToInventory(String userId, String itemId) {
        User user = findAccountById(userId);
        if (user == null) return;
        user.addToInventory(itemId);
    }

    /**
     * Removes an itemId from the userId's User's inventory if it exists, removes the item from all user's wishlist
     * @param userId the user ID of the User
     * @param itemId the item ID of an Item to be removed from the User's inventory
     */
    public void removeFromInventory(String userId, String itemId) {
        User user = findAccountById(userId);
        List<String> ids = findUserByItemWishlist(itemId);
        for (String id: ids) {
            removeFromWishlist(id, itemId);
        }
        user.removeFromInventory(itemId);
    }

    /**
     * Adds an itemId to the userId's User's wishlist if it doesn't already exist
     * @param userId the user ID of the User
     * @param itemId the item ID of an Item to be added to the User's wishlist
     */
    public boolean addToWishlist(String userId, String itemId) {
        User user = findAccountById(userId);
        if (user.getWishlist().contains(itemId)) {
            return false;
        } else if (user.getInventory().contains(itemId)) {
            return false;
        } else {
            user.addToWishlist(itemId);
            return true;
        }
    }

    /**
     * Removes an itemId from the userId of the User's wishlist if it exists
     * @param userId the user ID of the User
     * @param itemId the item ID of an Item to be removed from the User's wishlist
     */
    public void removeFromWishlist(String userId, String itemId) {
        User user = findAccountById(userId);
        user.removeFromWishlist(itemId);
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
     * @param username the username of a user
     * @param password the password input received from a user
     * @return true iff the password input matches the username's password
     */
    @Override
    public boolean checkPassword(String username, String password) {
        User user = findUserByUsername(username);
        return user.getPassword().equals(password);
    }

    /**
     * Returns userId whose inventory contain itemId
     * @param itemId Id of an item
     * @return the userId whose inventory contains the Item
     */
    public String findUserByItemInventory(String itemId) {
        for (Map.Entry <String, User> entry : getUserIdToUser().entrySet()) {
            if (entry.getValue().getInventory().contains(itemId)){
                return  entry.getKey();
            }
        }
        return "";
    }

    /**
     * Returns userIds whose wishlist contains itemId
     * @param itemId Id of an item
     * @return the List of userId's whose wishlist contains the itemId
     */
    public List<String> findUserByItemWishlist(String itemId) {
        List<String> ids = new ArrayList<>();
        for (Map.Entry <String, User> entry : getUserIdToUser().entrySet()) {
            if (entry.getValue().getWishlist().contains(itemId)){
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
            String[] cityAndCountry = entry.getValue().getaddress().split("-");
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
        return findAccountById(userId).getaddress();
    }

    /**
     * Creates new User entity
     * @param username the username of the new User
     * @param password the password of the new User
     * @param email the email address of the new User
     * @param address the city of the new User
     * @return the id of the new User
     */
    public String createNewUser(String username, String password, String email, String address) {
        User newUser = new User(username, password, address, email);
        addUser(newUser.getId(), newUser);
        return newUser.getId();
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
