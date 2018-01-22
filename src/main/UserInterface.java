/*
 * Created by IKS DE, IS WIMiIP AGH 2017
 */
package main;

import java.util.Scanner;

public class UserInterface {

	Scanner keyboard = new Scanner( System.in );
	String input;
	int choice;
	/**
	 * @return choice that user will take
	 */
	public int loginMenu () {
		System.out.println( "1 - Zaloguj" );
		System.out.println( "2 - Wyjście" );
		System.out.print( "Wybór: " );

		do {
			input = keyboard.nextLine();
			choice = Validation.validateInt( input, 1, 2 );
		} while ( choice == - 1 );

		return choice;
	}

	/**
	 * @return choice that user will take
	 */
	public int mainMenu () {
		System.out.println( "\nGŁÓWNE MENU" );
		System.out.println( "1 - Zarządzanie zadaniami" );
		System.out.println( "2 - Zarządzanie użytkownikami" );
		System.out.println( "3 - Wyjście" );

		do {
			input = keyboard.nextLine();
			choice = Validation.validateInt( input, 1, 3 );
		} while ( choice == - 1 );

		return choice;
	}

	/**
	 * @return choice that user will take
	 */
	public int taskManagementMenu () {
		System.out.println( "\n1 - Wyświetl zadania" );
		System.out.println( "2 - Dodaj zadanie" );
		System.out.println( "3 - Przypisz zadanie" );
		System.out.println( "4 - Edytuj zadanie" );
		System.out.println( "5 - Usuń zadanie" );
		System.out.println( "6 - Powrót" );

		do {
			input = keyboard.nextLine();
			choice = Validation.validateInt( input, 1, 6 );
		} while ( choice == - 1 );

		return choice;
	}

	/**
	 * @return choice that user will take
	 */
	public int userManagementMenu () {
		System.out.println( "\n1 - Wyswietl uzytkownikow" );
		System.out.println( "2 - Dodaj użytkownika" );
		System.out.println( "3 - Usuń użytkownika" );
		System.out.println( "4 - Powrót" );

		do {
			input = keyboard.nextLine();
			choice = Validation.validateInt( input, 1, 4 );
		} while ( choice == - 1 );

		return choice;
	}

}
