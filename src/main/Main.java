/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package main;

import headleader.Headleader;
import usermanagement.IUserData;
import usermanagement.User;
import usermanagement.UserManagement;

import java.util.Map;

public class Main {
    
    public static void main(String[] args){
        
        Headleader headleader = new Headleader();
        headleader.createUser( "user1", 1 );
		headleader.createUser( "user2", 1 );

		headleader.deleteUser( 1 );

		headleader.createUser( "user3", 1 );

		for ( User usr : headleader.getUserList() )
			System.out.println( usr.getUserID() + "\t" + usr.getUsername() );


//		IUserData ud = UserManagement.getInstance();
//		Map<Integer, String> um = ud.getUsersMap();
//
//		for ( Map.Entry<Integer, String> entry : um.entrySet() ){
//			System.out.println( "ID: " + entry.getKey() + "\nUsername: " + entry.getValue() + "\n" );
//		}

	}
}
