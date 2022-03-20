/*
 * ReadFile.java - ReadFile class
 * Read from file and create objects
 *
 * author Arian Najafi Yamchelo - s3910902@student.rmit.edu.au version 1.0 date March 13, 2022
 */

package melbourne.eats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import static melbourne.eats.Helper.providers;

// ReadFile class
public class ReadFile {

    /*
     * Code sourced and adapted from:
     * https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
     * https://www.geeksforgeeks.org/split-string-java-examples/
     * https://stackoverflow.com/questions/20841980/read-a-file-and-split-lines-in-java
     * https://stackoverflow.com/questions/23659747/escaping-parentheses-in-regex
     * https://stackoverflow.com/questions/8141698/split-using-a-bracket
     * https://stackoverflow.com/questions/40688462/java-regex-split-method
     * https://codegym.cc/groups/posts/stringsplit-method-in-java
     * https://makeinjava.com/remove-null-empty-string-array-lambda-stream-java8-example/
     */

    // Read file Restaurants.txt/Restaurants-2022.txt and create Restaurant objects
    public static void getRestaurantsFromTextFile() {
        try {
            Provider provider;
            Scanner fsc = new Scanner(new File("Restaurants-2022.txt"));
            while (fsc.hasNext()) {
                // Create line array
                String[] line = fsc.nextLine().split("[,$]+");
                // Re-create line array and remove null and empty elements
                String[] lineRemovedNull = Arrays.stream(line)
                        .filter(value ->
                                value != null && value.length() > 0 && !value.equals(" ")
                        )
                        .toArray(String[]::new);

                String providerType = lineRemovedNull[1].trim();
                if (providerType.equals("Restaurant")) {
                    provider = new Restaurant(lineRemovedNull);
                } else if (providerType.equals("Cafe")) {
                    provider = new Cafe(lineRemovedNull);
                } else {
                    provider = new FastFood(lineRemovedNull);
                }
                // Add objects of the Provider class to arraylist providers
                providers.add(provider);
            }
            // Close scanner object
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
                // Set discount details
                Order.setDiscountsDetails(line);
            }
            // Close scanner object
            fsc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist.");
        }
    }
}
