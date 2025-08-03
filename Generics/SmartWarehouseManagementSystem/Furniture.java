package Generics.SmartWarehouseManagementSystem;

public class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String itemId, String material) {
        super(name, itemId);
        this.material = material;
    }

    @Override
    public void displayInfo() {
        System.out.println("Furniture: " + getName() + ", ID: " + getItemId() + ", Material: " + material);
    }
}