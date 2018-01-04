/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package main;

import com.j256.ormlite.logger.LocalLog;
import headleader.Headleader;
import io2017.pierogimroku.task.api.TaskLook;
import usermanagement.User;
import java.util.Scanner;

public class Main {

	public static void main ( String[] args ) {
//
//      Headleader headleader = new Headleader();
//      headleader.createUser( "user1", 1 );
//		headleader.createUser( "user2", 1 );
//
//		headleader.deleteUser( 1 );
//
//		headleader.createUser( "user3", 1 );
//
//		for ( User usr : headleader.getUserList() )
//			System.out.println( usr.getUserID() + "\t" + usr.getUsername() );


//		IUserData ud = UserManagement.getInstance();
//		Map<Integer, String> um = ud.getUsersMap();
//
//		for ( Map.Entry<Integer, String> entry : um.entrySet() ){
//			System.out.println( "ID: " + entry.getKey() + "\nUsername: " + entry.getValue() + "\n" );
//		}

		System.setProperty( LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "ERROR" );

		Headleader headleader = new Headleader();
		Scanner scanner = new Scanner( System.in );
		UserInterface UI = new UserInterface();
		int choice = UI.loginMenu();

		if ( choice == 1 ) {
			System.out.print( "Podaj login: " );
			String login, password;
			login = scanner.nextLine();
			System.out.print( "Podaj hasło: " );
			password = scanner.nextLine();
			headleader.login( login, password );

			if ( headleader.getToken() != null ) {

				while ( choice != 3 ) {

					choice = UI.mainMenu();
					switch ( choice ) {
						case 1: {

							switch ( UI.taskManagementMenu() ) {
								case 1: {
									int iterator = 0;
									System.out.println( "Lista zadań:" );
									System.out.println( "ID\tTID\tName\tUID\tTime\tPriority" );
									for ( TaskLook task : headleader.getTaskList() ) {
										System.out.print( iterator++ );
										System.out.println( "\t" + task.getId() + "\t" + task.getName() + "\t" + task.getAssignedId() + "\t" + task.getTimeEstimate() + "\t" + task.getPriority() );
									}
									break;
								}
								case 2: {
									System.out.print( "Podaj nazwe taska: " );
									String name = scanner.nextLine();

									System.out.print( "Podaj opis taska: " );
									String description = scanner.nextLine();

									System.out.print( "Podaj szacowany czas taska: " );
									int timeEstimate = scanner.nextInt();
									scanner.nextLine();

									System.out.print( "Podaj priorytet taska: " );
									int priority = scanner.nextInt();
									scanner.nextLine();

									headleader.addTask( name, description, 0, 0, null, timeEstimate, priority );
									break;
								}
								case 3: {
									System.out.print( "Podaj ID taska: " );
									int taskID = scanner.nextInt();
									scanner.nextLine();

									System.out.print( "Podaj ID usera: " );
									int userID = scanner.nextInt();
									scanner.nextLine();

									headleader.assignTask( headleader.getTaskList().get( taskID ), userID );
									break;
								}
								case 4: {
									System.out.println( "Prace w toku!" );
									break;
								}
								case 5: {
									System.out.println( "Podaj ID taska do usunięcia" );
									int id = scanner.nextInt();
									scanner.nextLine();
									headleader.removeTask( headleader.getTaskList().get( id ) );
									break;
								}
								case 6: {
									break;
								}


							}
							break;
						}

						case 2: {

							switch ( UI.userManagementMenu() ) {
								case 1: {
									System.out.println( "Lista uzytkownikow." );
									int iterator = 0;
									System.out.println( "ID\tUID\tUsername" );
									for ( User user : headleader.getUserList() ) {
										System.out.print( iterator++ );
										System.out.println( "\t" + user.getUserID() + "\t" + user.getUsername() );
									}
									break;
								}
								case 2: {
									System.out.print( "Podaj nazwe uzytkownika: " );
									String username = scanner.nextLine();
									System.out.print( "Podaj permision level: " );
									int permision = scanner.nextInt();
									scanner.nextLine();
									headleader.createUser( username, permision );
									break;
								}
								case 3: {
									System.out.print( "Podaj ID usera do usuniecia: " );
									int id = scanner.nextInt();
									scanner.nextLine();
									headleader.deleteUser( id );
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
		} else {
			System.out.println( "Nie jesteś zalogowany" );
		}
	}


}
