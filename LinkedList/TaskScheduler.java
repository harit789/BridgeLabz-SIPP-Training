import java.util.Scanner;

public class TaskScheduler {
    // Node class to represent a task
    static class Node {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;

        // Constructor
        public Node(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    // CircularLinkedList class to manage tasks
    static class TaskCircularList {
        Node head;
        Node current; // To keep track of the current task

        // Constructor
        public TaskCircularList() {
            this.head = null;
            this.current = null;
        }

        // Add a task at the beginning of the circular list
        public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
            Node newNode = new Node(taskId, taskName, priority, dueDate);

            if (head == null) {
                // List is empty
                head = newNode;
                newNode.next = head; // Point to itself to make it circular
                current = head; // Set current to head
            } else {
                // Find the last node
                Node last = head;
                while (last.next != head) {
                    last = last.next;
                }

                // Add the new node at the beginning
                newNode.next = head;
                head = newNode;
                last.next = head; // Update the last node to point to the new head
            }

            System.out.println("Task added at the beginning successfully.");
        }

        // Add a task at the end of the circular list
        public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
            Node newNode = new Node(taskId, taskName, priority, dueDate);

            if (head == null) {
                // List is empty
                head = newNode;
                newNode.next = head; // Point to itself to make it circular
                current = head; // Set current to head
            } else {
                // Find the last node
                Node last = head;
                while (last.next != head) {
                    last = last.next;
                }

                // Add the new node at the end
                last.next = newNode;
                newNode.next = head; // Point back to head to maintain circularity
            }

            System.out.println("Task added at the end successfully.");
        }

        // Add a task at a specific position in the circular list
        public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
            // If position is 1, add at the beginning
            if (position == 1) {
                addAtBeginning(taskId, taskName, priority, dueDate);
                return;
            }

            Node newNode = new Node(taskId, taskName, priority, dueDate);
            Node temp = head;
            int count = 1;

            // Traverse to the position - 1
            while (count < position - 1 && temp.next != head) {
                temp = temp.next;
                count++;
            }

            // If position is beyond the length of the list
            if (temp.next == head && count < position - 1) {
                System.out.println("Position is beyond the length of the list.");
                return;
            }

            // Insert the new node at the specified position
            newNode.next = temp.next;
            temp.next = newNode;

            System.out.println("Task added at position " + position + " successfully.");
        }

        // Remove a task by Task ID
        public void removeByTaskId(int taskId) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            // If the head node itself holds the task ID to be deleted
            if (head.taskId == taskId) {
                // If there is only one node
                if (head.next == head) {
                    head = null;
                    current = null;
                } else {
                    // Find the last node
                    Node last = head;
                    while (last.next != head) {
                        last = last.next;
                    }

                    // Update the head and the last node's next pointer
                    if (current == head) {
                        current = head.next; // Update current if it was pointing to head
                    }
                    head = head.next;
                    last.next = head;
                }

                System.out.println("Task with ID " + taskId + " removed successfully.");
                return;
            }

            // Search for the task ID to be deleted
            Node prev = head;
            Node temp = head.next;

            while (temp != head) {
                if (temp.taskId == taskId) {
                    // Update current if it was pointing to the node being deleted
                    if (current == temp) {
                        current = temp.next;
                    }
                    prev.next = temp.next;
                    System.out.println("Task with ID " + taskId + " removed successfully.");
                    return;
                }
                prev = temp;
                temp = temp.next;
            }

            // If task ID was not found
            System.out.println("Task with ID " + taskId + " not found.");
        }

        // View the current task and move to the next task
        public void viewCurrentAndMoveNext() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            System.out.println("\nCurrent Task:");
            displayTask(current);

            // Move to the next task
            current = current.next;
            System.out.println("Moved to the next task.");
        }

        // Display all tasks in the circular list
        public void displayAll() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            Node temp = head;
            System.out.println("\nAll Tasks:");
            do {
                displayTask(temp);
                temp = temp.next;
            } while (temp != head);
        }

        // Search for tasks by priority
        public void searchByPriority(int priority) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            Node temp = head;
            boolean found = false;

            System.out.println("\nTasks with priority " + priority + ":");
            do {
                if (temp.priority == priority) {
                    displayTask(temp);
                    found = true;
                }
                temp = temp.next;
            } while (temp != head);

            if (!found) {
                System.out.println("No tasks found with priority " + priority + ".");
            }
        }

        // Helper method to display a task
        private void displayTask(Node task) {
            System.out.println("Task ID: " + task.taskId);
            System.out.println("Task Name: " + task.taskName);
            System.out.println("Priority: " + task.priority);
            System.out.println("Due Date: " + task.dueDate);
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskCircularList taskList = new TaskCircularList();
        int choice, taskId, priority, position;
        String taskName, dueDate;

        do {
            System.out.println("\nTask Scheduler");
            System.out.println("1. Add a task at the beginning");
            System.out.println("2. Add a task at the end");
            System.out.println("3. Add a task at a specific position");
            System.out.println("4. Remove a task by Task ID");
            System.out.println("5. View current task and move to next");
            System.out.println("6. Display all tasks");
            System.out.println("7. Search for tasks by priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    taskId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Task Name: ");
                    taskName = scanner.nextLine();
                    System.out.print("Enter Priority (1-5): ");
                    priority = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Due Date (DD/MM/YYYY): ");
                    dueDate = scanner.nextLine();
                    taskList.addAtBeginning(taskId, taskName, priority, dueDate);
                    break;

                case 2:
                    System.out.print("Enter Task ID: ");
                    taskId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Task Name: ");
                    taskName = scanner.nextLine();
                    System.out.print("Enter Priority (1-5): ");
                    priority = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Due Date (DD/MM/YYYY): ");
                    dueDate = scanner.nextLine();
                    taskList.addAtEnd(taskId, taskName, priority, dueDate);
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    position = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Task ID: ");
                    taskId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Task Name: ");
                    taskName = scanner.nextLine();
                    System.out.print("Enter Priority (1-5): ");
                    priority = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Due Date (DD/MM/YYYY): ");
                    dueDate = scanner.nextLine();
                    taskList.addAtPosition(position, taskId, taskName, priority, dueDate);
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    taskId = scanner.nextInt();
                    taskList.removeByTaskId(taskId);
                    break;

                case 5:
                    taskList.viewCurrentAndMoveNext();
                    break;

                case 6:
                    taskList.displayAll();
                    break;

                case 7:
                    System.out.print("Enter priority to search (1-5): ");
                    priority = scanner.nextInt();
                    taskList.searchByPriority(priority);
                    break;

                case 8:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}