/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package usermanagement;

import java.util.Map;

public interface IUserData {

    /**
     *
     * @param login name of the user
     * @return password of the user
     */
    String getUserPassword(String login);

    /**
     *
     * @param login name of the user
     * @return id of the user
     */
    int getID(String login);

    /**
     *
     * @param login name of the user
     * @return permision level of the user
     */
    int getPermissionLevel(String login);

	/**
	 *
	 * @return map of Users (userID, username)
	 */
	Map<Integer, String> getUsersMap();
}
