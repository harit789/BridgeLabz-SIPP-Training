package Generics.SmartWarehouseManagementSystem;

public class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, String itemId, String brand) {
        super(name, itemId);
        this.brand = brand;
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronics: " + getName() + ", ID: " + getItemId() + ", Brand: " + brand);
    }
}