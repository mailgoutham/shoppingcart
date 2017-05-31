package kata.supermarket.service;


import kata.supermarket.model.Inventory;
import kata.supermarket.model.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static java.math.BigDecimal.*;
import static java.util.Objects.requireNonNull;

public class CartService {
    public double calculateFinalPrice(Inventory inventory, List<BiFunction<Item,Double, Double>> discounts){
        requireNonNull(inventory);
        requireNonNull(discounts);

        return inventory.getItems().
                entrySet().
                stream().
                map(d -> valueOf(calculateActualPrice(d) - calculateDiscount(d, discounts))).
                reduce(ZERO, BigDecimal::add).
                setScale(2, ROUND_HALF_UP).
                doubleValue();
    }

    private double calculateDiscount(Map.Entry<Item, Double> entry,  List<BiFunction<Item,Double, Double>> discounts) {
        return discounts.
                stream().
                mapToDouble(x -> x.apply(
                        entry.getKey(),
                        entry.getValue())).
                sum();

    }

    private double calculateActualPrice(Map.Entry<Item, Double> entry){
        return entry.getKey().getPrice() * entry.getValue();
    }
}
