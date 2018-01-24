/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package usermanagement;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Szysz
 */


public class UserManagementTest {

    public UserManagementTest() {
    }

    @Test
    public void readUserListFromBase() throws Exception {
        List<User> userList = new ArrayList();
        User user = new User("root",0,0);
        user.setPassword("password");
        HashFunction hf = Hashing.sha256();
        HashCode hc = hf.newHasher().putString(user.getPassword(), Charsets.UTF_8).hash();
        user.setPassword(hc.toString());
        userList.add(user);

        UserManagement userManagment = UserManagement.getInstance();
        userManagment.readUserListFromBase();
        List<User> userList2;
        userList2 = userManagment.getUserList();

        assertEquals(userList.get(0).getUsername(),userList2.get(0).getUsername());
        assertEquals(userList.get(0).getPassword(),userList2.get(0).getPassword());
        assertEquals(userList.get(0).getPermissionLevel(),userList2.get(0).getPermissionLevel());
        assertEquals(userList.get(0).getUserID(),userList2.get(0).getUserID());

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("* UtilsJUnit4Test: @BeforeClass method");
        UserManagement instance = UserManagement.getInstance();
        instance.createUser("user1", 1);
        instance.createUser("user2", 1);
        instance.createUser("user3", 1);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("* UtilsJUnit4Test: @AfterClass method");

        UserManagement instance = UserManagement.getInstance();
        instance.deleteUser(1);
        instance.deleteUser(2);
        instance.deleteUser(3);
        instance.deleteUser(4);
        instance.deleteUser(5);
        instance.deleteUser(6);
    }

    /**
     * Test of getInstance method, of class UserManagement.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        UserManagement expResult = UserManagement.getInstance();
        UserManagement result = UserManagement.getInstance();
        assertEquals(expResult, result);

    }

    /**
     * Test of createUser method, of class UserManagement.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        int permissionLevel = 1;
        UserManagement instance = UserManagement.getInstance();
        instance.createUser("testuser1", permissionLevel);
        instance.createUser("testuser2", permissionLevel);
        instance.createUser("testuser3", permissionLevel);

        boolean test1 = false;
        boolean test2 = false;
        boolean test3 = false;
        for (User user : instance.getUserList()) {
            if ("user1".equals(user.getUsername())) {
                test1 = true;
            }
        }
        for (User user : instance.getUserList()) {
            if ("user2".equals(user.getUsername())) {
                test2 = true;
            }
        }
        for (User user : instance.getUserList()) {
            if ("user3".equals(user.getUsername())) {
                test3 = true;
            }
        }
        assertTrue(test1);
        assertTrue(test2);
        assertTrue(test3);
    }

    /**
     * Test of getUserList method, of class UserManagement.
     */
    @Test
    public void testGetUserList() {
        System.out.println("getUserList");
        UserManagement instance = UserManagement.getInstance();
        List<User> result = instance.getUserList();
        boolean test = false;
        for (User user : result) {
            if (user.getUsername().equals("root")) {
                test = true;
                break;
            }
        }
        assertTrue(test);
    }

    /**
     * Test of getUserPassword method, of class UserManagement.
     */
    @Test
    public void testGetUserPassword() {
        System.out.println("getUserPassword");
        String login = "root";
        UserManagement instance = UserManagement.getInstance();

        HashFunction hf = Hashing.sha256();
        HashCode hc = hf.newHasher().putString("password", Charsets.UTF_8).hash();
        String expResult = hc.toString();

        String result = instance.getUserPassword(login);
        assertEquals(expResult, result);
    }

    /**
     * Test of getID method, of class UserManagement.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        UserManagement instance = UserManagement.getInstance();

        int expResult1 = 0;
        int expResult2 = 1;
        int expResult3 = 2;
        int expResult4 = 3;
        int result1 = instance.getID("root");
        int result2 = instance.getID("user1");
        int result3 = instance.getID("user2");
        int result4 = instance.getID("user3");
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of getPermissionLevel method, of class UserManagement.
     */
    @Test
    public void testGetPermissionLevel() {
        System.out.println("getPermissionLevel");
        UserManagement instance = UserManagement.getInstance();
        int expResult1 = 0;
        int expResult2 = 1;
        int result1 = instance.getPermissionLevel("root");
        int result2 = instance.getPermissionLevel("user1");
        int result3 = instance.getPermissionLevel("user2");
        int result4 = instance.getPermissionLevel("user3");
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult2, result3);
        assertEquals(expResult2, result4);
    }

    /**
     * Test of getUsersMap method, of class UserManagement.
     */
    @Test
    public void testGetUsersMap() {
        System.out.println("getUsersMap");
        UserManagement instance = UserManagement.getInstance();
        Map<Integer, String> result = instance.getUsersMap();
        String resUser = result.get(0);
        String expResult = "root";
        
        assertEquals(expResult, resUser);
    }

    /**
     * Test of deleteUser method, of class UserManagement.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        UserManagement instance = UserManagement.getInstance();
        instance.createUser("test", 1);
        int userID = instance.getID("test");
        instance.deleteUser(userID);

        boolean test = true;
        for (User user : instance.getUserList()) {
            if (userID == user.getUserID()) {
                test = false;
            }
        }
        assertTrue(test);
    }

}
