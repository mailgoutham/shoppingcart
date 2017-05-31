package kata.supermarket.filters;

import org.junit.Before;
import org.junit.Test;

import static kata.supermarket.model.Item.BEANS;
import static kata.supermarket.model.Item.COKE;
import static org.junit.Assert.assertEquals;


public class CokeTwoForOneTest {

    private CokeTwoForOne cokeTwoForOne;

    @Before
    public void setUp(){
        cokeTwoForOne = new CokeTwoForOne();
    }

    @Test
    public void discountWhenMoreThan1() throws Exception {
        assertEquals(0.40, cokeTwoForOne.apply(COKE, 2d), 0.01);
    }

    @Test
    public void noDiscountWhenEqualTo1() throws Exception {
        assertEquals(0, cokeTwoForOne.apply(COKE, 1d), 0);
    }

    @Test
    public void noDiscountWhenNotCoke() throws Exception {
        assertEquals(0, cokeTwoForOne.apply(BEANS, 1d), 0);
    }

}