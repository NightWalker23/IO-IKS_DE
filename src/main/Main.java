/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package main;

import iksde.headleader.Headleader;
import iksde.usermanagement.User;

public class Main {
    
    public static void main(String[] args){
        
        Headleader headleader = new Headleader();
        headleader.createUser( "Szysz ziom" );
		headleader.createUser( "Tabisiololo" );
		headleader.createUser( "Mr Pezet" );
		headleader.createUser( "Danson Kuduro" );
		headleader.createUser( "Wicio" );
		headleader.createUser( "Tomala" );

		headleader.deleteUser( 1 );

		headleader.createUser( "Eldo Peldo" );

		for ( User usr : headleader.getUserList() )
			System.out.println( usr.getUserID() + "\t" + usr.getUsername() );


	}
}
