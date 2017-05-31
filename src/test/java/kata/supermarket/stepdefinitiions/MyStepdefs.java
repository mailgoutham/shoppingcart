package kata.supermarket.stepdefinitiions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kata.supermarket.filters.BeansThreeForTwo;
import kata.supermarket.filters.CokeTwoForOne;
import kata.supermarket.model.Inventory;
import kata.supermarket.model.Item;
import kata.supermarket.service.CartService;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiFunction;


public class MyStepdefs {

    private CartService cartService;
    private Inventory inventory;

    double finalPrice;

    @Before
    public void setUp() {
        cartService = new CartService();
        inventory = new Inventory();
        finalPrice = 0;
    }


    @When("^I calculate the final price$")
    public void I_calculate_the_final_price() throws Throwable {
        finalPrice = cartService.calculateFinalPrice(inventory, Collections.<BiFunction<Item,Double,Double>>emptyList());
    }

    @Then("^The price should show (.+)$")
    public void The_price_should_show_(double price) throws Throwable {
       Assert.assertEquals("Final Price", price, finalPrice, 0.00);
    }


    @Given("^The shopping basket has (.+) of (.+)$")
    public void The_shopping_basket_has_QUANTITY_of_PRODUCT(double quantity, String product) throws Throwable {
        inventory.addItem(Item.fromName(product), quantity);
    }

    @Given("^The shopping basket has multiple products (.+) (.+) (.+) (.+)$")
    public void The_shopping_basket_has_multiple_products_PRODUCT_QUANTITY_PRODUCT_QUANTITY_(String product1, double quantity1, String product2, double quantity2) throws Throwable {
        inventory.addItem(Item.fromName(product1), quantity1);
        inventory.addItem(Item.fromName(product2), quantity2);
    }
    @When("^I calculate the final price with discount$")
    public void I_calculate_the_final_price_with_discount() throws Throwable {
        finalPrice = cartService.calculateFinalPrice(inventory, Arrays.asList(new BeansThreeForTwo(), new CokeTwoForOne()));
    }

}
