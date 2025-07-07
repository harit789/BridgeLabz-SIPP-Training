import java.util.Scanner;

public class LibraryManagementSystem {
    // Node class to represent a book
    static class Node {
        String bookTitle;
        String author;
        String genre;
        String bookId;
        boolean availabilityStatus; // true if available, false if not available
        Node next;
        Node prev;

        // Constructor
        public Node(String bookTitle, String author, String genre, String bookId, boolean availabilityStatus) {
            this.bookTitle = bookTitle;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.availabilityStatus = availabilityStatus;
            this.next = null;
            this.prev = null;
        }
    }

    // DoublyLinkedList class to manage books
    static class LibraryDoublyLinkedList {
        Node head;
        Node tail;
        int count; // To keep track of the number of books

        // Constructor
        public LibraryDoublyLinkedList() {
            this.head = null;
            this.tail = null;
            this.count = 0;
        }

        // Add a book at the beginning of the list
        public void addAtBeginning(String bookTitle, String author, String genre, String bookId, boolean availabilityStatus) {
            Node newNode = new Node(bookTitle, author, genre, bookId, availabilityStatus);

            // If the list is empty
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }

            count++;
            System.out.println("Book added at the beginning successfully.");
        }

        // Add a book at the end of the list
        public void addAtEnd(String bookTitle, String author, String genre, String bookId, boolean availabilityStatus) {
            Node newNode = new Node(bookTitle, author, genre, bookId, availabilityStatus);

            // If the list is empty
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

            count++;
            System.out.println("Book added at the end successfully.");
        }

        // Add a book at a specific position
        public void addAtPosition(int position, String bookTitle, String author, String genre, String bookId, boolean availabilityStatus) {
            // If position is 1, add at the beginning
            if (position == 1) {
                addAtBeginning(bookTitle, author, genre, bookId, availabilityStatus);
                return;
            }

            // If position is beyond the count + 1, add at the end
            if (position > count + 1) {
                System.out.println("Position is beyond the length of the list. Adding at the end.");
                addAtEnd(bookTitle, author, genre, bookId, availabilityStatus);
                return;
            }

            // If position is count + 1, add at the end
            if (position == count + 1) {
                addAtEnd(bookTitle, author, genre, bookId, availabilityStatus);
                return;
            }

            Node newNode = new Node(bookTitle, author, genre, bookId, availabilityStatus);
            Node temp = head;
            int currentPos = 1;

            // Traverse to the position - 1
            while (currentPos < position - 1) {
                temp = temp.next;
                currentPos++;
            }

            // Insert the new node at the specified position
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;

            count++;
            System.out.println("Book added at position " + position + " successfully.");
        }

