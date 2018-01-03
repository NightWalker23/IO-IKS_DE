/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package headleader;

import java.util.List;

import com.spanishinquisition.functions.IAuth;
import io2017.pierogimroku.task.ORMLiteTaskManager;
import io2017.pierogimroku.task.api.ITaskManager;
import usermanagement.IUserManagement;
import usermanagement.User;
import usermanagement.UserManagement;

public class Headleader {

    ITaskManager taskManager;
    IUserManagement userManagement;
    IAuth auth;
    String token;

    public Headleader() {

        //taskManager = new ORMLiteTaskManager();
        userManagement = UserManagement.getInstance();
        auth = new IAuth() {};
        token = auth.login("root", "password");
    }

	/**
	 * Assign task to user using method provided by ITaskManager
	 * @param userID
	 * @param taskID
	 */
	public void assignTask(int userID, int taskID) {

		if (auth.authorize(token)) {
			//TODO: user implemented taskManager
			//taskManager.assignToTask(taskID, userID);
		}
    }

	/**
	 * Get list of all tasks
	 */
	public void getTaskList() {
		if (auth.authorize(token)) {
			//TODO pierogi need to add this method in ITaskManager
		}
    }

    /**
     * Add new task using method provided by ITaskManager
     * @param task
     */
//    public void addTask(Task task){
//		if (auth.authorize(token)) {
//			taskManager.addTask(task);
//		}
//    }

    /**
     * Get list of all users
     * @return list of users
     */
    public List<User> getUserList() {
		if (auth.authorize(token)) {
			return userManagement.getUserList();
		}
		else
			return null;
    }

	/**
	 * Create a new user using method provided by IUserManagement
	 * @param username
	 */
	public void createUser(String username, int permissionLevel){

		if (auth.authorize(token)) {
			userManagement.createUser(username, permissionLevel);
		}
    }

	/**
	 * Delete a new user using method provided by IUserManagement
	 * @param userID
	 */
    public void deleteUser(int userID){

		if (auth.authorize(token)) {
			userManagement.deleteUser(userID);
		}
    }    
}
