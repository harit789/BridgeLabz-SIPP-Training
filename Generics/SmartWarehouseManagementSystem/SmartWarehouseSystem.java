package Generics.SmartWarehouseManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        // Create storage for different types of items
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items to respective storages
        Electronics tv = new Electronics("Smart TV", "E001", "Samsung");
        Groceries milk = new Groceries("Milk", "G001", "2023-12-31");
        Furniture chair = new Furniture("Office Chair", "F001", "Wood");

        electronicsStorage.addItem(tv);
        groceriesStorage.addItem(milk);
        furnitureStorage.addItem(chair);

        System.out.println("\n============================================");
        System.out.println("  SMART WAREHOUSE SYSTEM - ITEM DISPLAY");
        System.out.println("============================================");

        System.out.println("\n--- Displaying Individual Storage Contents ---");
        System.out.println("--------------------------------------------");
        electronicsStorage.displayAllItems();
        System.out.println("--------------------------------------------");
        groceriesStorage.displayAllItems();
        System.out.println("--------------------------------------------");
        furnitureStorage.displayAllItems();
        System.out.println("--------------------------------------------");

        // Demonstrate wildcard usage: display all items from different storages
        System.out.println("\n--- Displaying All Items Using Wildcard Method ---");
        System.out.println("--------------------------------------------");
        List<WarehouseItem> allWarehouseItems = new ArrayList<>();
        allWarehouseItems.addAll(electronicsStorage.getItems());
        allWarehouseItems.addAll(groceriesStorage.getItems());
        allWarehouseItems.addAll(furnitureStorage.getItems());

        Storage.displayItemsInAnyStorage(allWarehouseItems);
        System.out.println("--------------------------------------------");

        // Example of retrieving an item
        System.out.println("\n--- Retrieving a Specific Item ---");
        System.out.println("--------------------------------------------");
        Electronics retrievedTv = electronicsStorage.getItem(0);
        if (retrievedTv != null) {
            System.out.print("Retrieved: ");
            retrievedTv.displayInfo();
        } else {
            System.out.println("Item not found.");
        }
        System.out.println("--------------------------------------------");
    }
}