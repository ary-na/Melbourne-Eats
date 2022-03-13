package melbourne.eats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadFile {

    protected static final ArrayList<Provider> providers = new ArrayList<>();

    /*
     * Code sourced and adapted from:
     * https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
     * https://www.geeksforgeeks.org/split-string-java-examples/
     * https://stackoverflow.com/questions/20841980/read-a-file-and-split-lines-in-java
     * https://stackoverflow.com/questions/23659747/escaping-parentheses-in-regex
     * https://stackoverflow.com/questions/8141698/split-using-a-bracket
     * https://stackoverflow.com/questions/40688462/java-regex-split-method
     * https://codegym.cc/groups/posts/stringsplit-method-in-java
     * https://stackoverflow.com/questions/8141698/split-using-a-bracket
     * https://makeinjava.com/remove-null-empty-string-array-lambda-stream-java8-example/
     */

    // Read file Restaurants.txt/Restaurants-2022.txt and create Restaurant objects
    protected static void getRestaurantsFromTextFile() {
        try {
            Provider provider = null;
            Scanner fsc = new Scanner(new File("Restaurants-2022.txt"));
            while (fsc.hasNext()) {
                String[] line = fsc.nextLine().split("[,$]+");
                String[] removedNull = Arrays.stream(line)
                        .filter(value ->
                                value != null && value.length() > 0 && !value.equals(" ")
                        )
                        .toArray(String[]::new);

                String providerType = removedNull[1].trim();
                if (providerType.equals("Restaurant")) {
                    provider = new Restaurant(removedNull);
                } else if (providerType.equals("Cafe")) {
                    provider = new Cafe(removedNull);
                } else {
                    provider = new FastFood(removedNull);
                }
                providers.add(provider);
            }
            fsc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist.");
        }
    }

    // Read Discounts.txt and assign discount details
    protected static void getDiscountsFromTextFile() {
        try {
            Scanner fsc = new Scanner(new File("Discounts.txt"));
            while (fsc.hasNext()) {
                String[] line = fsc.nextLine().split("[\\[\\],)%]+");
                Order.setDiscountsDetails(line);
            }
            fsc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist.");
        }
    }
}
