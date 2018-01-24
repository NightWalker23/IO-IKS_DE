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
	 *
	 * @param username name of the new user
	 * @param permissionLevel permission level of the new user
	 */
	void createUser(String username, int permissionLevel);

	/**
	 * Delete user
	 * @param userID id of the user
	 */
    void deleteUser(int userID);
    
    /**
     * @return list of the users
     */
    List<User> getUserList();
}
