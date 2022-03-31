package melbourne.eats;

/*
 * MelbourneEats.java - Main Class
 * The system keeps a list of restaurants where users can order their food from.
 *
 * author Arian Najafi Yamchelo - s3910902@student.rmit.edu.au version 1.0 date March 13, 2022
 */

import java.util.ArrayList;
import java.util.Locale;

import static melbourne.eats.Helper.*;

public class MelbourneEats {

    // Main
    public static void main(String[] args) {
        ReadFile.getRestaurantsFromTextFile();
        ReadFile.getDiscountsFromTextFile();
        processMenu();
    }

    // Process menu
    public static void processMenu() {
        String selection;
        do {
            Helper.displayMainMenu();
            selection = Helper.getInput("\n\nPlease select:");
            switch (selection) {
                case "1" -> browseByCategory();
                case "2" -> searchByRestaurant();
                case "3" -> checkout();
                case "4" -> System.out.print("\nThank you for choosing Melbourne Eats.");
                default -> System.err.println("Please select a valid menu option.");
            }
        } while (!selection.equals("4"));
        Helper.sc.close();

        /*
         * Code sourced and adapted from:
         * https://stackoverflow.com/questions/2670956/how-to-quit-a-java-app-from-within-the-program
         */

        System.exit(0);
    }

    /*
     * Code sourced and adapted from:
     * https://www.baeldung.com/java-foreach-counter
     */

    // Browse restaurants by category
    public static void browseByCategory() {

        String selection;
        do {

            Helper.displayCategoryMenu();
            selection = Helper.getInput("\n\nPlease select:");

            switch (selection) {
                case "1" -> Helper.displayRestaurants("Restaurant");
                case "2" -> Helper.displayRestaurants("Cafe");
                case "3" -> Helper.displayRestaurants("FastFood");
                case "4" -> processMenu();
                default -> System.err.println("Please select a valid menu option.");
            }

        } while (!selection.equals("4"));
    }


    /*
     * Code sourced and adapted from:
     * https://stackoverflow.com/questions/16604765/ignore-case-for-contains-for-a-string-in-java
     */

    // Search by provider
    private static void searchByRestaurant() {

        ArrayList<Provider> selectedProvider = new ArrayList<>();

        // Get input
        String input = Helper.getInput("Please enter a restaurant name:");
        int selection;

        do {
            int counter = 1;
            selectedProvider.clear();
            System.out.printf("%n%s", Helper.banner);
            System.out.printf("%n%-2s %s", ">", "Select from matching list");
            System.out.printf("%n%s", Helper.banner);
            for (Provider provider : Helper.providers) {
                // Display providers that contain input on condition
                if (provider.getProviderName().toLowerCase(Locale.ROOT).contains(input.toLowerCase(Locale.ROOT))) {
                    System.out.printf("%n%-2s %s", counter + ")", provider.getProviderName());
                    counter++;
                    // Add provider to arraylist
                    selectedProvider.add(provider);
                }
            }

            // Display error on condition - provider not found
            if (selectedProvider.size() == 0) {
                System.out.print("\n- Error - No match found");
            }

            System.out.printf("%n%-2s %s", counter + ")", "Go to main menu");

            // Get input
            selection = Integer.parseInt(Helper.getInput("\n\nPlease select:"));

            // Display food menu based on input
            for (int i = 0; i < selectedProvider.size(); i++) {

                if (i == (selection - 1)) {
                    Helper.displayFoodMenu(selectedProvider.get(i));
                }
            }
        } while (selection > selectedProvider.size() + 1);
    }

    // Checkout
    public static void checkout() {

        // Run the menu on condition - orders arraylist is empty
        if (Helper.orders.size() == 0) {
            System.err.println("You did not order any items");
            processMenu();
        } else {
            double savedAmount = 0;
            double deliveryFee = calculateDeliveryFee(Helper.orders);
            double subtotal = calculateSubtotal(Helper.orders);
            double discount = calculateDiscount(subtotal);

            System.out.printf("%n%s", Helper.banner);
            System.out.printf("%n%-2s %s", ">", "You have ordered the following items");
            System.out.printf("%n%s", Helper.banner);

            // For each order, get the total and delivery fee
            for (Order order : Helper.orders) {
                order.displayOrder();
                Helper.deliveryFee += order.getDeliveryFee();
            }

            // Subtract the discount from subtotal and reassign subtotal
            subtotal -= discount;

            // calculate the total and saved amount
            Helper.total = subtotal + deliveryFee;
            savedAmount = discount;

            // Calculate delivery fee discount on condition
            if (orders.size() >= Order.minNumOfRestaurantsInOrder) {
                savedAmount = discount + deliveryFee;
            }

            // Display
            System.out.printf("\n%-47s %s", "Order price:", "$" + Helper.df.format(subtotal));
            System.out.printf("\n%-47s %s", "Delivery fee:", "$" + Helper.df.format(deliveryFee));
            System.out.printf("\n%-47s %s", "You have saved:", "$" + Helper.df.format(savedAmount));
            System.out.printf("\n%-47s %s", "Total amount to pay", "$" + Helper.df.format(Helper.total));
            System.out.printf("%n%s", Helper.banner);
            System.out.print("\nThanks for ordering with Melbourne Eats. Enjoy your meal.");

            // Close scanner object
            Helper.sc.close();
            // Write to file
            WriteFile.writeOrdersToFile();
            // Exit
            System.exit(0);
        }
    }
}
