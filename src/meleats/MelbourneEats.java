package meleats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MelbourneEats {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        processMenu();
    }

    // Prompt user and return input using Scanner nextLine method
    private static String getInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    // Process menu
    private static void processMenu() {
        String selection;
        do {
            DisplayMenu.displayMainMenu();
            selection = getInput("\n\nPlease select:");
            switch (selection) {
                case "1" -> browseByCategory();
                case "2" -> searchByRestaurant();
                case "3" -> checkout();
                case "4" -> System.out.print("\nThank you for choosing Melbourne Eats.");
                default -> System.err.println("Please select a valid menu option.");
            }
        } while (!selection.equals("4"));
        sc.close();
        /*
         * Code sourced and adapted from:
         * https://stackoverflow.com/questions/2670956/how-to-quit-a-java-app-from-within-the-program
         */
        System.exit(0);
    }


    private static void browseByCategory() {
        String selection;
        do {
            DisplayMenu.displayCategoryMenu();
            selection = getInput("\n\nPlease select:");

        } while (!selection.equals("4"));
    }

    private static void searchByRestaurant() {
        getRestaurantFromTextFile();
    }

    private static void checkout() {
    }


    /*
     * Code sourced and adapted from:
     * https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
     */
    private static void getRestaurantFromTextFile() {
        try {
            Scanner fsc = new Scanner(new File("Restaurants.txt"));
            Restaurants restaurant = null;
            while(fsc.hasNextLine()){
                fsc.useDelimiter(",");

                System.out.println(fsc.next());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist.");
        }

    }
}
