/*
 * WriteFile.java - WriteFile class
 * Write orders to Order.txt file
 *
 * author Arian Najafi Yamchelo - s3910902@student.rmit.edu.au version 1.0 date March 13, 2022
 */

package melbourne.eats;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static melbourne.eats.Helper.*;

/*
 * Code sourced and adapted from:
 * https://stackoverflow.com/questions/9961292/write-to-text-file-without-overwriting-in-java
 */

public class WriteFile {
    protected static void writeOrdersToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("Orders.txt", true));
            for (Order order : orders) {
                // Write each order to file
                order.writeOrder(pw);
            }
            pw.printf("\n%-47s %s", "Total amount to pay", "$" + df.format(total));
            pw.printf("%n%s", banner);
            pw.println("\n\n");
            pw.close();
        } catch (IOException e) {
            System.out.println("Error - Could not write to file");
        }
    }
}
