package helper;

import melbourne.eats.Restaurant;

import java.util.Scanner;

public class Menu {

    public static final Scanner sc = new Scanner(System.in);

    // Prompt user and return input using Scanner nextLine method
    public static String getInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    // Display menu
    public static void displayMainMenu() {
        System.out.printf("\n\n%s", "Welcome to Melbourne Eats");
        System.out.printf("\n%s", "-----------------------------------------------------");
        System.out.printf("\n%-2s %s", ">", "Select from main menu");
        System.out.printf("\n%s", "-----------------------------------------------------");
        System.out.printf("\n%-2s %s", "1)", "Browse by category");
        System.out.printf("\n%-2s %s", "2)", "Search by restaurant");
        System.out.printf("\n%-2s %s", "3)", "Checkout");
        System.out.printf("\n%-2s %s", "4)", "Exit");
    }

    // Display category menu
    public static void displayCategoryMenu() {
        System.out.printf("\n%s", "-----------------------------------------------------");
        System.out.printf("\n%-2s %s", ">", "Select by category");
        System.out.printf("\n%s", "-----------------------------------------------------");
        System.out.printf("\n%-2s %s", "1)", "Restaurant");
        System.out.printf("\n%-2s %s", "2)", "Cafe");
        System.out.printf("\n%-2s %s", "3)", "Fast food");
        System.out.printf("\n%-2s %s", "4)", "Go to main menu");
    }
}
