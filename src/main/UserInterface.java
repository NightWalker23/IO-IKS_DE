/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package main;

public class UserInterface {

	/**
	 *
	 * @return choice that user will take
	 */
	public int loginMenu () {
		System.out.println( "1 - Zaloguj" );
		System.out.println( "2 - Wyjście" );
		System.out.print( "Wybór: " );

		return Validation.getInt();
	}

	/**
	 *
	 * @return choice that user will take
	 */
	public int mainMenu () {
		System.out.println( "\nGŁÓWNE MENU" );
		System.out.println( "1 - Zarządzanie zadaniami" );
		System.out.println( "2 - Zarządzanie użytkownikami" );
		System.out.println( "3 - Wyjście" );

		return Validation.getInt();
	}

	/**
	 *
	 * @return choice that user will take
	 */
	public int taskManagementMenu () {
		System.out.println( "\n1 - Wyświetl zadania" );
		System.out.println( "2 - Dodaj zadanie" );
		System.out.println( "3 - Przypisz zadanie" );
		System.out.println( "4 - Edytuj zadanie" );
		System.out.println( "5 - Usuń zadanie" );
		System.out.println( "6 - Powrót" );

		return Validation.getInt();
	}

	/**
	 *
	 * @return choice that user will take
	 */
	public int userManagementMenu () {
		System.out.println( "\n1 - Wyswietl uzytkownikow" );
		System.out.println( "2 - Dodaj użytkownika" );
		System.out.println( "3 - Usuń użytkownika" );
		System.out.println( "4 - Powrót" );

		return Validation.getInt();
	}

}
