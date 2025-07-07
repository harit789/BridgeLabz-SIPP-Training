package EncapsulationAndPlymorphism;

import java.util.*;

// Interface: Reservable
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract Class: LibraryItem
abstract class LibraryItem implements Reservable {
    private String itemId;
    private String title;
    private String author;
    private boolean isReserved;
    private String borrowerName;  // Encapsulated personal data

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Reserved: " + (isReserved ? "Yes, by " + borrowerName : "No"));
        System.out.println("---------------------------------");
    }

    // Implement Reservable interface
    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            this.isReserved = true;
            this.borrowerName = borrowerName;
            System.out.println(title + " has been reserved by " + borrowerName);
        } else {
            System.out.println(title + " is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }

    // Encapsulated getters and setters
    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    protected String getBorrowerName() { return borrowerName; }
}

// Book class
class Book extends LibraryItem {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // 21 days for books
    }
}

// Magazine class
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days for magazines
    }
}

// DVD class
class DVD extends LibraryItem {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days for DVDs
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> library = new ArrayList<>();

        LibraryItem item1 = new Book("B001", "The Alchemist", "Paulo Coelho");
        LibraryItem item2 = new Magazine("M101", "National Geographic", "NG Team");
        LibraryItem item3 = new DVD("D501", "Interstellar", "Christopher Nolan");

        library.add(item1);
        library.add(item2);
        library.add(item3);

        // Reserve some items
        item1.reserveItem("Alice");
        item2.reserveItem("Bob");
        item3.reserveItem("Charlie");

        // Try reserving an already reserved item
        item1.reserveItem("David");

        // Display item details using polymorphism
        for (LibraryItem item : library) {
            item.getItemDetails();
        }
    }
}
