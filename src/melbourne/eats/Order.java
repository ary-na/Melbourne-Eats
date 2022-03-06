package melbourne.eats;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Order {

    private String restaurantName;
    private HashMap<String, Double> foodItems = new LinkedHashMap<>();
    private Double deliveryFee;
    private static HashMap<Integer[], Integer> discounts = new HashMap<>();
    protected static int minNumOfRestaurantsInOrder;
    protected static double deliveryDiscountPercentage;
    protected static ArrayList<Integer> quantity = new ArrayList<>();

    Order(String restaurantName, HashMap<String, Double> foodItems, Double deliveryFee) {
        this.restaurantName = restaurantName;
        this.foodItems = foodItems;
        this.deliveryFee = deliveryFee;
    }


    protected static void setDiscountsDetails(String @NotNull [] fsc) {
        if (fsc.length == 4) {
            Order.discounts.put(new Integer[]{Integer.valueOf(fsc[1]), Integer.valueOf(fsc[2])}, Integer.valueOf(fsc[3]));
        } else if (fsc.length == 3) {
            Order.discounts.put(new Integer[]{Integer.valueOf(fsc[1]), 0}, Integer.valueOf(fsc[2]));
        } else {
            minNumOfRestaurantsInOrder = Integer.parseInt(fsc[0]);
            deliveryDiscountPercentage = Integer.parseInt(fsc[1]);
        }
    }

//    protected static void displayDiscount() {
//        for (Map.Entry<Integer[], Integer> entry : order.Order.discounts.entrySet()) {
//            System.out.println(Arrays.toString(entry.getKey()) + " => " + entry.getValue());
//        }
//    }

    protected void displayOrder() {
        System.out.println(this.restaurantName);
        for (String key : foodItems.keySet()) {
            System.out.println(key + " - $" + foodItems.get(key));
        }
        System.out.println("$" + this.deliveryFee);
        System.out.println(Arrays.toString(quantity.toArray()));
        System.out.println();
    }
}
