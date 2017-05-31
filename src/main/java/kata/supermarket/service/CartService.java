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
    public double calculateFinalPrice(Inventory inventory){
        requireNonNull(inventory);

        return inventory.getItems().
                entrySet().
                stream().
                map(d -> valueOf(d.getKey().getPrice() * d.getValue())).
                reduce(ZERO, BigDecimal::add).
                setScale(2, ROUND_HALF_UP).
                doubleValue();
    }
}