        // Remove a book by Book ID
        public void removeByBookId(String bookId) {
            // If list is empty
            if (head == null) {
                System.out.println("Library is empty.");
                return;
            }

            Node temp = head;
            boolean found = false;

            // Search for the book with the given ID
            while (temp != null) {
                if (temp.bookId.equals(bookId)) {
                    found = true;
                    break;
                }
                temp = temp.next;
            }

            // If book ID was not found
            if (!found) {
                System.out.println("Book with ID '" + bookId + "' not found.");
                return;
            }

            // If the book to be deleted is the head
            if (temp == head) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null; // List becomes empty
                }
            }
            // If the book to be deleted is the tail
            else if (temp == tail) {
                tail = tail.prev;
                tail.next = null;
            }
            // If the book is in the middle
            else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }

            count--;
            System.out.println("Book with ID '" + bookId + "' removed successfully.");
        }

        // Search for a book by Book Title
        public void searchByBookTitle(String bookTitle) {
            if (head == null) {
                System.out.println("Library is empty.");
                return;
            }

            Node temp = head;
            boolean found = false;

            System.out.println("\nBooks with title '" + bookTitle + "':");
            while (temp != null) {
                if (temp.bookTitle.toLowerCase().contains(bookTitle.toLowerCase())) {
                    displayBook(temp);
                    found = true;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("No books found with title '" + bookTitle + "'.");
            }
        }

        // Search for a book by Author
        public void searchByAuthor(String author) {
            if (head == null) {
                System.out.println("Library is empty.");
                return;
            }

            Node temp = head;
            boolean found = false;

            System.out.println("\nBooks by author '" + author + "':");
            while (temp != null) {
                if (temp.author.toLowerCase().contains(author.toLowerCase())) {
                    displayBook(temp);
                    found = true;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("No books found by author '" + author + "'.");
            }
        }

        // Update a book's Availability Status
        public void updateAvailabilityStatus(String bookId, boolean newStatus) {
            if (head == null) {
                System.out.println("Library is empty.");
                return;
            }

            Node temp = head;
            boolean found = false;

            while (temp != null) {
                if (temp.bookId.equals(bookId)) {
                    temp.availabilityStatus = newStatus;
                    System.out.println("Availability status updated successfully for book with ID '" + bookId + "'.");
                    found = true;
                    break;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("Book with ID '" + bookId + "' not found.");
            }
        }

        // Display all books in forward order
        public void displayForward() {
            if (head == null) {
                System.out.println("Library is empty.");
                return;
            }

            Node temp = head;
            System.out.println("\nBooks in Forward Order:");
            while (temp != null) {
                displayBook(temp);
                temp = temp.next;
            }
        }

        // Display all books in reverse order
        public void displayReverse() {
            if (tail == null) {
                System.out.println("Library is empty.");
                return;
            }

            Node temp = tail;
            System.out.println("\nBooks in Reverse Order:");
            while (temp != null) {
                displayBook(temp);
                temp = temp.prev;
            }
        }

        // Count the total number of books in the library
        public void countBooks() {
            System.out.println("\nTotal number of books in the library: " + count);
        }

        // Helper method to display a book
        private void displayBook(Node book) {
            System.out.println("Book Title: " + book.bookTitle);
            System.out.println("Author: " + book.author);
            System.out.println("Genre: " + book.genre);
            System.out.println("Book ID: " + book.bookId);
            System.out.println("Availability Status: " + (book.availabilityStatus ? "Available" : "Not Available"));
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();
        int choice, position;
        String bookTitle, author, genre, bookId;
        boolean availabilityStatus;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a book at the beginning");
            System.out.println("2. Add a book at the end");
            System.out.println("3. Add a book at a specific position");
            System.out.println("4. Remove a book by Book ID");
            System.out.println("5. Search for a book by Book Title");
            System.out.println("6. Search for a book by Author");
            System.out.println("7. Update a book's Availability Status");
            System.out.println("8. Display all books in forward order");
            System.out.println("9. Display all books in reverse order");
            System.out.println("10. Count the total number of books");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    bookTitle = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextLine();
                    System.out.print("Is the book available? (true/false): ");
                    availabilityStatus = scanner.nextBoolean();
                    library.addAtBeginning(bookTitle, author, genre, bookId, availabilityStatus);
                    break;

                case 2:
                    System.out.print("Enter Book Title: ");
                    bookTitle = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextLine();
                    System.out.print("Is the book available? (true/false): ");
                    availabilityStatus = scanner.nextBoolean();
                    library.addAtEnd(bookTitle, author, genre, bookId, availabilityStatus);
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    position = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Book Title: ");
                    bookTitle = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextLine();
                    System.out.print("Is the book available? (true/false): ");
                    availabilityStatus = scanner.nextBoolean();
                    library.addAtPosition(position, bookTitle, author, genre, bookId, availabilityStatus);
                    break;

                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    bookId = scanner.nextLine();
                    library.removeByBookId(bookId);
                    break;

                case 5:
                    System.out.print("Enter Book Title to search: ");
                    bookTitle = scanner.nextLine();
                    library.searchByBookTitle(bookTitle);
                    break;

                case 6:
                    System.out.print("Enter Author to search: ");
                    author = scanner.nextLine();
                    library.searchByAuthor(author);
                    break;

                case 7:
                    System.out.print("Enter Book ID to update availability status: ");
                    bookId = scanner.nextLine();
                    System.out.print("Enter new availability status (true/false): ");
                    availabilityStatus = scanner.nextBoolean();
                    library.updateAvailabilityStatus(bookId, availabilityStatus);
                    break;

                case 8:
                    library.displayForward();
                    break;

                case 9:
                    library.displayReverse();
                    break;

                case 10:
                    library.countBooks();
                    break;

                case 11:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 11);

        scanner.close();
    }
}