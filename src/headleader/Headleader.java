/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package headleader;

import java.util.Date;
import java.util.List;
import com.spanishinquisition.functions.IAuth;
import io2017.pierogimroku.task.ORMLiteTaskManager;
import io2017.pierogimroku.task.api.ITaskManager;
import io2017.pierogimroku.task.api.TaskLook;
import io2017.pierogimroku.task.api.TaskNotFoundException;
import usermanagement.IUserManagement;
import usermanagement.User;
import usermanagement.UserManagement;

public class Headleader {

    ITaskManager taskManager;
    IUserManagement userManagement;
    IAuth auth;
    String token;

    public Headleader() {

        taskManager = new ORMLiteTaskManager();
        userManagement = UserManagement.getInstance();
        auth = new IAuth() {};
        token = null;
    }

    /**
     * Get token
     * @param username
     * @param password
     */
    public void login(String username , String password){
        token = auth.login("root", "password");
    }

    /**
     *
     * @return token
     */
    public String getToken(){
        return token;
    }

    /**
     *
     * @param taskLook
     * @param newOwnerId
     */
    public void assignTask(TaskLook taskLook, int newOwnerId) {

        if (auth.authorize(token)) {

            try {
                taskLook.setAssignedId(newOwnerId);
                taskManager.assignToTask(taskLook);
            } catch (TaskNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param taskLook
     */
    public void removeTask(TaskLook taskLook){
        if (auth.authorize(token)) {
            try {
                taskManager.removeTask(taskLook);
            } catch (TaskNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param taskLook
     */
    public void editTask(TaskLook taskLook){
        if (auth.authorize(token)) {
            try {
                taskManager.editTask(taskLook);
            } catch (TaskNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Get list of all tasks
     */
    public List<TaskLook> getTaskList() {
        List<TaskLook> taskLooks = null;
        if (auth.authorize(token)) {
           taskLooks =  taskManager.getAll();
        }
        return taskLooks;
    }

    /**
     * Add new task using method provided by ITaskManager
     * @param name
     * @param description
     * @param ownerId
     * @param assignedId
     * @param startDate
     * @param timeEstimate
     * @param priority
     */
    public void addTask(String name, String description, Integer ownerId, Integer assignedId, Date startDate, Integer timeEstimate, Integer priority)
    {
        if (auth.authorize(token))
            taskManager.addTask(new TaskLook(name, description, ownerId, assignedId, startDate, timeEstimate, priority));
    }

    /**
     * Get list of all users
     *
     * @return list of users
     */
    public List<User> getUserList() {
        if (auth.authorize(token)) return userManagement.getUserList();
        else return null;
    }

    /**
     * Create a new user using method provided by IUserManagement
     *
     * @param username
     */
    public void createUser(String username, int permissionLevel) {

        if (auth.authorize(token)) {
            userManagement.createUser(username, permissionLevel);
        }
    }

    /**
     * Delete a new user using method provided by IUserManagement
     *
     * @param userID
     */
    public void deleteUser(int userID) {

        if (auth.authorize(token)) {
            userManagement.deleteUser(userID);
        }
    }
}
