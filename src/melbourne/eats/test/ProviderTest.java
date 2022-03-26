/*
 * ProviderTest.java - Test Class
 *
 * author Arian Najafi Yamchelo - s3910902@student.rmit.edu.au version 1.0 date March 23, 2022
 */

package melbourne.eats.test;

import melbourne.eats.Cafe;
import melbourne.eats.FastFood;
import melbourne.eats.Provider;
import melbourne.eats.Restaurant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProviderTest {

    private Provider cafe;
    private Provider fastFood;
    private Provider restaurant;
    private final String[] testCafe = {"Restaurant1", "Cafe", "5", "Food Item 1", "10", "Food Item 2", "20", "Food Item 3", "30"};
    private final String[] testFastFood = {"Restaurant2", "Fast food", "10", "Food Item 1", "0", "Food Item 2", "5", "Food Item 3", "10"};
    private final String[] testRestaurant = {"Restaurant3", "Restaurant", "0", "Food Item 1", "10", "Food Item 2", "50", "Food Item 3", "100"};

    @Before
    public void setUp() {
        cafe = new Cafe(testCafe);
        fastFood = new FastFood(testFastFood);
        restaurant = new Restaurant(testRestaurant);
    }

    @After
    public void tearDown() {
        cafe = null;
        fastFood = null;
        restaurant = null;
    }

    // Test provider objects
    @Test
    public void testCafeObject() {
        assertNotNull(cafe);
    }

    @Test
    public void testFastFoodObject() {
        assertNotNull(fastFood);
    }

    @Test
    public void testRestaurantObject() {
        assertNotNull(restaurant);
    }

    // Test food items for a provider object
    @Test
    public void testGetFoodItems() {
        assertNotNull(cafe.getFoodItems());
    }
}
