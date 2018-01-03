package main;

import java.util.Scanner;


public class UserInterface {

    Scanner scanner = new Scanner(System.in);


    public UserInterface(){

    }
    public int loginMenu(){
        System.out.println("1 - Zaloguj");
        System.out.println("2 - Wyjście");
        System.out.print("Wybór: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public int mainMenu(){
        System.out.println("GŁÓWNE MENU");
        System.out.println("1 - Zarządzanie zadaniami");
        System.out.println("2 - Zarządzanie użytkownikami");
        System.out.println("3 - Wyjście");
        int choice = scanner.nextInt();
        return choice;
    }

    public int taskManagementMenu(){
        System.out.println("1 - Wyświetl zadania");
        System.out.println("2 - Dodaj zadanie");
        System.out.println("3 - Przypisz zadanie");
        System.out.println("4 - Edytuj zadanie");
        System.out.println("5 - Usuń zadanie");
        System.out.println("6 - Powrót");

        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public int userManagementMenu(){
        System.out.println("1 - Wyswietl uzytkownikow");
        System.out.println("2 - Dodaj użytkownika");
        System.out.println("3 - Usuń użytkownika");
        System.out.println("4 - Powrót");

        int choice = scanner.nextInt();
        return choice;
    }
}
