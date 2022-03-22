package melbourne.eats.test;

import melbourne.eats.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static melbourne.eats.Helper.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private Order order1;
    private Order order2;
    private ArrayList<Order> orders;
    private double[] subTotal;
    private LinkedHashMap<String, Double[]> foodItemTest1;
    private LinkedHashMap<String, Double[]> foodItemTest2;

    @Before
    public void setUp() {

        subTotal = new double[5];
        subTotal[0] = 9.00;
        subTotal[1] = 10.00;
        subTotal[2] = 20.00;
        subTotal[3] = 30.00;
        subTotal[4] = 50.00;

        foodItemTest1 = new LinkedHashMap<>();
        foodItemTest1.put("Test Item 1.1", new Double[]{0.00, 2.00});
        foodItemTest1.put("Test Item 1.2", new Double[]{10.00, 4.00});
        foodItemTest1.put("Test Item 1.3", new Double[]{1.00, 6.00});
        foodItemTest1.put("Test Item 1.4", new Double[]{100.00, 0.00});
        order1 = new Order("Test Order 1", foodItemTest1, 5.00);

        foodItemTest2 = new LinkedHashMap<>();
        foodItemTest2.put("Test Item 2.1", new Double[]{1.00, 0.00});
        foodItemTest2.put("Test Item 2.2", new Double[]{20.00, 4.00});
        foodItemTest2.put("Test Item 2.3", new Double[]{1.00, 6.00});
        foodItemTest2.put("Test Item 2.4", new Double[]{50.00, 1.00});
        order2 = new Order("Test Order 2", foodItemTest2, 10.00);

        orders = new ArrayList<>(2);
        orders.add(order1);
        orders.add(order2);
    }

    @After
    public void tearDown() {
        orders = null;
        order1 = null;
        order2 = null;
        foodItemTest1 = null;
        foodItemTest2 = null;
        subTotal = null;
    }

    @Test
    public void testOrder1Object() {
        assertNotNull(order1);
    }

    @Test
    public void testOrder2Object() {
        assertNotNull(order2);
    }

    @Test
    public void testGetTotal() {
        assertEquals(46.00, order1.getTotal(), 0.00);
    }

    @Test
    public void testCalculateSubtotal() {
        assertEquals(182.00, calculateSubtotal(orders), 0.00);
    }

    @Test
    public void testCalculateDiscountZeroPercent() {
        assertEquals(0.00, calculateDiscount(subTotal[0]), 0.00);
    }

    @Test
    public void testCalculateDiscountTenPercent() {
        assertEquals(1.0, calculateDiscount(subTotal[1]), 0.00);
    }

    @Test
    public void testCalculateDiscountFifteenPercent() {
        assertEquals(3.00, calculateDiscount(subTotal[2]), 0.00);
    }

    @Test
    public void testCalculateDiscountTwentyPercent() {
        assertEquals(6.00, calculateDiscount(subTotal[3]), 0.00);
    }

    @Test
    public void testCalculateDiscountTwentyPercentSubtotalMoreThanThirty() {
        assertEquals(10.00, calculateDiscount(subTotal[4]), 0.00);
    }

    @Test
    public void testCalculateDeliveryFeeWithDiscount(){
        assertEquals(7.50, calculateDeliveryFee(orders), 0.00);
    }
}