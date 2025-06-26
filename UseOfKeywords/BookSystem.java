package UseOfKeywords;

public class BookSystem {
    
    // Static variable shared by all BookSystems
    static String libraryName = "National Public Library";

    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Instance variables
    private String title;
    private String author;
    private final String isbn; // Final variable

    // Constructor using 'this' keyword
    public BookSystem(String title, String author, String isbn) {
        this.title = title;     // 'this' resolves ambiguity
        this.author = author;
        this.isbn = isbn;
    }

    // Method to display BookSystem details
    public void displayBookSystemDetails() {
        if (this instanceof BookSystem) {  // instanceof check
            System.out.println("\n--- BookSystem Details ---");
            System.out.println("Title : " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN  : " + isbn);
        } else {
            System.out.println("Invalid object type!");
        }
    }

    // Main method to test the program
    public static void main(String[] args) {
        // Display library name using static method
        BookSystem.displayLibraryName();

        // Create BookSystem objects
        BookSystem b1 = new BookSystem("defg", "abcd", "1111");
        BookSystem b2 = new BookSystem("abcd", "efgh", "2222");

        // Display BookSystem details
        b1.displayBookSystemDetails();
        b2.displayBookSystemDetails();
    }
}
