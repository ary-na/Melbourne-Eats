package melbourne.eats;

import org.jetbrains.annotations.NotNull;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import static melbourne.eats.ReadFile.providers;

public class Helper {

    protected static ArrayList<Order> orders = new ArrayList<>();
    protected static double total;
    protected static double deliveryFee;

    protected static final Scanner sc = new Scanner(System.in);
    protected static final String banner = new String(new char[55]).replace("\u0000", "-");
    protected static final DecimalFormat df = new DecimalFormat("0.00");
    protected static final DecimalFormat dfInt = new DecimalFormat("0.#");

    // Prompt user and return input using Scanner nextLine method
    protected static String getInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    // Display menu
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


    // Display restaurants based on selected category
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

                if (provider.getProviderCategory().equals(category)) {

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

    // Display food menu for the selected restaurant
    protected static void displayFoodMenu(@NotNull Provider provider) {

        int selection = 0;
        int quantity = 0;
        LinkedHashMap<String, Double[]> foodItem = new LinkedHashMap<>();

        do {
            int counter = 1;
            System.out.printf("%n%s", banner);
            System.out.printf("%n%-2s %s", ">", "Select a food item from " + provider.getProviderName());
            System.out.printf("%n%s", banner);
            for (String key : provider.getFoodItems().keySet()) {
                System.out.printf("%n%-2s %-44s %s", counter + ")", key, "$" + df.format(provider.getFoodItems().get(key)));
                counter++;
            }
            System.out.printf("%n%-2s %s", counter + ")", "No more");

            do {
                try {
                    selection = Integer.parseInt(getInput("\n\nPlease select:"));
                    if (selection > counter || selection <= 0) {
                        System.out.println("- Error - Please select a number from list");
                    }
                } catch (NullPointerException | NumberFormatException e) {
                    System.out.println("- Error - Please select a number from list");
                }
            } while (selection > counter || selection <= 0);

            if (selection != provider.getFoodItems().size() + 1) {
                do {
                    try {
                        quantity = Integer.parseInt(getInput(("Please enter an amount:")));
                        if (quantity < 1) {
                            System.out.println("- Error - Please enter a correct amount\n");
                        }
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
             */

            for (int i = 0; i < provider.getFoodItems().size(); i++) {
                if (i == (selection - 1)) {
                    String key = (String) provider.getFoodItems().keySet().toArray()[i];
                    Double value = (Double) provider.getFoodItems().values().toArray()[i];
                    foodItem.put(key, new Double[]{value, (double) quantity});
                }
            }

        } while (selection != provider.getFoodItems().size() + 1);

        if (foodItem.size() > 0) {
            Order order = new Order(provider.getProviderName(), foodItem, provider.getDeliveryFee());
            orders.add(order);
        }
    }
}