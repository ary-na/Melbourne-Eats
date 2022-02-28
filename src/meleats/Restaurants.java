package meleats;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Restaurants {

    /*
     * Code sourced and adapted from:
     * https://www.educba.com/associative-array-in-java/
     */
    private String restaurantName;
    private String category;
    private String deliveryFee;
    private Map<String, String> foodItems = new HashMap<String, String>();

    public Restaurants(String restaurantName, String category, String deliveryFee, Map<String, String> foodItems) {
        this.restaurantName = restaurantName;
        this.category = category;
        this.deliveryFee = deliveryFee;
        this.foodItems = foodItems;
    }

//    public Restaurants(Scanner fsc) {
//        this.restaurantName =
//    }
}
