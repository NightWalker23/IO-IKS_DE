/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package main;

import com.j256.ormlite.logger.LocalLog;
import headleader.Headleader;
import io2017.pierogimroku.task.api.TaskLook;

import java.text.SimpleDateFormat;
import java.util.Date;
import usermanagement.User;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "ERROR");

        Headleader headleader = new Headleader();
        Scanner scanner = new Scanner(System.in);
        UserInterface UI = new UserInterface();
        int choice = UI.loginMenu();

        if (choice == 1) {
            System.out.print("Podaj login: ");
            String login, password;
            login = scanner.nextLine();
            System.out.print("Podaj hasło: ");
            password = scanner.nextLine();
            headleader.login(login, password);

            if (headleader.getToken() != null && login.equalsIgnoreCase( "root" ) ) {

                while (choice != 3) {

                    choice = UI.mainMenu();
                    switch (choice) {
                        case 1: {

                            switch (UI.taskManagementMenu()) {
                                case 1: {
									SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

                                    System.out.println("Lista zadań:");
                                    System.out.println("TID\tName\tUID\tStartDate\tTime\tPriority\tDescription");
                                    for (TaskLook task : headleader.getTaskList()) {
										String date = sdf.format(task.getStartDate());
                                    	System.out.println(task.getId() + "\t" + task.getName() +"\t"+ task.getAssignedId() +"\t" + date +"\t" + task.getTimeEstimate() + "\t\t" + task.getPriority()+ "\t\t\t" + task.getDescription());
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.print("Podaj nazwe taska: ");
                                    String name = scanner.nextLine();

                                    System.out.print("Podaj opis taska: ");
                                    String description = scanner.nextLine();

                                    System.out.print("Podaj szacowany czas taska: ");
                                    int timeEstimate = Validation.getInt();

                                    System.out.print("Podaj priorytet taska: ");
                                    int priority = Validation.getInt();

                                    headleader.addTask(name, description, 0, 0, new Date(), timeEstimate, priority);
                                    break;
                                }
                                case 3: {
                                    System.out.print("Podaj ID taska: ");
                                    int taskID = Validation.getInt();

                                    System.out.print("Podaj ID usera: ");
                                    int userID = Validation.getInt();
                                    
                                    for (TaskLook taskLook : headleader.getTaskList()) {
                                        if(taskID == taskLook.getId()){
                                            taskLook.setStatus(TaskLook.Status.ASSIGNED);
                                            headleader.assignTask(taskLook, userID);
                                            break;
                                        }
                                    }

                                    break;
                                }
                                case 4: {
                                    
                                    System.out.print("Podaj ID taska do edycji: ");
                                    int taskID = Validation.getInt();
                                    
                                    System.out.print("Podaj nazwe taska: ");
                                    String name = scanner.nextLine();

                                    System.out.print("Podaj opis taska: ");
                                    String description = scanner.nextLine();

                                    System.out.print("Podaj szacowany czas taska: ");
                                    int timeEstimate = Validation.getInt();

                                    System.out.print("Podaj priorytet taska: ");
                                    int priority = Validation.getInt();

                                    TaskLook task = null;
                                    for (TaskLook taskLook : headleader.getTaskList()) {
                                        if(taskID == taskLook.getId()){
                                            task = taskLook;
                                            break;
                                        }
                                    }
                                    
                                    if(task != null){
                                        task.setName(name);
                                        task.setDescription(description);
                                        task.setPriority(priority);
                                        task.setTimeEstimate(timeEstimate);
                                        headleader.editTask(task);
                                    }
                                    break;
                                }
                                case 5: {
                                    System.out.println("Podaj ID taska do usunięcia");
                                    int taskID = Validation.getInt();
                                    
                                    for (TaskLook taskLook : headleader.getTaskList()) {
                                        if(taskID == taskLook.getId()){
                                            headleader.removeTask(taskLook);
                                            break;
                                        }
                                    }
                                    
                                    break;
                                }
                                case 6: {
                                    break;
                                }

                            }
                            break;
                        }

                        case 2: {

                            switch (UI.userManagementMenu()) {
                                case 1: {
                                    System.out.println("Lista uzytkownikow.");
                                    int iterator = 0;
                                    System.out.println("ID\tUID\tUsername");
                                    for (User user : headleader.getUserList()) {
                                        System.out.print(iterator++);
                                        System.out.println("\t" + user.getUserID() + "\t" + user.getUsername());
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.print("Podaj nazwe uzytkownika: ");
                                    String username = scanner.nextLine();
                                    System.out.print("Podaj permision level: ");
                                    int permision = Validation.getInt();
                                    headleader.createUser(username, permision);
                                    break;
                                }
                                case 3: {
                                    System.out.print("Podaj ID usera do usuniecia: ");
                                    int id = Validation.getInt();
                                    headleader.deleteUser(id);
                                    break;
                                }
                                case 4:
                                    break;
                            }

                            break;
                        }
                    }
                }
            }
            else{
                System.out.println("Odmowa dostępu");
            }
        } else {
            System.out.println("Zakończono");
        }
    }

}
