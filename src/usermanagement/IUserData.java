/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package usermanagement;

import java.util.Map;

public interface IUserData {

    /**
     *
     * @param login
     * @return password
     */
    String getUserPassword(String login);

    /**
     *
     * @param login
     * @return userID
     */
    int getID(String login);

    /**
     *
     * @param login
     * @return permissionLevel
     */
    int getPermissionLevel(String login);

	/**
	 *
	 * @return map of Users (userID, username)
	 */
	Map<Integer, String> getUsersMap();
}
