import java.util.List;

public class Customer {

    private String name;
    private double budget;
    private List<Flower> cart;

    public Customer(String name, double budget, List<Flower> cart) {
        this.name = name;
        this.budget = budget;
        this.cart = cart;
    }

    public void addToCart(Flower flower) {
        this.cart.add(flower);
    }

    public void removeFromCart(Flower flower) {
        this.cart.remove(flower);
    }

    public double getBudget() {
        return this.budget;
    }

    public  List<Flower> getCart() {
       return this.cart;

    }
}
