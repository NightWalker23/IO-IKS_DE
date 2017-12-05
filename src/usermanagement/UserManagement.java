/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package iksde.usermanagement;

import java.util.ArrayList;
import java.util.List;

public class UserManagement implements IUserManagement {

    List<User> userList;

	public UserManagement() {
        userList = new ArrayList<>();
    }

	/**
	 * Create new user
	 * @param username
	 */
	@Override
    public void createUser(String username) {

        User user = new User(username);
        userList.add(user);
		System.out.println( "Dodano nowego użytkownika:\n\tID: " + user.getUserID() + "\n\tUsername: " + user.getUsername() + "\n" );
	}

	/**
	 * Remove user by userID
	 * @param userID
	 */
	@Override
    public void deleteUser(int userID) {

        for (User user : userList) {
            if (user.getUserID() == userID) {
				System.out.println( "Usunięto użytkownika:\n\tID: " + user.getUserID() + "\n\tUsername: " + user.getUsername() + "\n" );
                userList.remove(user);
                break;
            }
        }
    }

	/**
	 * @return list of the users
	 */
	@Override
    public List<User> getUserList() {
        return userList;
    }

}
