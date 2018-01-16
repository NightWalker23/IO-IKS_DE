package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {

	/**
	 * Provides validation for input from keyboard of Integer type
	 *
	 * @return choice from the menu
	 */
	public static int getInt () {
		Scanner scanner = new Scanner( System.in );
		int choice = - 1;
		boolean isValid;

		do {
			isValid = true;
			try {
				choice = scanner.nextInt();
				scanner.nextLine();
			} catch ( InputMismatchException e ) {
				System.err.println( "Błąd! Poszę podać liczbę!" );
				isValid = false;
				scanner.nextLine();
			}
		} while ( ! isValid );

		return choice;
	}
}
