package melbourne.eats;

import org.jetbrains.annotations.NotNull;

import java.security.Key;
import java.util.*;

import static helper.Menu.*;
import static melbourne.eats.ReadFile.*;
import static melbourne.eats.Restaurant.df;

public class MelbourneEats {

    private static ArrayList<Order> orders = new ArrayList<>();

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
            }

        } while (!selection.equals("4"));
    }


    /*
     * Code sourced and adapted from:
     * https://stackoverflow.com/questions/16604765/ignore-case-for-contains-for-a-string-in-java
     */
    private static void searchByRestaurant() {

//        String input = getInput("Please enter a restaurant name:");
//
//        for (Restaurant restaurant : restaurants) {
//            String restaurantName = restaurant.getRestaurantName();
//            if(restaurantName.toLowerCase(Locale.ROOT).contains(input.toLowerCase(Locale.ROOT))){
//                System.out.println(restaurantName);
//            }
//        }

//        for (Restaurant restaurant : restaurants) {
//            restaurant.displayRestaurant();
//        }
    }


//    protected static Restaurants getRestaurant(String category) {
//            if (Objects.equals(Restaurants.getRestaurantCategory(), category)) {
//                return restaurant;
//        }
//        return null;
//    }


    private static void checkout() {
    }

    // Display restaurants based on selected category
    private static void displayRestaurants(String category) {

        int selection;
        ArrayList<Restaurant> selectedRestaurant = new ArrayList<>();

        do {

            int counter = 1;
            selectedRestaurant.clear();
            System.out.printf("\n%s", "-----------------------------------------------------");
            System.out.printf("\n%-2s %s", ">", "Select from restaurant list");
            System.out.printf("\n%s", "-----------------------------------------------------");
            for (Restaurant restaurant : restaurants) {

                if (restaurant.getRestaurantCategory().equals(category)) {

                    System.out.printf("\n%-2s %s", counter + ")", restaurant.getRestaurantName());
                    counter++;
                    selectedRestaurant.add(restaurant);
                }
            }
            System.out.printf("\n%-2s %s", counter + ")", "Go to main menu");

            selection = Integer.parseInt(getInput("\n\nPlease select:"));

            for (int i = 0; i < selectedRestaurant.size(); i++) {

                if (i == (selection - 1)) {
                    displayFoodMenu(selectedRestaurant.get(i));
                }
            }

        } while (selection > selectedRestaurant.size() + 1);
    }

    // Display food menu for the selected restaurant
    private static void displayFoodMenu(@NotNull Restaurant restaurant) {

        int selection;
        int quantity;
        HashMap<String, Double> foodItem = new HashMap<>();
        ArrayList<Integer> foodItemQuantity = new ArrayList<>();

        do {

            int counter = 1;
            System.out.printf("\n%s", "-----------------------------------------------------");
            System.out.printf("\n%-2s %s", ">", "Select a food item from " + restaurant.getRestaurantName());
            System.out.printf("\n%s", "-----------------------------------------------------");
            for (String key : restaurant.getFoodItems().keySet()) {
                System.out.printf("\n%-2s %-44s %s", counter + ")", key, df.format(restaurant.getFoodItems().get(key)));
                counter++;
            }
            System.out.printf("\n%-2s %s", counter + ")", "No more");

            selection = Integer.parseInt(getInput("\n\nPlease select:"));
            if(selection != restaurant.getFoodItems().size() + 1){
                quantity = Integer.parseInt(getInput(("Please enter an amount:")));
                Order.quantity.add(quantity);
            }

            /*
             * Code sourced and adapted from:
             * https://www.youtube.com/watch?v=ISQv2lbJZoY
             * https://www.educba.com/iterator-in-java/
             * https://stackoverflow.com/questions/1090556/java-how-to-convert-hashmapstring-object-to-array
             * https://rotadev.com/java-how-to-convert-hashmapstring-object-to-array-dev/
             */

            for (int i = 0; i < restaurant.getFoodItems().size(); i++) {
                if (i == (selection - 1)) {
                    String key = (String) restaurant.getFoodItems().keySet().toArray()[i];
                    Double value = (Double) restaurant.getFoodItems().values().toArray()[i];
                    foodItem.put(key, value);
                }
            }

        } while (selection != restaurant.getFoodItems().size() + 1);

        Order order = new Order(restaurant.getRestaurantName(), foodItem, restaurant.getDeliveryFee());
        orders.add(order);

        for(Order f1: orders){
            f1.displayOrder();
        }

    }


    private static void browseRestaurants(@NotNull Restaurant restaurant) {
        String selection;

        int counter = 1;
        do {
            selection = getInput("\n\nPlease select:");
            for (String key : restaurant.getFoodItems().keySet()) {
                System.out.println(key + " - $" + df.format(restaurant.getFoodItems().get(key)));
                counter++;
            }
        } while (counter == 0);

//        for (String key : restaurant.getFoodItems().keySet()) {
//            System.out.println(key + " - $" + df.format(restaurant.getFoodItems().get(key)));
//        }
    }
}
