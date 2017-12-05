/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package iksde.headleader;

import java.util.List;
import iksde.usermanagement.IUserManagement;
import iksde.usermanagement.User;
import iksde.usermanagement.UserManagement;

public class Headleader {

    //ITaskManager taskManager;
    IUserManagement userManagement;

    public Headleader() {

        //taskManager = new ORMLiteTaskManager();
        userManagement = new UserManagement();
    }

	/**
	 * Assign task to user using method provided by ITaskManager
	 * @param userID
	 * @param taskID
	 */
	public void assignTask(int userID, int taskID) {

        //TODO: user implemented taskManager
        //taskManager.assignToTask(taskID, userID);
    }

	/**
	 * Get list of all tasks
	 */
	public void getTaskList() {
        //TODO pierogi need to add this method in ITaskManager
    }

//    /**
//     * Add new task using method provided by ITakManager
//     * @param task
//     */
//    public void addTask(Task task){
//        taskManager.addTask(task);
//    }

    /**
     * Get list of all users
     * @return list of users
     */
    public List<User> getUserList() {
        return userManagement.getUserList();
    }

	/**
	 * Create a new user using method provided by IUserManagement
	 * @param username
	 */
	public void createUser(String username){
        userManagement.createUser(username);
    }

	/**
	 * Delete a new user using method provided by IUserManagement
	 * @param userID
	 */
    public void deleteUser(int userID){
        userManagement.deleteUser(userID);
    }    
}
