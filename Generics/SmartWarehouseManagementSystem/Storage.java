package Generics.SmartWarehouseManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
        System.out.println(item.getName() + " added to storage.");
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("Storage is empty.");
            return;
        }
        System.out.println("Items in storage:");
        for (T item : items) {
            item.displayInfo();
        }
    }

    // Wildcard method to display all items regardless of their specific type
    public static void displayItemsInAnyStorage(List<? extends WarehouseItem> anyStorageItems) {
        System.out.println("Displaying items from any storage type:");
        if (anyStorageItems.isEmpty()) {
            System.out.println("No items in this storage.");
            return;
        }
        for (WarehouseItem item : anyStorageItems) {
            item.displayInfo();
        }
    }

    public List<T> getItems() {
        return items;
    }
}