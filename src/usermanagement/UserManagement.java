/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package usermanagement;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManagement implements IUserManagement, IUserData {

    List<User> userList;
    private int autoinc = 0;
    File file = new File("userBase.xd");
    private static UserManagement userManagement = null;

    private UserManagement() {
        userList = new ArrayList<>();

        if (!file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            User root = new User("root", 0, autoinc++);
            HashFunction hf = Hashing.sha256();
            HashCode hc = hf.newHasher().putString(root.getPassword(), Charsets.UTF_8).hash();     
            root.setPassword(hc.toString());
            
            userList.add(root);
            createBaseFromUserList();
        } else {
            readUserListFromBase();
        }
    }

    /**
     *
     * @return instance of UserManagement
     */
    public static UserManagement getInstance() {
        if (userManagement == null)
            userManagement = new UserManagement();

        return userManagement;
    }

    /**
     * Read users from file and saves it to userList
     */
    public void readUserListFromBase() {
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            userList = (List<User>) in.readObject();
            autoinc = userList.get(userList.size() - 1).getUserID() + 1;
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }

    /**
     * Creates new file and saves users from userList to this file
     */
    public void createBaseFromUserList() {
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
     *
     * @param username name of the user
     */
    @Override
    public void createUser(String username, int permissionLevel) {

        boolean isAvailable = true;
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                System.out.println("Ta nazwa użytkownika jest już zajęta!\n");
                isAvailable = false;
                break;
            }
        }

        if (isAvailable) {
            User user = new User(username, permissionLevel, autoinc++);
            userList.add(user);
            createBaseFromUserList();
            System.out.println("Dodano nowego użytkownika:\n\tID: " + user.getUserID() + "\n\tUsername: " + user.getUsername() + "\n\tPassword: " + user.getPassword() + "\n");

            HashFunction hf = Hashing.sha256();
            HashCode hc = hf.newHasher().putString(user.getPassword(), Charsets.UTF_8).hash();
          
            user.setPassword(hc.toString());
            createBaseFromUserList();
        }
    }

    /**
     * Remove user by userID
     *
     * @param userID id of the user
     */
    @Override
    public void deleteUser(int userID) {
        boolean ifUserIdFound = false;
        for (User user : userList) {
            if (user.getUserID() == userID) {
                System.out.println("Usunięto użytkownika:\n\tID: " + user.getUserID() + "\n\tUsername: " + user.getUsername() + "\n");
                userList.remove(user);
                createBaseFromUserList();
                ifUserIdFound = true;
                break;
            }
        }
        if (!ifUserIdFound) {
            System.out.println("Nie znaleziono użytkownika o podanym id");
        }
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
     * @param login name of the user
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
     * @param login name of the user
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
     * @param login name of the user
     * @return permissionLevel or -1 if login not found
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

    /**
     *
     * @return Map od Users and their ID
     */
    @Override
    public Map<Integer, String> getUsersMap() {

        readUserListFromBase();
        Map<Integer, String> usersMap = new HashMap<>();

        for (User el : userList)
            usersMap.put(el.getUserID(), el.getUsername());

        return usersMap;
    }

}
