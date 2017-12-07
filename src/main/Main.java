/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package main;

import iksde.headleader.Headleader;
import iksde.usermanagement.User;

public class Main {
    
    public static void main(String[] args){
        
        Headleader headleader = new Headleader();
        headleader.createUser( "user1 );
		headleader.createUser( "user2" );
		headleader.createUser( "user3" );
		headleader.createUser( "user4" );
		headleader.createUser( "user5" );
		headleader.createUser( "user6" );

		headleader.deleteUser( 1 );

		headleader.createUser( "user7" );

		for ( User usr : headleader.getUserList() )
			System.out.println( usr.getUserID() + "\t" + usr.getUsername() );


	}
}
