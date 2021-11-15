package main.usecase;

import java.util.List;

import main.entity.Account;

public interface AccountManager {
    /**
     * Change the username
     * @param userId the Account ID
     * @param username the new username
     */
    void changeUsername(String userId, String username);

    /**
     * Change the password
     * @param userId the Account ID
     * @param password the new password
     */
    void changePassword(String userId, String password);

    /**
     * Get a list of usernames
     * @return list of usernames
     */
    List<String> getUsernames() ;

    /**
     * Check whether username exists
     * @param username that wants to be checked
     * @return True iff the name exist
     */
    boolean checkUsername(String username) ;

    /**
     * Check the password
     * @param username of an Account
     * @param password of an Account
     * @return True iff the username and password is correct
     */
    boolean checkPassword(String username, String password) ;

    /**
     * Get the username by ID
     * @param id of an Account
     * @return A string of username by its id
     */
    String usernameById(String id);

    // String toStringByAccountId(String id);

    /**
     * Get a list of account object
     * @return List of Account object
     */
    List<Account> getAccountList();

    /**
     * Get a list of account id list
     * @return List of String of Account IDs
     */
    List<String> getAccountIdList();

    /**
     * Find the Account by the Id
     * @param id of an Account
     * @return Account Object
     */
    Account findAccountById(String id);
}
