/*
 * Provider.java - Abstract Class
 * The class allows creating objects of the class subclasses
 *
 * author Arian Najafi Yamchelo - s3910902@student.rmit.edu.au version 1.0 date March 13, 2022
 */

package melbourne.eats;

import java.util.LinkedHashMap;

// Provider abstract class
public abstract class Provider {

    /*
     * Code sourced and adapted from:
     * https://www.educba.com/associative-array-in-java/
     */

    private final String providerName;
    private final double deliveryFee;
    private final LinkedHashMap<String, Double> foodItems = new LinkedHashMap<>();

    /*
     * Code sourced and adapted from:
     * https://stackoverflow.com/questions/16780289/using-multiple-delimiters-with-scanner-java
     * https://stackoverflow.com/questions/30564462/read-data-from-a-text-file-and-create-an-object
     */

    // Construct an object from file
    protected Provider(String [] line) {
        this.providerName = line[0];
        this.deliveryFee = Double.parseDouble(line[2]);
        for (int i = 3; i < (line.length - 1); i += 2) {
            this.foodItems.put(line[i].substring(0, line[i].length() - 1).trim(), Double.parseDouble(line[i + 1]));
        }
    }

    // Get methods
    protected String getProviderName() { return this.providerName; }

    public Double getDeliveryFee() { return this.deliveryFee; }

    public LinkedHashMap<String, Double> getFoodItems() { return this.foodItems; }
}

