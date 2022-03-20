package melbourne.eats.test;

import melbourne.eats.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private Order order;

    @Before
    public void setUp() {
        LinkedHashMap<String, Double[]> foodItemTest = new LinkedHashMap<>();
        foodItemTest.put("Test Item 1", new Double[]{0.00, 2.00});
        foodItemTest.put("Test Item 2", new Double[]{10.00, 4.00});
        foodItemTest.put("Test Item 3", new Double[]{1.00, 6.00});
        foodItemTest.put("Test Item 4", new Double[]{100.00, 0.00});
        order = new Order("Test Order", foodItemTest, 20.00);
    }

    @After
    public void tearDown() {
        order = null;
    }

    @Test
    public void testOrderObject() {
        assertNotNull(order);
    }

    @Test
    public void testGetTotal() {
        assertEquals(46.00, order.getTotal(), 0.00);
    }
}
