package meleats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static meleats.MelbourneEats.*;

// Display menu items
class MenuHelper {

    protected static final Scanner sc = new Scanner(System.in);
    protected static final ArrayList<Restaurants> restaurants = new ArrayList<>();

    // Prompt user and return input using Scanner nextLine method
    protected static String getInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    // Process menu
    protected static void processMenu() {
        String selection;
        do {
            displayMainMenu();
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

    protected static void displayMainMenu() {
        System.out.printf("\n\n%s", "Welcome to Melbourne Eats");
        System.out.printf("\n%s", "-----------------------------------------------------");
        System.out.printf("\n%-2s %s", ">", "Select from main menu");
        System.out.printf("\n%s", "-----------------------------------------------------");
        System.out.printf("\n%-2s %s", "1)", "Browse by category");
        System.out.printf("\n%-2s %s", "2)", "Search by restaurant");
        System.out.printf("\n%-2s %s", "3)", "Checkout");
        System.out.printf("\n%-2s %s", "4)", "Exit");
    }

    protected static void displayCategoryMenu() {
        System.out.printf("\n%s", "-----------------------------------------------------");
        System.out.printf("\n%-2s %s", ">", "Select by category");
        System.out.printf("\n%s", "-----------------------------------------------------");
        System.out.printf("\n%-2s %s", "1)", "Restaurant");
        System.out.printf("\n%-2s %s", "2)", "Cafe");
        System.out.printf("\n%-2s %s", "3)", "Fast food");
        System.out.printf("\n%-2s %s", "4)", "Go to main menu");
    }

    /*
     * Code sourced and adapted from:
     * https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
     * https://www.geeksforgeeks.org/split-string-java-examples/
     * https://stackoverflow.com/questions/20841980/read-a-file-and-split-lines-in-java
     * https://stackoverflow.com/questions/23659747/escaping-parentheses-in-regex
     * https://stackoverflow.com/questions/8141698/split-using-a-bracket
     * https://stackoverflow.com/questions/40688462/java-regex-split-method
     * https://codegym.cc/groups/posts/stringsplit-method-in-java
     * https://stackoverflow.com/questions/8141698/split-using-a-bracket
     */
    protected static void getRestaurantsFromTextFile() {
        try {
            Restaurants restaurant = null;
            Scanner fsc = new Scanner(new File("Restaurants.txt"));
            while (fsc.hasNext()) {
                String[] line = fsc.nextLine().split("[,$-]+");
                restaurant = new Restaurants(line);
                restaurants.add(restaurant);
            }
            fsc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist.");
        }

    }

    protected static void getDiscountsFromTextFile() {
        try {
            Scanner fsc = new Scanner(new File("Discounts.txt"));
            while (fsc.hasNext()) {
                String[] line = fsc.nextLine().split("[\\[\\],)%]+");


                System.out.println(Arrays.toString(line));



            }
            fsc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist.");
        }
    }
}
