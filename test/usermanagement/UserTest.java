package usermanagement;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
	@Test
	public void generatePassword () throws Exception {

		User user = new User("user1", 1, 1);

		int length = 8;
		String password = user.generatePassword( length );
		String regex = "[a-zA-Z0-9]{" + length + ",}";
		boolean isCorrect = false;
		if ( password.matches( regex ) ) isCorrect = true;
		assertTrue( isCorrect );

		length = 100;
		regex = "[a-zA-Z0-9]{" + length + ",}";
		password = user.generatePassword( length );
		isCorrect = false;
		if ( password.matches( regex ) ) isCorrect = true;
		assertTrue( isCorrect );
	}

}