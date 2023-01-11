import java.util.HashMap;
import java.util.Map;

public class PricingList {

    private Map<String, Double> prices;

    public PricingList() {
        this.prices = new HashMap<>();

    }


    public void addPrice (String flowerName, double price) {
        this.prices.put(flowerName,price);

    }
    public double getPrice (String flowerName) {
        return this.prices.get(flowerName);
    }

}
