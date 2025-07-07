package EncapsulationAndPlymorphism;

import java.util.*;

// Taxable interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method for discount
    public abstract double calculateDiscount();

    // Getters and setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Concrete method to display product details
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
    }
}

// Electronics class implementing Taxable
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18% GST";
    }
}

// Clothing class implementing Taxable
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% GST
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 12% GST";
    }
}

// Groceries class (no tax, minimal discount)
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

public class ECommercePlatform {
    // Polymorphic method to calculate final price
    public static void calculateFinalPrices(List<Product> productList) {
        for (Product product : productList) {
            product.displayDetails();
            double discount = product.calculateDiscount();
            double tax = 0.0;

            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
                System.out.println(((Taxable) product).getTaxDetails());
            } else {
                System.out.println("No Tax Applicable");
            }

            double finalPrice = product.getPrice() + tax - discount;
            System.out.printf("Discount: ₹%.2f\n", discount);
            System.out.printf("Tax: ₹%.2f\n", tax);
            System.out.printf("Final Price: ₹%.2f\n", finalPrice);
            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        List<Product> cart = new ArrayList<>();

        cart.add(new Electronics(101, "Smartphone", 30000));
        cart.add(new Clothing(102, "Jeans", 2000));
        cart.add(new Groceries(103, "Rice (5kg)", 500));

        calculateFinalPrices(cart);
    }
}

