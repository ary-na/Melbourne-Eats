package melbourne.eats;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static melbourne.eats.ReadFile.restaurants;

public class Restaurant {

    /*
     * Code sourced and adapted from:
     * https://www.educba.com/associative-array-in-java/
     * https://mkyong.com/java/java-display-double-in-2-decimal-points/
     */

    private final String restaurantName;
    private final String category;
    private final double deliveryFee;
    private final HashMap<String, Double> foodItems = new LinkedHashMap<>();

    protected static final DecimalFormat df = new DecimalFormat("0.00");

    /*
     * Code sourced and adapted from:
     * https://stackoverflow.com/questions/16780289/using-multiple-delimiters-with-scanner-java
     * https://stackoverflow.com/questions/30564462/read-data-from-a-text-file-and-create-an-object
     */

    // Construct an object from file
    protected Restaurant(String[] line) {
        this.restaurantName = line[0];
        this.category = line[1];
        this.deliveryFee = Double.parseDouble(line[2]);
        for (int i = 3; i < (line.length - 1); i += 2) {
            this.foodItems.put(line[i], Double.parseDouble(line[i + 1]));
        }
    }

    protected String getRestaurantName() {
        return this.restaurantName;
//        System.out.println(this.restaurantName);
//        System.out.println(this.category);
//        System.out.println("$" + df.format(this.deliveryFee));
//        for (String key : foodItems.keySet()) {
//            System.out.println(key + " - $" + df.format(foodItems.get(key)));
//        }
//        System.out.println();
    }

    protected String getRestaurantCategory() {
        return this.category;
    }

    protected HashMap<String, Double> getFoodItems(){
       return this.foodItems;
    }

    protected Double getDeliveryFee() { return this.deliveryFee; }

}
