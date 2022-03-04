package meleats;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static meleats.MenuHelper.*;

public class MelbourneEats {

    public static void main(String[] args) {
        getRestaurantsFromTextFile();
        processMenu();
    }




    protected static void browseByCategory() {
        String selection;
        do {
            displayCategoryMenu();
            selection = getInput("\n\nPlease select:");

        } while (!selection.equals("4"));
    }





    /*
     * Code sourced and adapted from:
     * https://stackoverflow.com/questions/16604765/ignore-case-for-contains-for-a-string-in-java
     */
    protected static void searchByRestaurant() {

//        String input = getInput("Please enter a restaurant name:");
//
//        for (Restaurants restaurant : restaurants) {
//            String restaurantName = restaurant.getRestaurantName();
//            if(restaurantName.toLowerCase(Locale.ROOT).contains(input.toLowerCase(Locale.ROOT))){
//                System.out.println(restaurantName);
//            }
//        }


        getDiscountsFromTextFile();
//        for (Restaurants restaurant : restaurants) {
//            restaurant.displayRestaurant();
//        }
    }






    protected static void checkout() {
    }
}
