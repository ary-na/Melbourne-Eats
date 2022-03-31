/*
 * Helper.java - Helper Class
 * Provides functionality to other classes
 *
 * author Arian Najafi Yamchelo - s3910902@student.rmit.edu.au version 1.0 date March 13, 2022
 */

package melbourne.eats;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import static melbourne.eats.Helper.orders;
import static melbourne.eats.MelbourneEats.processMenu;
import static melbourne.eats.ReadFile.getDiscountsFromTextFile;

// Helper class - Provide functionality to other classes
public class Helper {

    // Store providers objects
    protected static final ArrayList<Provider> providers = new ArrayList<>();
    // Store orders objects
    protected static ArrayList<Order> orders = new ArrayList<>();

    // Total for each order
    protected static double total;

    // Delivery fee for each order
    protected static double deliveryFee;

    protected static final Scanner sc = new Scanner(System.in);
    protected static final String banner = new String(new char[55]).replace("\u0000", "-");

    /*
     * Code sourced and adapted from:
     * https://mkyong.com/java/java-display-double-in-2-decimal-points/
     */

    protected static final DecimalFormat df = new DecimalFormat("0.00");
    protected static final DecimalFormat dfInt = new DecimalFormat("0.#");

    // Prompt user and return input using Scanner nextLine method
    protected static String getInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    // Display main menu
    protected static void displayMainMenu() {
        System.out.printf("%n%n%s", "Welcome to Melbourne Eats");
        System.out.printf("%n%s", banner);
        System.out.printf("%n%-2s %s", ">", "Select from main menu");
        System.out.printf("%n%s", banner);
        System.out.printf("%n%-2s %s", "1)", "Browse by category");
        System.out.printf("%n%-2s %s", "2)", "Search by restaurant");
        System.out.printf("%n%-2s %s", "3)", "Checkout");
        System.out.printf("%n%-2s %s", "4)", "Exit");
    }

    // Display category menu
    protected static void displayCategoryMenu() {
        System.out.printf("%n%s", banner);
        System.out.printf("%n%-2s %s", ">", "Select by category");
        System.out.printf("%n%s", banner);
        System.out.printf("%n%-2s %s", "1)", "Restaurant");
        System.out.printf("%n%-2s %s", "2)", "Cafe");
        System.out.printf("%n%-2s %s", "3)", "Fast food");
        System.out.printf("%n%-2s %s", "4)", "Go to main menu");
    }

    // Display providers based on selected category
    protected static void displayRestaurants(String category) {

        int selection;
        ArrayList<Provider> selectedProvider = new ArrayList<>();

        do {
            int counter = 1;
            selectedProvider.clear();
            System.out.printf("%n%s", banner);
            System.out.printf("%n%-2s %s", ">", "Select from restaurant list");
            System.out.printf("%n%s", banner);
            for (Provider provider : providers) {
                // Compare the object name to method parameter
                if (provider.getClass().getSimpleName().equals(category)) {

                    // Display the providers name based on category
                    System.out.printf("%n%-2s %s", counter + ")", provider.getProviderName());
                    counter++;
                    // Add providers to arraylist
                    selectedProvider.add(provider);
                }
            }
            System.out.printf("%n%-2s %s", counter + ")", "Go to main menu");

            selection = Integer.parseInt(getInput("\n\nPlease select:"));

            // Pass the selected provider to displayFoodMenu method
            for (int i = 0; i < selectedProvider.size(); i++) {

                if (i == (selection - 1)) {
                    displayFoodMenu(selectedProvider.get(i));
                } else if (selection == counter) {
                    processMenu();
                }
            }

        } while (selection > selectedProvider.size() + 1);
    }

