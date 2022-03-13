/*
 * Order.java - Order Class
 * The class allows creating order objects
 *
 * author Arian Najafi Yamchelo - s3910902@student.rmit.edu.au version 1.0 date March 13, 2022
 */

package melbourne.eats;

import java.io.PrintWriter;
import java.util.LinkedHashMap;

// Order class
public class Order {

    // Instance variables
    private final String restaurantName;
    private final LinkedHashMap<String, Double[]> foodItems;
    private final double deliveryFee;
    private double total;

    // Class variables
    protected static final LinkedHashMap<Double[], Double> discounts = new LinkedHashMap<>();
    protected static int minNumOfRestaurantsInOrder;
    protected static double deliveryDiscountPercentage;

    // Class constructor
    Order(String restaurantName, LinkedHashMap<String, Double[]> foodItems, Double deliveryFee) {
        this.restaurantName = restaurantName;
        this.foodItems = foodItems;
        this.deliveryFee = deliveryFee;
    }

    // Get methods
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

    // Set discount details read from file
    protected static void setDiscountsDetails(String [] line) {
        if (line.length == 4) {
            Order.discounts.put(new Double[]{Double.valueOf(line[1]), Double.valueOf(line[2])}, Double.valueOf(line[3]));
        } else if (line.length == 3) {
            Order.discounts.put(new Double[]{Double.valueOf(line[1]), Double.MAX_VALUE}, Double.valueOf(line[2]));
        } else {
            minNumOfRestaurantsInOrder = Integer.parseInt(line[0]);
            deliveryDiscountPercentage = Integer.parseInt(line[1]);
        }
    }

    // Display order
    protected void displayOrder() {
        System.out.printf("\n%s", this.restaurantName);
        for (String key : this.foodItems.keySet()) {
            System.out.printf("\n%-2s %-44s %s", Helper.dfInt.format(this.foodItems.get(key)[1]), key, "$" + Helper.df.format(this.foodItems.get(key)[0] * this.foodItems.get(key)[1]));
        }
        System.out.printf("\n%-47s %s", "Delivery fee", "$" + Helper.df.format(this.deliveryFee));
        System.out.printf("%n%s", Helper.banner);
    }

    // Write order to Order.txt file
    protected void writeOrder(PrintWriter pw) {
        pw.printf("\n%s", this.restaurantName);
        for (String key : this.foodItems.keySet()) {
            pw.printf("\n%-2s %-44s %s", Helper.dfInt.format(this.foodItems.get(key)[1]), key, "$" + Helper.df.format(this.foodItems.get(key)[0] * this.foodItems.get(key)[1]));
        }
        pw.printf("\n%-47s %s", "Delivery fee", "$" + Helper.df.format(this.deliveryFee));
        pw.printf("%n%s", Helper.banner);
    }
}
