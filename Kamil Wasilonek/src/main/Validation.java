package main;

public class Validation {

	/**
	 * Provides validation for input from keyboard of Integer type, from range of first value to second value
	 *
	 * @return choice from the menu
	 */
	public static int validateInt ( String input, int x1, int x2 ) {

		int choice;

		try {
			choice = Integer.parseInt( input );
			if ( choice < x1 || choice > x2 ) throw new NumberFormatException();
		} catch ( NumberFormatException | NullPointerException e ) {
			choice = - 1;
			System.err.println( "PODAJ LICZBĘ Z ODPOWIEDNIEGO ZAKRESU!" );
		}

		return choice;
	}

	/**
	 * Provides validation for input from keyboard of Integer type
	 *
	 * @return choice from the menu or -1 if input is not valid
	 */
	public static int validateIntID ( String input ) {

		int choice;

		try {
			choice = Integer.parseInt( input );
			if ( choice < 1 ) throw new NumberFormatException();
		} catch ( NumberFormatException | NullPointerException e ) {
			choice = - 1;
			System.err.println( "PODAJ LICZBĘ WIĘKSZĄ OD ZERA!" );
		}

		return choice;
	}

	/**
	 * Provides validation for input from keyboard of String type, which have to be username
	 *
	 * @return username or null if input is not valid
	 */
	public static String validateUsername ( String input ) {

		String regex = "[a-zA-Z0-9]{3,}";

		try {
			if ( input.matches( regex ) ) return input;
				else throw new Exception();
		}
		catch ( Exception e ){
			System.err.println( "Nazwa użytkownika nie może być krótsza niż 3 znaki i musi zawierać tylko znaki z zakresu a-z A-Z 0-9" );
		}
		return null;
	}


}
