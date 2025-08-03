package Generics.DynamicOnlineMarketplace;

public class ClothingProduct extends Product<ClothingCategory> {
    private String size;

    public ClothingProduct(String name, String productId, double price, ClothingCategory category, String size) {
        super(name, productId, price, category);
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("Clothing: " + getName() + ", ID: " + getProductId() + ", Price: $" + String.format("%.2f", getPrice()) + ", Category: " + getCategory() + ", Size: " + size);
    }
}