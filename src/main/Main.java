/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package main;

import headleader.Headleader;
import usermanagement.User;

public class Main {
    
    public static void main(String[] args){
        
        Headleader headleader = new Headleader();
        headleader.createUser( "user1", 1 );
		headleader.createUser( "user2", 1 );

		headleader.deleteUser( 1 );

		headleader.createUser( "user3", 1 );

		for ( User usr : headleader.getUserList() )
			System.out.println( usr.getUserID() + "\t" + usr.getUsername() );
	}
}
