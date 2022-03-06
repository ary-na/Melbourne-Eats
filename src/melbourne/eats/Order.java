package melbourne.eats;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static melbourne.eats.Restaurant.df;
import static melbourne.eats.Restaurant.dfInt;

public class Order {

    private final String restaurantName;
    private LinkedHashMap<String, Double[]> foodItems = new LinkedHashMap<>();
    private final Double deliveryFee;
    private static final HashMap<Integer[], Integer> discounts = new HashMap<>();
    protected static int minNumOfRestaurantsInOrder;
    protected static double deliveryDiscountPercentage;

    Order(String restaurantName, HashMap<String, Double[]> foodItems, Double deliveryFee) {
        this.restaurantName = restaurantName;
        this.foodItems = (LinkedHashMap<String, Double[]>) foodItems;
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
        System.out.printf("\n%s", this.restaurantName);
        for (String key : foodItems.keySet()) {
                System.out.printf("\n%-2s %-44s %s", dfInt.format(foodItems.get(key)[1]), key, "$" + df.format(foodItems.get(key)[0] * foodItems.get(key)[1]));
            }
        System.out.printf("\n%-47s %s", "Delivery fee", "$" + df.format(this.deliveryFee));
        System.out.printf("\n%s", "-------------------------------------------------------");
    }
}
