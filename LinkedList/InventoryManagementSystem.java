import java.util.Scanner;

public class InventoryManagementSystem {
    // Node class to represent an inventory item
    static class Node {
        String itemName;
        String itemId;
        int quantity;
        double price;
        Node next;

        // Constructor
        public Node(String itemName, String itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    // LinkedList class to manage inventory items
    static class InventoryLinkedList {
        Node head;

        // Constructor
        public InventoryLinkedList() {
            this.head = null;
        }

        // Add an item at the beginning of the list
        public void addAtBeginning(String itemName, String itemId, int quantity, double price) {
            Node newNode = new Node(itemName, itemId, quantity, price);
            newNode.next = head;
            head = newNode;
            System.out.println("Item added at the beginning successfully.");
        }

        // Add an item at the end of the list
        public void addAtEnd(String itemName, String itemId, int quantity, double price) {
            Node newNode = new Node(itemName, itemId, quantity, price);

            // If the list is empty, make the new node as head
            if (head == null) {
                head = newNode;
                System.out.println("Item added at the end successfully.");
                return;
            }

            // Traverse to the last node
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            // Add the new node at the end
            temp.next = newNode;
            System.out.println("Item added at the end successfully.");
        }

        // Add an item at a specific position
        public void addAtPosition(int position, String itemName, String itemId, int quantity, double price) {
            // If position is 1, add at the beginning
            if (position == 1) {
                addAtBeginning(itemName, itemId, quantity, price);
                return;
            }

            Node newNode = new Node(itemName, itemId, quantity, price);
            Node temp = head;
            int count = 1;

            // Traverse to the position - 1
            while (temp != null && count < position - 1) {
                temp = temp.next;
                count++;
            }

            // If position is beyond the length of the list
            if (temp == null) {
                System.out.println("Position is beyond the length of the list.");
                return;
            }

            // Insert the new node at the specified position
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Item added at position " + position + " successfully.");
        }

        // Remove an item by Item ID
        public void removeByItemId(String itemId) {
            // If list is empty
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            // If the head node itself holds the item ID to be deleted
            if (head.itemId.equals(itemId)) {
                head = head.next;
                System.out.println("Item with ID '" + itemId + "' removed successfully.");
                return;
            }

            // Search for the item ID to be deleted
            Node temp = head;
            Node prev = null;

            while (temp != null && !temp.itemId.equals(itemId)) {
                prev = temp;
                temp = temp.next;
            }

            // If item ID was not found
            if (temp == null) {
                System.out.println("Item with ID '" + itemId + "' not found.");
                return;
            }

            // Unlink the node from the list
            prev.next = temp.next;
            System.out.println("Item with ID '" + itemId + "' removed successfully.");
        }

        // Update the quantity of an item by Item ID
        public void updateQuantity(String itemId, int newQuantity) {
            Node temp = head;
            boolean found = false;

            while (temp != null) {
                if (temp.itemId.equals(itemId)) {
                    temp.quantity = newQuantity;
                    System.out.println("Quantity updated successfully for item with ID '" + itemId + "'.");
                    found = true;
                    break;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("Item with ID '" + itemId + "' not found.");
            }
        }

        // Search for an item by Item ID
        public void searchByItemId(String itemId) {
            Node temp = head;
            boolean found = false;

            while (temp != null) {
                if (temp.itemId.equals(itemId)) {
                    System.out.println("\nItem found:");
                    displayItem(temp);
                    found = true;
                    break;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("Item with ID '" + itemId + "' not found.");
            }
        }

        // Search for an item by Item Name
        public void searchByItemName(String itemName) {
            Node temp = head;
            boolean found = false;

            System.out.println("\nItems with name '" + itemName + "':");
            while (temp != null) {
                if (temp.itemName.equalsIgnoreCase(itemName)) {
                    displayItem(temp);
                    found = true;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("No items found with name '" + itemName + "'.");
            }
        }

        // Calculate and display the total value of inventory
        public void calculateTotalValue() {
            if (head == null) {
                System.out.println("Inventory is empty.");
                return;
            }

            Node temp = head;
            double totalValue = 0;

            while (temp != null) {
                totalValue += temp.quantity * temp.price;
                temp = temp.next;
            }

            System.out.println("\nTotal Inventory Value: $" + String.format("%.2f", totalValue));
        }

        // Sort the inventory based on Item Name (ascending)
        public void sortByNameAscending() {
            if (head == null || head.next == null) {
                return; // No need to sort if list is empty or has only one node
            }

            head = mergeSort(head, true, true);
            System.out.println("Inventory sorted by Item Name (Ascending).");
        }

        // Sort the inventory based on Item Name (descending)
        public void sortByNameDescending() {
            if (head == null || head.next == null) {
                return; // No need to sort if list is empty or has only one node
            }

            head = mergeSort(head, true, false);
            System.out.println("Inventory sorted by Item Name (Descending).");
        }

        // Sort the inventory based on Price (ascending)
        public void sortByPriceAscending() {
            if (head == null || head.next == null) {
                return; // No need to sort if list is empty or has only one node
            }

            head = mergeSort(head, false, true);
            System.out.println("Inventory sorted by Price (Ascending).");
        }

        // Sort the inventory based on Price (descending)
        public void sortByPriceDescending() {
            if (head == null || head.next == null) {
                return; // No need to sort if list is empty or has only one node
            }

            head = mergeSort(head, false, false);
            System.out.println("Inventory sorted by Price (Descending).");
        }

        // Merge sort implementation for linked list
        private Node mergeSort(Node head, boolean byName, boolean ascending) {
            if (head == null || head.next == null) {
                return head;
            }

            // Find the middle of the list
            Node middle = getMiddle(head);
            Node nextOfMiddle = middle.next;
            middle.next = null;

            // Apply mergeSort on left list
            Node left = mergeSort(head, byName, ascending);

            // Apply mergeSort on right list
            Node right = mergeSort(nextOfMiddle, byName, ascending);

            // Merge the left and right lists
            Node sortedList = sortedMerge(left, right, byName, ascending);
            return sortedList;
        }

        // Utility function to get the middle of the linked list
        private Node getMiddle(Node head) {
            if (head == null) {
                return head;
            }

            Node slow = head, fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        // Function to merge two sorted linked lists
        private Node sortedMerge(Node a, Node b, boolean byName, boolean ascending) {
            Node result = null;

            // Base cases
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }

            // Pick either a or b, and recur
            boolean condition;
            if (byName) {
                condition = ascending ? a.itemName.compareToIgnoreCase(b.itemName) <= 0 : a.itemName.compareToIgnoreCase(b.itemName) >= 0;
            } else {
                condition = ascending ? a.price <= b.price : a.price >= b.price;
            }

            if (condition) {
                result = a;
                result.next = sortedMerge(a.next, b, byName, ascending);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next, byName, ascending);
            }

            return result;
        }

        // Display all items in the inventory
        public void displayAll() {
            if (head == null) {
                System.out.println("Inventory is empty.");
                return;
            }

            Node temp = head;
            System.out.println("\nInventory Items:");
            while (temp != null) {
                displayItem(temp);
                temp = temp.next;
            }
        }

        // Helper method to display an item
        private void displayItem(Node item) {
            System.out.println("Item Name: " + item.itemName);
            System.out.println("Item ID: " + item.itemId);
            System.out.println("Quantity: " + item.quantity);
            System.out.println("Price: $" + String.format("%.2f", item.price));
            System.out.println("Total Value: $" + String.format("%.2f", item.quantity * item.price));
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryLinkedList inventory = new InventoryLinkedList();
        int choice, quantity, position;
        String itemName, itemId;
        double price;

        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add an item at the beginning");
            System.out.println("2. Add an item at the end");
            System.out.println("3. Add an item at a specific position");
            System.out.println("4. Remove an item by Item ID");
            System.out.println("5. Update quantity of an item");
            System.out.println("6. Search for an item by Item ID");
            System.out.println("7. Search for an item by Item Name");
            System.out.println("8. Calculate total inventory value");
            System.out.println("9. Sort inventory by Item Name (Ascending)");
            System.out.println("10. Sort inventory by Item Name (Descending)");
            System.out.println("11. Sort inventory by Price (Ascending)");
            System.out.println("12. Sort inventory by Price (Descending)");
            System.out.println("13. Display all items");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    itemName = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    itemId = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter Price: $");
                    price = scanner.nextDouble();
                    inventory.addAtBeginning(itemName, itemId, quantity, price);
                    break;

                case 2:
                    System.out.print("Enter Item Name: ");
                    itemName = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    itemId = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter Price: $");
                    price = scanner.nextDouble();
                    inventory.addAtEnd(itemName, itemId, quantity, price);
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    position = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Item Name: ");
                    itemName = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    itemId = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter Price: $");
                    price = scanner.nextDouble();
                    inventory.addAtPosition(position, itemName, itemId, quantity, price);
                    break;

                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    itemId = scanner.nextLine();
                    inventory.removeByItemId(itemId);
                    break;

                case 5:
                    System.out.print("Enter Item ID to update quantity: ");
                    itemId = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();
                    inventory.updateQuantity(itemId, quantity);
                    break;

                case 6:
                    System.out.print("Enter Item ID to search: ");
                    itemId = scanner.nextLine();
                    inventory.searchByItemId(itemId);
                    break;

                case 7:
                    System.out.print("Enter Item Name to search: ");
                    itemName = scanner.nextLine();
                    inventory.searchByItemName(itemName);
                    break;

                case 8:
                    inventory.calculateTotalValue();
                    break;

                case 9:
                    inventory.sortByNameAscending();
                    inventory.displayAll();
                    break;

                case 10:
                    inventory.sortByNameDescending();
                    inventory.displayAll();
                    break;

                case 11:
                    inventory.sortByPriceAscending();
                    inventory.displayAll();
                    break;

                case 12:
                    inventory.sortByPriceDescending();
                    inventory.displayAll();
                    break;

                case 13:
                    inventory.displayAll();
                    break;

                case 14:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 14);

        scanner.close();
    }
}