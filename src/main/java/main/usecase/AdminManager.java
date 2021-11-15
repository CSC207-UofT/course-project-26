package main.usecase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.entity.Account;
import main.entity.Admin;

public class AdminManager implements AccountManager{
    private Map<String, Admin> adminIdToUser = new HashMap<>();

    /**
     * Creates an instance of AdminManager with a list of Admin and a list of usernames
     */
    public AdminManager(List<Admin> allAdmin) {
        for (Admin admin: allAdmin) {
            this.adminIdToUser.put(admin.getId(), admin);
        }
    }

    /**
     * Gets the Map of all admin IDs with the Admin entity
     * @return Map<String, Admin> of admin IDs and Admin
     */
    public Map<String, Admin> getAdminIdToUser() {
        return this.adminIdToUser;
    }

    /**
     * Adds an admin to the system
     * @param newUsername the username of a new Admin account
     * @param newPassword the password of a new Admin account
     */
    public void addAdmin(String newUsername, String newPassword) {
        Admin newAdmin = new Admin(newUsername, newPassword);
        Map<String, Admin> hm = getAdminIdToUser();
        hm.put(newAdmin.getId(), newAdmin);
    }

    /**
     * Returns Admin entity based on the adminId
     * @param adminId the admin id of an admin
     * @return the Admin with this admin id
     */
    public Admin findAccountById(String adminId) {
        return adminIdToUser.get(adminId);
    }

    private Admin findAdminByUsername(String username) {
        Map<String, String> userUsernameToId = new HashMap<>();
        for (Map.Entry <String, Admin> entry : getAdminIdToUser().entrySet()) {
            userUsernameToId.put(entry.getValue().getUsername(), entry.getKey());
        }
        String userId = userUsernameToId.get(username);
        return  findAccountById(userId);
    }

    /**
     * Returns the username of the Admin associated with a given admin id.
     * @param userId the admin ID to look up
     * @return the associated username
     */
    public String usernameById(String userId) {
        return findAccountById(userId).getUsername();
    }

    /**
     * Returns the adminID of the Admin associated with a given username.
     * @param username the username to look up
     * @return the associated admin ID
     */
    public String adminIdByUsername(String username) {
        return findAdminByUsername(username).getId();
    }

    /**
     * Gets admin as a list of usernames
     * @return a List of Admin usernames in this system
     */
    @Override
    public List<String> getUsernames() {
        List<String> usernamesList = new ArrayList<>();
        for (Map.Entry <String, Admin> entry : getAdminIdToUser().entrySet()) {
            usernamesList.add(entry.getValue().getUsername());
        }
        return usernamesList;
    }

    /**
     * Changes the username of an admin with this admin id
     * @param userId the user id of a admin
     * @param username the new username to change to
     */
    @Override
    public void changeUsername(String userId, String username) {
        findAccountById(userId).setUsername(username);
    }

    /**
     * Changes the password of an admin with this admin id
     * @param userId the admin id of an admin
     * @param password the new username to change to
     */
    @Override
    public void changePassword(String userId, String password) {
        findAccountById(userId).setPassword(password);
    }

    /**
     * Checks if the username exists in the AdminManager
     * @param username the username of an Admin
     * @return true iff username exists in the AdminManager
     */
    @Override
    public boolean checkUsername(String username) {
        return getUsernames().contains(username);
    }

    /**
     * Checks if the inputted password is correct
     * @param username the username of an Admin
     * @param password the password input received from an Admin
     * @return true iff the password input matches the username's password
     */
    @Override
    public boolean checkPassword(String username, String password) {
        Admin admin = findAdminByUsername(username);
        return admin.getPassword().equals(password);
    }

    /**
     * @return a list of Account objects (in this case Admins)
     */
    @Override
    public List<Account> getAccountList() {
        List<Account> al = new ArrayList<>();
        for (Map.Entry <String, Admin> entry : getAdminIdToUser().entrySet()) {
            al.add(entry.getValue());
        }
        return al;
    }

    /**
     * @return a list of Account IDs (in this case Admin IDs)
     */
    @Override
    public List<String> getAccountIdList() {
        return new ArrayList<>(getAdminIdToUser().keySet());
    }
}
