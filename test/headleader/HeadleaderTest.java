package headleader;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeadleaderTest {

	/**
	 *
	 * One should delete userBase.xd before running tests
	 */

	@Test
	public void login () throws Exception {
		Headleader instance = new Headleader();

		instance.login( "zly_login", "zle_haslo" );
		assertEquals( null, instance.getToken() );

		instance.login( null, null );
		assertEquals( null, instance.getToken() );

		instance.login( "root", "password" );
		assertNotEquals( null, instance.getToken() );
	}

	@Test
	public void getToken () throws Exception {
		Headleader instance = new Headleader();

		instance.login( "root", "password" );
		assertNotEquals( null, instance.getToken() );
	}

}