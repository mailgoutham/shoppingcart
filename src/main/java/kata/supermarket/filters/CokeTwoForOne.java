package kata.supermarket.filters;


import kata.supermarket.model.Item;

import java.util.function.BiFunction;

import static java.util.Objects.requireNonNull;

public class CokeTwoForOne implements BiFunction<Item, Double, Double>{
    @Override
    public Double apply(Item item, Double quantity) {
        requireNonNull(item, "Item cannot be null");
        requireNonNull(quantity, "Quantity cannot be null");

        Double price = 0d;
        if(Item.COKE == item && quantity.intValue() > 1){
            price = (item.getPrice() *quantity) -  (quantity.intValue()/ 2);
        }
        return price;
    }
}
