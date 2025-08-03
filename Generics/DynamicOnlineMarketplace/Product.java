package Generics.DynamicOnlineMarketplace;

public abstract class Product<T> {
    private String name;
    private String productId;
    private double price;
    private T category;

    public Product(String name, String productId, double price, T category) {
        this.name = name;
        this.productId = productId;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    public abstract void displayInfo();
}