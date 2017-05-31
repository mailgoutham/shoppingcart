package kata.supermarket.model;


import java.util.Arrays;

public enum Item {

    DEFAULT("NO_ITEM", 0),
    BEANS("BEANS", 0.50),
    ORANGE("ORANGE", 1.99),
    COKE("COKE", 0.70);

    private String name;
    private Double price;

    Item(String product, double price) {
        this.name = product;
        this.price = price;
    }

    public static Item fromName(String name){
        return Arrays.
                stream(Item.values()).
                filter(x->x.name.equals(name)).
                findFirst().
                orElse(DEFAULT);
    }



    public Double getPrice() {
        return price;
    }

}
