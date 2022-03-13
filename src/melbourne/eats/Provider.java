package melbourne.eats;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;

public abstract class Provider {

    /*
     * Code sourced and adapted from:
     * https://www.educba.com/associative-array-in-java/
     * https://mkyong.com/java/java-display-double-in-2-decimal-points/
     */

    private final String providerName;
    private final String category;
    private final double deliveryFee;
    private final LinkedHashMap<String, Double> foodItems = new LinkedHashMap<>();

    /*
     * Code sourced and adapted from:
     * https://stackoverflow.com/questions/16780289/using-multiple-delimiters-with-scanner-java
     * https://stackoverflow.com/questions/30564462/read-data-from-a-text-file-and-create-an-object
     */

    // Construct an object from file
    protected Provider(String @NotNull [] line) {
        this.providerName = line[0];
        this.category = line[1];
        this.deliveryFee = Double.parseDouble(line[2]);
        for (int i = 3; i < (line.length - 1); i += 2) {
            this.foodItems.put(line[i].substring(0, line[i].length() - 1).trim(), Double.parseDouble(line[i + 1]));
        }
    }

    protected String getProviderName() {
        return this.providerName;
    }

    protected String getProviderCategory() {
        return this.category;
    }

    protected Double getDeliveryFee() {
        return this.deliveryFee;
    }

    protected LinkedHashMap<String, Double> getFoodItems() {
        return this.foodItems;
    }
}

