import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Node class for a Ticket
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now();
        this.next = null;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Ticket ID: " + ticketId +
               ", Customer: " + customerName +
               ", Movie: " + movieName +
               ", Seat: " + seatNumber +
               ", Booking Time: " + bookingTime.format(formatter);
    }
}

// Circular Linked List for Ticket Reservations
class TicketReservationSystem {
    Ticket last;
    int size;

    public TicketReservationSystem() {
        this.last = null;
        this.size = 0;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber);
        if (last == null) {
            last = newTicket;
            last.next = last; // Point to itself for a single node circular list
        } else {
            newTicket.next = last.next; // New ticket points to the first node
            last.next = newTicket;     // Last node points to the new ticket
            last = newTicket;          // New ticket becomes the last node
        }
        size++;
        System.out.println("Ticket " + ticketId + " added successfully.");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (last == null) {
            System.out.println("System is empty. No tickets to remove.");
            return;
        }

        Ticket current = last.next; // Start from the first node
        Ticket prev = last;

        // Handle case where there's only one ticket
        if (current.ticketId == ticketId && size == 1) {
            last = null;
            size--;
            System.out.println("Ticket " + ticketId + " removed successfully.");
            return;
        }

        // Traverse to find the ticket
        do {
            if (current.ticketId == ticketId) {
                prev.next = current.next;
                if (current == last) { // If the last node is removed
                    last = prev;
                }
                size--;
                System.out.println("Ticket " + ticketId + " removed successfully.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket " + ticketId + " not found.");
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        Ticket current = last.next; // Start from the first node
        System.out.println("\n--- Current Ticket Reservations ---");
        do {
            System.out.println(current);
            current = current.next;
        } while (current != last.next);
        System.out.println("-----------------------------------");
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (last == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        Ticket current = last.next;
        boolean found = false;
        System.out.println("\n--- Search Results for '" + query + "' ---");
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println(current);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("No tickets found matching '" + query + "'.");
        }
        System.out.println("-----------------------------------");
    }

    // Calculate the total number of booked tickets
    public int getTotalBookedTickets() {
        return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("\nOnline Ticket Reservation System Menu:");
            System.out.println("1. Add Ticket Reservation");
            System.out.println("2. Remove Ticket Reservation");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Get Total Booked Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int ticketId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seatNumber = scanner.nextLine();
                    system.addTicket(ticketId, customerName, movieName, seatNumber);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    system.removeTicket(idToRemove);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    String query = scanner.nextLine();
                    system.searchTicket(query);
                    break;
                case 5:
                    System.out.println("Total Booked Tickets: " + system.getTotalBookedTickets());
                    break;
                case 6:
                    System.out.println("Exiting Ticket Reservation System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}