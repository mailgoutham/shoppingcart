package kata.supermarket.filters;

import org.junit.Before;
import org.junit.Test;

import static kata.supermarket.model.Item.BEANS;
import static kata.supermarket.model.Item.COKE;
import static org.junit.Assert.assertEquals;

public class BeansThreeForTwoTest {
    private BeansThreeForTwo beansThreeForTwo;

    @Before
    public void setUp(){
        beansThreeForTwo = new BeansThreeForTwo();
    }

    @Test
    public void discountWhenMoreThan2() throws Exception {
        assertEquals(0.50, beansThreeForTwo.apply(BEANS, 3d), 0.01);
    }

    @Test
    public void noDiscountWhenEqualTo1() throws Exception {
        assertEquals(0, beansThreeForTwo.apply(BEANS, 1d), 0);
    }

    @Test
    public void noDiscountWhenNotBeans() throws Exception {
        assertEquals(0, beansThreeForTwo.apply(COKE, 1d), 0);
    }
}