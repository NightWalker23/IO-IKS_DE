/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package headleader;

import com.spanishinquisition.functions.Auth;
import com.spanishinquisition.functions.IAuth;
import io2017.pierogimroku.task.ORMLiteTaskManager;
import io2017.pierogimroku.task.api.ITaskManager;
import io2017.pierogimroku.task.api.TaskLook;
import io2017.pierogimroku.task.api.TaskNotFoundException;
import java.util.Date;
import java.util.List;
import usermanagement.IUserManagement;
import usermanagement.User;
import usermanagement.UserManagement;

public class Headleader {

	ITaskManager taskManager;
	IUserManagement userManagement;
	IAuth auth;
	String token;

	public Headleader () {

		taskManager = new ORMLiteTaskManager();
		userManagement = UserManagement.getInstance();
		auth = Auth.getInstance();
		token = null;
	}

	/**
	 * Get token using method from API from Hiszpańska Inkwizycja
	 *
	 * @param username name of the user
	 * @param password password of the user
	 */
	public void login ( String username, String password ) {
		token = auth.login( username, password );
	}

	/**
	 * @return token of the user
	 */
	public String getToken () {
		return token;
	}

	/**
	 * Assign task to user
	 *
	 * @param taskLook   task wrapper from API from Pierogi Mroku
	 * @param newOwnerId id of user that will be assigned to task
	 */
	public void assignTask ( TaskLook taskLook, int newOwnerId ) {

		if ( auth.authorize( token ) ) {

			try {
				taskLook.setAssignedId( newOwnerId );
				taskManager.assignToTask( taskLook );
			} catch ( TaskNotFoundException e ) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Removes task
	 *
	 * @param taskLook task wrapper from API from Pierogi Mroku
	 */
	public void removeTask ( TaskLook taskLook ) {
		if ( auth.authorize( token ) ) {
			try {
				taskManager.removeTask( taskLook );
			} catch ( TaskNotFoundException e ) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Edit task
	 *
	 * @param taskLook task wrapper from API from Pierogi Mroku
	 */
	public void editTask ( TaskLook taskLook ) {
		if ( auth.authorize( token ) ) {
			try {
				taskManager.editTask( taskLook );
			} catch ( TaskNotFoundException e ) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * Get list of all tasks
	 *
	 * @return list of tasks
	 */
	public List<TaskLook> getTaskList () {
		List<TaskLook> taskLooks = null;
		if ( auth.authorize( token ) ) {
			taskLooks = taskManager.getAll();
		}
		return taskLooks;
	}

	/**
	 * Add new task using method provided by ITaskManager from Pierogi Mroku
	 *
	 * @param name         name of the task
	 * @param description  description of the task
	 * @param ownerId      id of owner
	 * @param assignedId   id of user assigned to this task
	 * @param startDate    creation date
	 * @param timeEstimate time that this task will take
	 * @param priority     priority of this task, 0 is the most important priority
	 */
	public void addTask ( String name, String description, Integer ownerId, Integer assignedId, Date startDate, Integer timeEstimate, Integer priority ) {
		if ( auth.authorize( token ) )
			taskManager.addTask( new TaskLook( name, description, ownerId, assignedId, startDate, timeEstimate, priority ) );
	}

	/**
	 * Get list of all users
	 *
	 * @return list of users
	 */
	public List<User> getUserList () {
		if ( auth.authorize( token ) ) return userManagement.getUserList();
		else return null;
	}

	/**
	 * Create a new user using method provided by IUserManagement
	 *
	 * @param username        name of the user
	 * @param permissionLevel permission level of the user
	 */
	public void createUser ( String username, int permissionLevel ) {

		if ( auth.authorize( token ) ) {
			userManagement.createUser( username, permissionLevel );
		}
	}

	/**
	 * Delete an user using method provided by IUserManagement
	 *
	 * @param userID id of the user
	 */
	public void deleteUser ( int userID ) {

		if ( auth.authorize( token ) ) {
			userManagement.deleteUser( userID );
		}
	}
}
