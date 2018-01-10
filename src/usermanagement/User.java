/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package usermanagement;

import java.io.Serializable;

public class User implements Serializable{

    private int userID;
    private int permissionLevel;
    private String username;
    private String password;

    /**
     * Create a new user
     * @param username
     */
    public User(String username, int permissionLevel, int ID) {

        this.username = username;
        this.password = "password";
        this.userID = ID;
        this.permissionLevel = permissionLevel;
    }

    /**
     *
     * @return userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return permission
     */
    public int getPermissionLevel() {
        return permissionLevel;
    }
}