    // Display food menu for the selected restaurant
    public static void displayFoodMenu(Provider provider) {

        int selection = 0;
        int quantity = 0;
        LinkedHashMap<Integer, LinkedHashMap<String, Double[]>> foodItem = new LinkedHashMap<>();
        int foodItemNo = 1;
        do {
            int counter = 1;
            System.out.printf("%n%s", banner);
            System.out.printf("%n%-2s %s", ">", "Select a food item from " + provider.getProviderName());
            System.out.printf("%n%s", banner);
            // Use selected object to invoke getFoodItems method
            for (String key : provider.getFoodItems().keySet()) {
                // Display food items
                System.out.printf("%n%-2s %-44s %s", counter + ")", key, "$" + df.format(provider.getFoodItems().get(key)));
                counter++;
            }
            System.out.printf("%n%-2s %s", counter + ")", "No more");

            // Validate user selection
            do {
                try {
                    selection = Integer.parseInt(getInput("\n\nPlease select:"));
                    // Display error on condition
                    if (selection > counter || selection <= 0) {
                        System.out.println("- Error - Please select a number from list");
                    }
                    // Catch
                } catch (NullPointerException | NumberFormatException e) {
                    System.out.println("- Error - Please select a number from list");
                }
                // Loop on condition
            } while (selection > counter || selection <= 0);

            // Condition is false, when user selects go to main menu
            if (selection != provider.getFoodItems().size() + 1) {
                do {
                    try {
                        quantity = Integer.parseInt(getInput(("Please enter an amount:")));
                        // Display error on condition
                        if (quantity < 1) {
                            System.out.println("- Error - Please enter a correct amount\n");
                        }
                        // Catch
                    } catch (NullPointerException | NumberFormatException e) {
                        System.out.println("- Error - Please enter a valid number\n");
                    }
                } while (quantity < 1);
            }
            /*
             * Code sourced and adapted from:
             * https://www.youtube.com/watch?v=ISQv2lbJZoY
             * https://www.educba.com/iterator-in-java/
             * https://stackoverflow.com/questions/1090556/java-how-to-convert-hashmapstring-object-to-array
             * https://rotadev.com/java-how-to-convert-hashmapstring-object-to-array-dev/
             * https://stackoverflow.com/questions/14425826/variable-is-accessed-within-inner-class-needs-to-be-declared-final
             * https://stackoverflow.com/questions/14582596/how-to-put-get-values-into-from-nested-hashmap
             */

            // Put selected food items and quantity for each item to foodItem linkedHashMap
            for (int i = 0; i < provider.getFoodItems().size(); i++) {
                if (i == (selection - 1)) {
                    // Convert HashMap to Array
                    String key = (String) provider.getFoodItems().keySet().toArray()[i];
                    Double value = (Double) provider.getFoodItems().values().toArray()[i];

                    int finalQuantity = quantity;
                    foodItem.put(foodItemNo, new LinkedHashMap<>(){{put(key, new Double[]{value, (double) finalQuantity});}});
                    foodItemNo++;
                }
            }

        } while (selection != provider.getFoodItems().size() + 1);

        // Create Order object and add the orders to orders arraylist on condition
        if (foodItem.size() > 0) {
            Order order = new Order(provider.getProviderName(), foodItem, provider.getDeliveryFee());
            orders.add(order);
        }

        if (selection == provider.getFoodItems().size() + 1) {
            processMenu();
        }
    }

    // Calculate subtotal of orders
    public static double calculateSubtotal(ArrayList<Order> orders) {
        double subtotal = 0;

        // For each order, get the total, and calculate the sum
        for (Order order : orders) {
            subtotal += order.getTotal();
        }
        return subtotal;
    }

    // Calculate discount amount of  an order subtotal
    public static double calculateDiscount(double subtotal) {
        // Reading discounts for unit test
        getDiscountsFromTextFile();
        double discount = 0;

        // Get discount details and calculate discount
        for (Double[] key : Order.discounts.keySet()) {
            if (subtotal >= key[0] && subtotal < key[1]) {
                discount = subtotal * (Order.discounts.get(key) / 100);
            }
        }
        return discount;
    }

    // Calculate delivery fee discount
    public static double calculateDeliveryFee(ArrayList<Order> orders) {
        // Reading discounts for unit test
        getDiscountsFromTextFile();
        double deliveryFeeDiscount = 0;
        // For each order, get the delivery fee, and calculate the sum
        for (Order order : orders) {
            Helper.deliveryFee += order.getDeliveryFee();
        }

        // Calculate delivery fee discount on condition
        if (orders.size() >= Order.minNumOfRestaurantsInOrder) {
            deliveryFeeDiscount = Helper.deliveryFee * (Order.deliveryDiscountPercentage / 100);
            Helper.deliveryFee -= deliveryFeeDiscount;
        }
        return Helper.deliveryFee;
    }
}