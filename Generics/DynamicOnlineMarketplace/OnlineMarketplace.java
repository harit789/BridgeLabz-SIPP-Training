package Generics.DynamicOnlineMarketplace;

import java.util.ArrayList;
import java.util.List;

public class OnlineMarketplace {

    // Generic method to apply discounts dynamically
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double currentPrice = product.getPrice();
        double discountedPrice = currentPrice * (1 - percentage / 100);
        product.setPrice(discountedPrice);
        System.out.println("Applied " + percentage + "% discount to " + product.getName() + ". New price: $" + String.format("%.2f", discountedPrice));
    }

    public static void main(String[] args) {
        // Create various products
        BookProduct book1 = new BookProduct("The Great Adventure", "B001", 25.00, BookCategory.FICTION, "Sohil khan");
        ClothingProduct shirt1 = new ClothingProduct("Casual T-Shirt", "C001", 30.00, ClothingCategory.MEN, "L");
        GadgetProduct phone1 = new GadgetProduct("Smartphone X", "G001", 999.99, GadgetCategory.ELECTRONICS, "Model A");

        System.out.println("\n============================================");
        System.out.println("  DYNAMIC ONLINE MARKETPLACE - PRODUCT INFO");
        System.out.println("============================================");

        // Display initial product info
        System.out.println("\n--- Initial Product Information ---");
        System.out.println("--------------------------------------------");
        book1.displayInfo();
        shirt1.displayInfo();
        phone1.displayInfo();
        System.out.println("--------------------------------------------");

        // Apply discounts using the generic method
        System.out.println("\n--- Applying Discounts ---");
        System.out.println("--------------------------------------------");
        applyDiscount(book1, 10);
        applyDiscount(shirt1, 15);
        applyDiscount(phone1, 5);
        System.out.println("--------------------------------------------");

        // Display product info after discounts
        System.out.println("\n--- Product Information After Discounts ---");
        System.out.println("--------------------------------------------");
        book1.displayInfo();
        shirt1.displayInfo();
        phone1.displayInfo();
        System.out.println("--------------------------------------------");

        // Demonstrate a catalog with mixed product types (using wildcard for display)
        System.out.println("\n--- Displaying Product Catalog ---");
        System.out.println("--------------------------------------------");
        List<Product<?>> productCatalog = new ArrayList<>();
        productCatalog.add(book1);
        productCatalog.add(shirt1);
        productCatalog.add(phone1);

        for (Product<?> product : productCatalog) {
            product.displayInfo();
        }
        System.out.println("--------------------------------------------");
    }
}