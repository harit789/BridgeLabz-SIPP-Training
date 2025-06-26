package UseOfKeywords;

public class Product {

    // Static variable shared by all products
    static double discount = 10.0;  // 10% default discount

    // Static method to update discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to " + discount + "%");
    }

    // Instance variables
    private String productName;
    private double price;
    private int quantity;
    private final String productID; // Final variable

    // Constructor using 'this' keyword
    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to display product details
    public void displayProductDetails() {
        if (this instanceof Product) {  // instanceof check
            System.out.println("\n--- Product Details ---");
            System.out.println("Product ID   : " + productID);
            System.out.println("Product Name : " + productName);
            System.out.println("Price        : ₹" + price);
            System.out.println("Quantity     : " + quantity);
            System.out.println("Discount     : " + discount + "%");
            double discountedPrice = price - (price * discount / 100);
            System.out.println("Price After Discount: ₹" + discountedPrice);
        } else {
            System.out.println("Invalid product object!");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Update discount using static method
        Product.updateDiscount(15.0);  // change to 15%

        // Create product objects
        Product p1 = new Product("P101", "Wireless Mouse", 799.00, 2);
        Product p2 = new Product("P102", "Keyboard", 1199.00, 1);

        // Display product details
        p1.displayProductDetails();
        p2.displayProductDetails();
    }
}
