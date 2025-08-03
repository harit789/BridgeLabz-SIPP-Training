package Generics.SmartWarehouseManagementSystem;

public class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, String itemId, String expiryDate) {
        super(name, itemId);
        this.expiryDate = expiryDate;
    }

    @Override
    public void displayInfo() {
        System.out.println("Groceries: " + getName() + ", ID: " + getItemId() + ", Expiry Date: " + expiryDate);
    }
}