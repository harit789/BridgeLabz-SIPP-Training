package Generics.DynamicOnlineMarketplace;

public class GadgetProduct extends Product<GadgetCategory> {
    private String model;

    public GadgetProduct(String name, String productId, double price, GadgetCategory category, String model) {
        super(name, productId, price, category);
        this.model = model;
    }

    @Override
    public void displayInfo() {
        System.out.println("Gadget: " + getName() + ", ID: " + getProductId() + ", Price: $" + String.format("%.2f", getPrice()) + ", Category: " + getCategory() + ", Model: " + model);
    }
}