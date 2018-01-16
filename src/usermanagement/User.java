/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package usermanagement;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class User implements Serializable{

    private int userID;
    private int permissionLevel;
    private String username;
    private String password;

	/**
	 * Create a new user
	 * @param username name of the user
	 * @param permissionLevel permission level
	 * @param ID user ID
	 */
    public User(String username, int permissionLevel, int ID) {
        this.username = username;
		this.password = generatePassword( 8 );
        this.userID = ID;
        this.permissionLevel = permissionLevel;
    }

	/**
	 * Generate random password for new user
	 * @param length length of the password
	 * @return random password
	 */
	private String generatePassword ( int length ){
		Random random = new SecureRandom();
		return String.format("%"+length+"s", new BigInteger(length*5, random).toString(32)).replace('\u0020', '0');
	}

    /**
     *
     * @return userID id of the user
     */
    public int getUserID() {
        return userID;
    }

    /**
     *
     * @return username name of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return password password of the user
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return permission permision level of the user
     */
    public int getPermissionLevel() {
        return permissionLevel;
    }
}
