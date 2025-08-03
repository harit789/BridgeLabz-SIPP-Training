import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShoppingCart {
    // HashMap to store product prices (Product Name -> Price)
    private Map<String, Double> productPrices;

    // LinkedHashMap to maintain the order of items added to the cart (Product Name -> Quantity)
    private LinkedHashMap<String, Integer> cartItems;

    public ShoppingCart() {
        this.productPrices = new HashMap<>();
        this.cartItems = new LinkedHashMap<>();
    }

    /**
     * Adds a product and its price to the system's catalog.
     *
     * @param productName The name of the product.
     * @param price The price of the product.
     */
    public void addProductToCatalog(String productName, double price) {
        if (price <= 0) {
            System.out.println("Error: Price must be positive for " + productName);
            return;
        }
        productPrices.put(productName, price);
        System.out.println(productName + " added to catalog with price $" + String.format("%.2f", price));
    }

    /**
     * Adds an item to the shopping cart or updates its quantity if already present.
     * Maintains insertion order in LinkedHashMap.
     *
     * @param productName The name of the product to add.
     * @param quantity The quantity to add.
     */
    public void addItemToCart(String productName, int quantity) {
        if (!productPrices.containsKey(productName)) {
            System.out.println("Error: Product '" + productName + "' not found in catalog.");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be positive for " + productName + ". Use removeItemFromCart to remove.");
            return;
        }

        cartItems.put(productName, cartItems.getOrDefault(productName, 0) + quantity);
        System.out.println("Added " + quantity + " of '" + productName + "' to cart.");
    }

    /**
     * Removes an item completely from the shopping cart.
     *
     * @param productName The name of the product to remove.
     */
    public void removeItemFromCart(String productName) {
        if (cartItems.containsKey(productName)) {
            cartItems.remove(productName);
            System.out.println("Removed '" + productName + "' from cart.");
        } else {
            System.out.println("Product '" + productName + "' not found in cart.");
        }
    }

    /**
     * Updates the quantity of an item in the shopping cart.
     * If newQuantity is 0 or less, the item is removed.
     *
     * @param productName The name of the product.
     * @param newQuantity The new quantity for the product.
     */
    public void updateItemQuantity(String productName, int newQuantity) {
        if (!cartItems.containsKey(productName)) {
            System.out.println("Error: Product '" + productName + "' not found in cart to update.");
            return;
        }
        if (newQuantity <= 0) {
            removeItemFromCart(productName);
        } else {
            cartItems.put(productName, newQuantity);
            System.out.println("Updated quantity of '" + productName + "' to " + newQuantity + ".");
        }
    }

    /**
     * Calculates the total price of all items in the shopping cart.
     *
     * @return The total price.
     */
    public double calculateTotalPrice() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            Double price = productPrices.get(productName); // Get price from catalog

            if (price != null) {
                total += quantity * price;
            } else {
                System.out.println("Warning: Price not found for '" + productName + "'. Skipping from total.");
            }
        }
        return total;
    }

    /**
     * Displays all items in the cart in the order they were added (LinkedHashMap).
     */
    public void displayCartByInsertionOrder() {
        System.out.println("\n--- Shopping Cart (Insertion Order) ---");
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        cartItems.forEach((product, quantity) -> {
            Double price = productPrices.get(product);
            String priceStr = (price != null) ? String.format("$%.2f", price) : "N/A";
            System.out.println(product + " (Qty: " + quantity + ") @ " + priceStr + " each");
        });
    }

    /**
     * Displays all items in the cart sorted by product name (using a temporary TreeMap).
     */
    public void displayCartSortedByProductName() {
        System.out.println("\n--- Shopping Cart (Sorted by Product Name) ---");
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        // Create a TreeMap from cartItems for sorted display by key (product name)
        TreeMap<String, Integer> sortedCart = new TreeMap<>(cartItems);
        sortedCart.forEach((product, quantity) -> {
            Double price = productPrices.get(product);
            String priceStr = (price != null) ? String.format("$%.2f", price) : "N/A";
            System.out.println(product + " (Qty: " + quantity + ") @ " + priceStr + " each");
        });
    }

    /**
     * Displays all items in the cart sorted by price (using a temporary TreeMap).
     * If prices are identical, items are sorted by product name.
     */
    public void displayCartSortedByPrice() {
        System.out.println("\n--- Shopping Cart (Sorted by Price) ---");
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        // Create a TreeMap where keys are prices and values are lists of product names
        // This handles multiple products having the same price.
        TreeMap<Double, List<String>> sortedByPriceMap = new TreeMap<>();

        for (Map.Entry<String, Integer> cartEntry : cartItems.entrySet()) {
            String productName = cartEntry.getKey();
            Double price = productPrices.get(productName);

            if (price != null) {
                sortedByPriceMap.computeIfAbsent(price, k -> new ArrayList<>()).add(productName);
            }
        }

        sortedByPriceMap.forEach((price, products) -> {
            // Sort products with the same price alphabetically for consistent output
            Collections.sort(products);
            products.forEach(product -> {
                int quantity = cartItems.get(product);
                System.out.println(product + " (Qty: " + quantity + ") @ " + String.format("$%.2f", price) + " each");
            });
        });
    }


    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // 1. Add products to the system's catalog
        System.out.println("--- Adding Products to Catalog ---");
        cart.addProductToCatalog("Laptop", 1200.00);
        cart.addProductToCatalog("Mouse", 25.50);
        cart.addProductToCatalog("Keyboard", 75.00);
        cart.addProductToCatalog("Monitor", 300.00);
        cart.addProductToCatalog("Webcam", 75.00); // Same price as Keyboard

        // 2. Add items to the cart
        System.out.println("\n--- Adding Items to Cart ---");
        cart.addItemToCart("Laptop", 1);
        cart.addItemToCart("Mouse", 2);
        cart.addItemToCart("Keyboard", 1);
        cart.addItemToCart("Monitor", 1);
        cart.addItemToCart("Mouse", 1); // Add more quantity to existing item
        cart.addItemToCart("NonExistentProduct", 1); // Error case

        // 3. Display cart contents in different orders
        cart.displayCartByInsertionOrder();
        cart.displayCartSortedByProductName();
        cart.displayCartSortedByPrice();

        // 4. Calculate and display total price
        System.out.println("\n--- Cart Total ---");
        System.out.println("Total Cart Price: $" + String.format("%.2f", cart.calculateTotalPrice()));

        // 5. Manipulate cart items
        System.out.println("\n--- Manipulating Cart Items ---");
        cart.updateItemQuantity("Mouse", 1); // Change quantity
        cart.removeItemFromCart("Keyboard"); // Remove an item
        cart.addItemToCart("Webcam", 2); // Add a new item

        // 6. Display updated cart
        cart.displayCartByInsertionOrder();
        System.out.println("\n--- Updated Cart Total ---");
        System.out.println("Total Cart Price: $" + String.format("%.2f", cart.calculateTotalPrice()));

        // Test updating to zero quantity
        System.out.println("\n--- Testing update to zero quantity ---");
        cart.updateItemQuantity("Laptop", 0);
        cart.displayCartByInsertionOrder();
    }
}
