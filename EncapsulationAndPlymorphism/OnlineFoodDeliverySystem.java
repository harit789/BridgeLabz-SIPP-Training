package EncapsulationAndPlymorphism;

import java.util.*;

// Interface: Discountable
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract class: FoodItem
abstract class FoodItem implements Discountable {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Unit: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total Price (before discount): ₹%.2f\n", calculateTotalPrice());
        System.out.println(getDiscountDetails());
        System.out.printf("Final Price (after discount): ₹%.2f\n", calculateTotalPrice() - applyDiscount());
        System.out.println("-----------------------------------------");
    }

    // Encapsulated getters
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // No public setters to restrict modification of order details
}

// VegItem class
class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount for veg items
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Discount Applied: 10%";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double extraCharge = 20.0 * getQuantity(); // ₹20 extra per item
        return getPrice() * getQuantity() + extraCharge;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount for non-veg items
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Discount Applied: 5% (+₹20/item extra charge)";
    }
}

// Main Class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> orderList = new ArrayList<>();

        FoodItem item1 = new VegItem("Paneer Butter Masala", 200, 2);
        FoodItem item2 = new NonVegItem("Chicken Biryani", 250, 3);
        FoodItem item3 = new VegItem("Veg Momos", 100, 4);

        orderList.add(item1);
        orderList.add(item2);
        orderList.add(item3);

        processOrder(orderList);
    }

    // Polymorphic method
    public static void processOrder(List<FoodItem> items) {
        System.out.println("----- Order Summary -----");
        for (FoodItem item : items) {
            item.getItemDetails();
        }
    }
}
