/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package iksde.usermanagement;

public class User {

    private int userID;
    private String username;
    private String password;

    private static int autoinc = 0;

    /**
     * Create a new user
     * @param username
     */
    public User(String username) {

        this.username = username;
        this.password = "password";
        this.userID = autoinc++;
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
       
}
