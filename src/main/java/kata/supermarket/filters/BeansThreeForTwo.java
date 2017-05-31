package kata.supermarket.filters;


import kata.supermarket.model.Item;

import java.util.function.BiFunction;

import static java.util.Objects.requireNonNull;

public class BeansThreeForTwo implements BiFunction<Item, Double, Double> {

    @Override
    public Double apply(Item item, Double quantity) {
        requireNonNull(item, "Item cannot be null");
        requireNonNull(quantity, "Quantity cannot be null");

        Double price = 0d;
        if(Item.BEANS == item && quantity.intValue() > 2){
            price = item.getPrice() * (quantity.intValue()/ 3);
        }
        return price;
    }
}
