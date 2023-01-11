public class Florist {

    private PricingList pricingList;


    public Florist (PricingList pricingList) {
        this.pricingList = pricingList;
    }

    public void addFlowerToCart (Customer customer, Flower flower) {
        double price = this.pricingList.getPrice(flower.getName());






    }


}
