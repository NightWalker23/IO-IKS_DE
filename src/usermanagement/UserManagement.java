/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package usermanagement;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManagement implements IUserManagement, IUserData {

    List<User> userList;
	private int autoinc = 0;
	File file = new File("userBase.xd");

	private static UserManagement userManagement=null;

	private UserManagement() {
        userList = new ArrayList<>();

		if(!file.isFile())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

			User root = new User("root",0, autoinc++);
			userList.add(root);
			createBaseFromUserList();
		}
        else {
			readUserListFromBase();
		}
	}

	/**
	 *
	 * @return instance of UserManagement
	 */
	public static UserManagement getInstance(){
		if(userManagement==null)
			userManagement = new UserManagement();
		return userManagement;
	}

	/**
	 * Read users from file and saves it to userList
	 */
	public void readUserListFromBase()
	{
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			userList = (List<User>) in.readObject();
			autoinc = userList.get(userList.size()-1).getUserID()+1;
			in.close();
			fileIn.close();
		}
		catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates new file and saves userlist to this file
	 */
	public void createBaseFromUserList()
	{
		try {
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(userList);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create new user
	 * @param username
	 */
	@Override
    public void createUser(String username, int permissionLevel) {

		boolean isAvailable = true;
		for (User user : userList) {
			if (user.getUsername().equals(username)) {
				System.out.println( "Ta nazwa użytkownika jest już zajęta!\n" );
				isAvailable = false;
				break;
			}
		}

		if ( isAvailable ) {
			User user = new User(username, permissionLevel, autoinc++);
			userList.add(user);
			createBaseFromUserList();
			System.out.println( "Dodano nowego użytkownika:\n\tID: " + user.getUserID() + "\n\tUsername: " + user.getUsername() + "\n" );
		}
	}

	/**
	 * Remove user by userID
	 * @param userID
	 */
	@Override
    public void deleteUser(int userID) {
		boolean ifUserIdFound = false;
        for (User user : userList) {
            if (user.getUserID() == userID) {
				System.out.println( "Usunięto użytkownika:\n\tID: " + user.getUserID() + "\n\tUsername: " + user.getUsername() + "\n" );
                userList.remove(user);
				createBaseFromUserList();
				ifUserIdFound = true;
                break;
            }
        }
        if(!ifUserIdFound)
        	System.out.println("Nie znaleziono użytkownika o podanym id");
    }

	/**
	 * @return list of the users
	 */
	@Override
    public List<User> getUserList() {

        return userList;
    }

	/**
	 *
	 * @param login
	 * @return password
	 */
	@Override
	public String getUserPassword(String login) {

		String password = null;
		for (User user : userList) {
			if (user.getUsername() == login) {
				password = user.getPassword();
				break;
			}
		}
		return password;
	}

	/**
	 *
	 * @param login
	 * @return userID
	 */
	@Override
	public int getID(String login) {

		int ID = -1;
		for (User user : userList) {
			if (user.getUsername() == login) {
				ID = user.getUserID();
				break;
			}
		}
		return ID;
	}

	/**
	 *
	 * @param login
	 * @return permissionLevel
	 */
	@Override
	public int getPermissionLevel(String login) {

		int permissionLevel = -1;
		for (User user : userList) {
			if (user.getUsername() == login) {
				permissionLevel = user.getPermissionLevel();
				break;
			}
		}
		return permissionLevel;
	}

	@Override
	public Map<Integer, String> getUsersMap () {

		List<User> localUsers = null;

		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			localUsers = (List<User>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Map<Integer, String> usersMap = new HashMap<>();

		for ( User el : localUsers )
			usersMap.put( el.getUserID(), el.getUsername() );

		return usersMap;
	}


}
