package melbourne.eats;

import java.util.ArrayList;
import java.util.Locale;

import static melbourne.eats.Helper.*;
import static melbourne.eats.ReadFile.*;

public class MelbourneEats {

    public static void main(String[] args) {
        getRestaurantsFromTextFile();
        getDiscountsFromTextFile();
        processMenu();
    }

    // Process menu
    public static void processMenu() {
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

    /*
     * Code sourced and adapted from:
     * https://www.baeldung.com/java-foreach-counter
     */

    // Browse restaurants by category
    private static void browseByCategory() {

        String selection;
        do {

            displayCategoryMenu();
            selection = getInput("\n\nPlease select:");

            switch (selection) {
                case "1" -> displayRestaurants("Restaurant");
                case "2" -> displayRestaurants("Cafe");
                case "3" -> displayRestaurants("Fast food");
                case "4" -> processMenu();
                default -> System.err.println("Please select a valid menu option.");
            }

        } while (!selection.equals("4"));
    }


    /*
     * Code sourced and adapted from:
     * https://stackoverflow.com/questions/16604765/ignore-case-for-contains-for-a-string-in-java
     */
    private static void searchByRestaurant() {

        ArrayList<Provider> selectedProvider = new ArrayList<>();
        String input = getInput("Please enter a restaurant name:");
        int selection;

        do {
            int counter = 1;
            selectedProvider.clear();
            System.out.printf("%n%s", banner);
            System.out.printf("%n%-2s %s", ">", "Select from matching list");
            System.out.printf("%n%s", banner);
            for (Provider provider : providers) {
                if (provider.getProviderName().toLowerCase(Locale.ROOT).contains(input.toLowerCase(Locale.ROOT))) {
                    System.out.printf("%n%-2s %s", counter + ")", provider.getProviderName());
                    counter++;
                    selectedProvider.add(provider);
                }
            }
            System.out.printf("%n%-2s %s", counter + ")", "Go to main menu");

            selection = Integer.parseInt(getInput("\n\nPlease select:"));

            for (int i = 0; i < selectedProvider.size(); i++) {

                if (i == (selection - 1)) {
                    displayFoodMenu(selectedProvider.get(i));
                }
            }
        } while (selection > selectedProvider.size() + 1);
    }

    private static void checkout() {

        double discount = 0;
        double savedAmount = 0;
        double subtotal = 0;

        if (orders.size() == 0) {
            System.err.println("You did not order any items");
            processMenu();
        } else {

            System.out.printf("%n%s", banner);
            System.out.printf("%n%-2s %s", ">", "You have ordered the following items");
            System.out.printf("%n%s", banner);

            for (Order order : orders) {
                order.displayOrder();
                subtotal += order.getTotal();
                deliveryFee += order.getDeliveryFee();
            }

            for (Double[] key : Order.discounts.keySet()) {
                if (subtotal >= key[0] && subtotal < key[1]) {
                    discount = subtotal * (Order.discounts.get(key) / 100);
                }
            }
            subtotal -= discount;

            if (orders.size() >= Order.minNumOfRestaurantsInOrder) {
                deliveryFee *= (Order.deliveryDiscountPercentage / 100);
                savedAmount += deliveryFee;
            }

            total = subtotal + deliveryFee;
            savedAmount += discount;

            System.out.printf("\n%-47s %s", "Order price:", "$" + df.format(subtotal));
            System.out.printf("\n%-47s %s", "Delivery fee:", "$" + df.format(deliveryFee));
            System.out.printf("\n%-47s %s", "You have saved:", "$" + df.format(savedAmount));
            System.out.printf("\n%-47s %s", "Total amount to pay", "$" + df.format(total));
            System.out.printf("%n%s", banner);
            System.out.print("\nThanks for ordering with Melbourne Eats. Enjoy your meal.");
            sc.close();
            WriteFile.writeOrdersToFile();
            System.exit(0);
        }
    }
}
