package meleats;

import java.util.HashMap;

class Orders {
    private String foodItemName;
    private int quantity;
    private int price;
    protected final static HashMap<Integer[], Integer> discounts = new HashMap<>();
    protected final static Integer[] deliveryFeeDiscount = new Integer[2];


    protected static void setDiscounts(String[] fsc) {
        for(String line: fsc){

        }
    }
}
