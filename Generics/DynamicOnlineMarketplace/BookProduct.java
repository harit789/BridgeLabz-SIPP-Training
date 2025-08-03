package Generics.DynamicOnlineMarketplace;

public class BookProduct extends Product<BookCategory> {
    private String author;

    public BookProduct(String name, String productId, double price, BookCategory category, String author) {
        super(name, productId, price, category);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: " + getName() + ", ID: " + getProductId() + ", Price: $" + String.format("%.2f", getPrice()) + ", Category: " + getCategory() + ", Author: " + author);
    }
}