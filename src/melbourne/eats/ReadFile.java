package melbourne.eats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    protected static final ArrayList<Restaurant> restaurants = new ArrayList<>();

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
     */

    // Read file Restaurant.txt and create Restaurant objects
    protected static void getRestaurantsFromTextFile() {
        try {
            Restaurant restaurant = null;
            Scanner fsc = new Scanner(new File("Restaurants.txt"));
            while (fsc.hasNext()) {
                String[] line = fsc.nextLine().split("[,$-]+");
                restaurant = new Restaurant(line);
                restaurants.add(restaurant);
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
