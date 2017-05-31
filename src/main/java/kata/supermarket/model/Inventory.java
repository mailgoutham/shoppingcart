package kata.supermarket.model;



import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private ConcurrentHashMap<Item,Double> items = new ConcurrentHashMap();

    public void addItem(Item item, Double quantity){
        items.merge(item, quantity, (k,v)-> quantity + v);
    }

    public Map<Item,Double> getItems() {
        return Collections.unmodifiableMap(items);
    }
}
