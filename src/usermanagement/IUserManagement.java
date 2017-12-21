/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package usermanagement;

import java.util.List;

/**
 * Provides management functionality to user database
 */
public interface IUserManagement {
    
    /**
     * Add user
     * @param username
     */
    void createUser(String username, int permissionLevel);

	/**
	 * Delete user
	 * @param userID
	 */
    void deleteUser(int userID);
    
    /**
     * @return list of the users
     */
    List<User> getUserList();
}
