package melbourne.eats;

import org.jetbrains.annotations.NotNull;

import java.io.PrintWriter;
import java.util.LinkedHashMap;

import static melbourne.eats.Helper.*;

public class Order {

    private final String restaurantName;
    private final LinkedHashMap<String, Double[]> foodItems;
    private final double deliveryFee;
    private double total;
    protected static final LinkedHashMap<Double[], Double> discounts = new LinkedHashMap<>();
    protected static int minNumOfRestaurantsInOrder;
    protected static double deliveryDiscountPercentage;

    Order(String restaurantName, LinkedHashMap<String, Double[]> foodItems, Double deliveryFee) {
        this.restaurantName = restaurantName;
        this.foodItems = foodItems;
        this.deliveryFee = deliveryFee;
    }

    protected static void setDiscountsDetails(String @NotNull [] fsc) {
        if (fsc.length == 4) {
            Order.discounts.put(new Double[]{Double.valueOf(fsc[1]), Double.valueOf(fsc[2])}, Double.valueOf(fsc[3]));
        } else if (fsc.length == 3) {
            Order.discounts.put(new Double[]{Double.valueOf(fsc[1]), Double.MAX_VALUE}, Double.valueOf(fsc[2]));
        } else {
            minNumOfRestaurantsInOrder = Integer.parseInt(fsc[0]);
            deliveryDiscountPercentage = Integer.parseInt(fsc[1]);
        }
    }

    protected double getDeliveryFee() {
        return this.deliveryFee;
    }

    protected double getTotal() {
        for (String key : foodItems.keySet()) {
            double subtotal = foodItems.get(key)[0] * foodItems.get(key)[1];
            this.total += subtotal;
        }
        return this.total;
    }

    protected void displayOrder() {
        System.out.printf("\n%s", this.restaurantName);
        for (String key : foodItems.keySet()) {
            System.out.printf("\n%-2s %-44s %s", dfInt.format(foodItems.get(key)[1]), key, "$" + df.format(foodItems.get(key)[0] * foodItems.get(key)[1]));
        }
        System.out.printf("\n%-47s %s", "Delivery fee", "$" + df.format(this.deliveryFee));
        System.out.printf("%n%s", banner);
    }

    protected void writeOrder(PrintWriter pw) {
        pw.printf("\n%s", this.restaurantName);
        for (String key : foodItems.keySet()) {
            pw.printf("\n%-2s %-44s %s", dfInt.format(foodItems.get(key)[1]), key, "$" + df.format(foodItems.get(key)[0] * foodItems.get(key)[1]));
        }
        pw.printf("\n%-47s %s", "Delivery fee", "$" + df.format(this.deliveryFee));
        pw.printf("%n%s", banner);
    }
}
