/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */

package usermanagement;

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
}
