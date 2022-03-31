/*
 * OrderTest.java - Test Class
 *
 * author Arian Najafi Yamchelo - s3910902@student.rmit.edu.au version 1.0 date March 23, 2022
 */

package melbourne.eats.test;

import melbourne.eats.Helper;
import melbourne.eats.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class OrderTest {

    private Order order1;
    private Order order2;
    private ArrayList<Order> orders;
    private double[] subTotal;
    private LinkedHashMap<Integer, LinkedHashMap<String, Double[]>> foodItemsTest1;
    private LinkedHashMap<Integer, LinkedHashMap<String, Double[]>> foodItemsTest2;

    @Before
    public void setUp() {

        subTotal = new double[5];
        subTotal[0] = 9.00;
        subTotal[1] = 10.00;
        subTotal[2] = 20.00;
        subTotal[3] = 30.00;
        subTotal[4] = 50.00;

        foodItemsTest1 = new LinkedHashMap<>();
        foodItemsTest1.put(1, new LinkedHashMap<>(){{put("Test Item 1.1", new Double[]{0.00, 2.00});}});
        foodItemsTest1.put(2, new LinkedHashMap<>(){{put("Test Item 1.2", new Double[]{10.00, 4.00});}});
        foodItemsTest1.put(3, new LinkedHashMap<>(){{put("Test Item 1.3", new Double[]{1.00, 6.00});}});
        foodItemsTest1.put(4, new LinkedHashMap<>(){{put("Test Item 1.4", new Double[]{100.00, 0.00});}});
        foodItemsTest1.put(5, new LinkedHashMap<>(){{put("Test Item 1.4", new Double[]{100.00, 1.00});}});
        order1 = new Order("Test Order 1", foodItemsTest1, 5.00);

        foodItemsTest2 = new LinkedHashMap<>();
        foodItemsTest2.put(1, new LinkedHashMap<>(){{put("Test Item 2.1", new Double[]{1.00, 0.00});}});
        foodItemsTest2.put(2, new LinkedHashMap<>(){{put("Test Item 2.2", new Double[]{20.00, 4.00});}});
        foodItemsTest2.put(3, new LinkedHashMap<>(){{put("Test Item 2.3", new Double[]{1.00, 6.00});}});
        foodItemsTest2.put(4, new LinkedHashMap<>(){{put("Test Item 2.4", new Double[]{50.00, 1.00});}});
        order2 = new Order("Test Order 2", foodItemsTest2, 10.00);

        orders = new ArrayList<>(2);
        orders.add(order1);
        orders.add(order2);
    }

    @After
    public void tearDown() {
        orders = null;
        order1 = null;
        order2 = null;
        foodItemsTest1 = null;
        foodItemsTest2 = null;
        subTotal = null;
    }

    // Test objects
    @Test
    public void testOrder1Object() {
        assertNotNull(order1);
    }

    @Test
    public void testOrder2Object() {
        assertNotNull(order2);
    }

    // Test total for an order object
    @Test
    public void testGetTotal() {
        assertEquals(146.00, order1.getTotal(), 0.00);
    }

    // Test subtotal for all orders
    @Test
    public void testCalculateSubtotal() {
        assertEquals(282.00, Helper.calculateSubtotal(orders), 0.00);
    }

    // Test discount amount for a subtotal
    @Test
    public void testCalculateDiscountZeroPercent() {
        assertEquals(0.00, Helper.calculateDiscount(subTotal[0]), 0.00);
    }

    @Test
    public void testCalculateDiscountTenPercent() {
        assertEquals(1.0, Helper.calculateDiscount(subTotal[1]), 0.00);
    }

    @Test
    public void testCalculateDiscountFifteenPercent() {
        assertEquals(3.00, Helper.calculateDiscount(subTotal[2]), 0.00);
    }

    @Test
    public void testCalculateDiscountTwentyPercent() {
        assertEquals(6.00, Helper.calculateDiscount(subTotal[3]), 0.00);
    }

    @Test
    public void testCalculateDiscountTwentyPercentSubtotalMoreThanThirty() {
        assertEquals(10.00, Helper.calculateDiscount(subTotal[4]), 0.00);
    }

    // Test delivery fee discount
    @Test
    public void testCalculateDeliveryFeeWithDiscount(){
        assertEquals(7.50, Helper.calculateDeliveryFee(orders), 0.00);
    }
}
