import java.util.Scanner;

public class StudentRecordManagement {
    // Node class to represent a student record
    static class Node {
        int rollNumber;
        String name;
        int age;
        String grade;
        Node next;

        // Constructor
        public Node(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    // LinkedList class to manage student records
    static class StudentLinkedList {
        Node head;

        // Constructor
        public StudentLinkedList() {
            this.head = null;
        }

        // Add a student at the beginning of the list
        public void addAtBeginning(int rollNumber, String name, int age, String grade) {
            Node newNode = new Node(rollNumber, name, age, grade);
            newNode.next = head;
            head = newNode;
            System.out.println("Student added at the beginning successfully.");
        }

        // Add a student at the end of the list
        public void addAtEnd(int rollNumber, String name, int age, String grade) {
            Node newNode = new Node(rollNumber, name, age, grade);

            // If the list is empty, make the new node as head
            if (head == null) {
                head = newNode;
                System.out.println("Student added at the end successfully.");
                return;
            }

            // Traverse to the last node
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            // Add the new node at the end
            temp.next = newNode;
            System.out.println("Student added at the end successfully.");
        }

        // Add a student at a specific position
        public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
            // If position is 1, add at the beginning
            if (position == 1) {
                addAtBeginning(rollNumber, name, age, grade);
                return;
            }

            Node newNode = new Node(rollNumber, name, age, grade);
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
            System.out.println("Student added at position " + position + " successfully.");
        }

        // Delete a student by roll number
        public void deleteByRollNumber(int rollNumber) {
            // If list is empty
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            // If the head node itself holds the roll number to be deleted
            if (head.rollNumber == rollNumber) {
                head = head.next;
                System.out.println("Student with roll number " + rollNumber + " deleted successfully.");
                return;
            }

            // Search for the roll number to be deleted
            Node temp = head;
            Node prev = null;

            while (temp != null && temp.rollNumber != rollNumber) {
                prev = temp;
                temp = temp.next;
            }

            // If roll number was not found
            if (temp == null) {
                System.out.println("Student with roll number " + rollNumber + " not found.");
                return;
            }

            // Unlink the node from the list
            prev.next = temp.next;
            System.out.println("Student with roll number " + rollNumber + " deleted successfully.");
        }

        // Search for a student by roll number
        public void searchByRollNumber(int rollNumber) {
            Node temp = head;
            boolean found = false;

            while (temp != null) {
                if (temp.rollNumber == rollNumber) {
                    System.out.println("Student found:");
                    System.out.println("Roll Number: " + temp.rollNumber);
                    System.out.println("Name: " + temp.name);
                    System.out.println("Age: " + temp.age);
                    System.out.println("Grade: " + temp.grade);
                    found = true;
                    break;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("Student with roll number " + rollNumber + " not found.");
            }
        }

        // Display all student records
        public void displayAll() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            Node temp = head;
            System.out.println("\nStudent Records:");
            while (temp != null) {
                System.out.println("Roll Number: " + temp.rollNumber);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                System.out.println("------------------------");
                temp = temp.next;
            }
        }

        // Update a student's grade based on roll number
        public void updateGrade(int rollNumber, String newGrade) {
            Node temp = head;
            boolean found = false;

            while (temp != null) {
                if (temp.rollNumber == rollNumber) {
                    temp.grade = newGrade;
                    System.out.println("Grade updated successfully for student with roll number " + rollNumber);
                    found = true;
                    break;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("Student with roll number " + rollNumber + " not found.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentLinkedList studentList = new StudentLinkedList();
        int choice, rollNumber, age, position;
        String name, grade;

        do {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add a student at the beginning");
            System.out.println("2. Add a student at the end");
            System.out.println("3. Add a student at a specific position");
            System.out.println("4. Delete a student by roll number");
            System.out.println("5. Search for a student by roll number");
            System.out.println("6. Display all student records");
            System.out.println("7. Update a student's grade");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter grade: ");
                    grade = scanner.nextLine();
                    studentList.addAtBeginning(rollNumber, name, age, grade);
                    break;

                case 2:
                    System.out.print("Enter roll number: ");
                    rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter grade: ");
                    grade = scanner.nextLine();
                    studentList.addAtEnd(rollNumber, name, age, grade);
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    position = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter roll number: ");
                    rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter grade: ");
                    grade = scanner.nextLine();
                    studentList.addAtPosition(position, rollNumber, name, age, grade);
                    break;

                case 4:
                    System.out.print("Enter roll number to delete: ");
                    rollNumber = scanner.nextInt();
                    studentList.deleteByRollNumber(rollNumber);
                    break;

                case 5:
                    System.out.print("Enter roll number to search: ");
                    rollNumber = scanner.nextInt();
                    studentList.searchByRollNumber(rollNumber);
                    break;

                case 6:
                    studentList.displayAll();
                    break;

                case 7:
                    System.out.print("Enter roll number to update grade: ");
                    rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter new grade: ");
                    grade = scanner.nextLine();
                    studentList.updateGrade(rollNumber, grade);
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