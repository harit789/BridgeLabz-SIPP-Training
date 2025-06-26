import java.util.ArrayList;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public double getTotalAmount() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }
}

class Customer {
    String name;

    public Customer(String name) {
        this.name = name;
    }

    public void placeOrder(Order order) {
        System.out.println(name + " placed an order. Total Amount: $" + order.getTotalAmount());
    }
}
