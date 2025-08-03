package Generics.SmartWarehouseManagementSystem;

public abstract class WarehouseItem {
    private String name;
    private String itemId;

    public WarehouseItem(String name, String itemId) {
        this.name = name;
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public String getItemId() {
        return itemId;
    }

    public abstract void displayInfo();
}