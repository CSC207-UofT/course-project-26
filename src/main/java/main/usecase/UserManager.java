package main.usecase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.entity.User;


public class UserManager{
    private final Map<String, User> usernameToUser = new HashMap<>();
    // a HashMap with user IDs as keys and User entities as values

    /**
     * Creates an instance of UserManager with a list of Users allUsers
     * @param allUsers a List of Users that the UserManager instance will initially contain
     */
    public UserManager(List<User> allUsers) {
        for (User user: allUsers) {
            this.usernameToUser.put(user.getUsername(), user);
        }
    }


    /**
     * Return a Map of all Users, with user IDs as keys and User entities as values
     * @return Map<String, User> of all Users in the system
     */
    public Map<String, User> getUsernameToUser() {
        return this.usernameToUser;
    }

    private void addUser(String userId, User user) {
        Map<String, User> hm = getUsernameToUser();
        hm.put(userId, user);
    }

    /**
     * Returns the User object with the given userId
     * @param userId the ID of a User
     * @return the User with this user ID
     */
    public User findAccountById(String userId) {
        return this.usernameToUser.get(userId);
    }

    /**
     * Returns the username of the User associated with a given userId
     * @param userId the user ID to look up
     * @return the associated username
     */
    public String usernameById(String userId) {
        return findAccountById(userId).getUsername();
    }

    /**
     * Changes the username of a user with this userId
     * @param userId the user ID of a user
     * @param username the new username to change to
     */
    public void changeUsername(String userId, String username) {
        findAccountById(userId).setUsername(username);
    }

    /**
     * Changes the password of a user with this userId
     * @param userId the user ID of a user
     * @param password the new username to change to
     */
    public void changePassword(String userId, String password) {
        findAccountById(userId).setPassword(password);
    }

    /**
     * Gets a list of usernames
     * @return a list of String of usernames in this system
     */

    public List<String> getUsernames() {
        List<String> usernamesList = new ArrayList<>();
        for (User user: usernameToUser.values()) {
            usernamesList.add(user.getUsername());
        }
        return usernamesList;
    }

    /**
     * Checks if the username exists in the UserManager
     * @param username the username of a User
     * @return true iff username is in the UserManager
     */
    public boolean checkUsername(String username) {
        return getUsernames().contains(username);
    }

    /**
     * Checks if the inputted password is correct
     * @param userId the ID of a user
     * @param password the password input received from a user
     * @return true iff the password input matches the userid's password
     */

    public boolean checkPassword(String userId, String password) {
        User user = findAccountById(userId);
        return user.getPassword().equals(password);
    }



}
