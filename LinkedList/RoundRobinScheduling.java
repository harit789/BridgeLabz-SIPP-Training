import java.util.Scanner;

public class RoundRobinScheduling {
    // Node class to represent a process
    static class Node {
        int processId;
        int burstTime;
        int remainingTime; // To keep track of remaining execution time
        int priority;
        int waitingTime;
        int turnaroundTime;
        Node next;

        // Constructor
        public Node(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
            this.waitingTime = 0;
            this.turnaroundTime = 0;
            this.next = null;
        }
    }

    // CircularLinkedList class to manage processes
    static class ProcessCircularLinkedList {
        Node head;
        Node tail;
        int processCount;

        // Constructor
        public ProcessCircularLinkedList() {
            this.head = null;
            this.tail = null;
            this.processCount = 0;
        }

        // Add a process at the end of the circular list
        public void addProcess(int processId, int burstTime, int priority) {
            Node newNode = new Node(processId, burstTime, priority);

            // If the list is empty
            if (head == null) {
                head = newNode;
                tail = newNode;
                tail.next = head; // Make it circular
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head; // Maintain circular structure
            }

            processCount++;
            System.out.println("Process P" + processId + " added successfully.");
        }

        // Remove a process by Process ID
        public void removeProcess(int processId) {
            // If list is empty
            if (head == null) {
                System.out.println("No processes in the queue.");
                return;
            }

            Node current = head;
            Node prev = null;
            boolean found = false;

            // If there is only one node
            if (head == tail && head.processId == processId) {
                head = null;
                tail = null;
                found = true;
                processCount--;
                System.out.println("Process P" + processId + " removed successfully.");
                return;
            }

            // If the head node is to be removed
            if (head.processId == processId) {
                tail.next = head.next;
                head = head.next;
                found = true;
                processCount--;
                System.out.println("Process P" + processId + " removed successfully.");
                return;
            }

            // Search for the process to be removed
            prev = head;
            current = head.next;

            while (current != head) {
                if (current.processId == processId) {
                    // If the tail node is to be removed
                    if (current == tail) {
                        tail = prev;
                    }
                    prev.next = current.next;
                    found = true;
                    processCount--;
                    System.out.println("Process P" + processId + " removed successfully.");
                    break;
                }
                prev = current;
                current = current.next;
            }

            if (!found) {
                System.out.println("Process P" + processId + " not found.");
            }
        }

        // Simulate round-robin scheduling
        public void simulateRoundRobin(int timeQuantum) {
            if (head == null) {
                System.out.println("No processes in the queue.");
                return;
            }

            System.out.println("\nSimulating Round Robin Scheduling with Time Quantum = " + timeQuantum);
            System.out.println("Process Execution Order:");

            Node current = head;
            int currentTime = 0;
            boolean allProcessesCompleted = false;

            // Initialize an array to store completion times
            int[] completionTime = new int[processCount + 1]; // +1 because process IDs might start from 1

            while (!allProcessesCompleted) {
                allProcessesCompleted = true;

                // Check if there are any processes with remaining time
                Node temp = head;
                do {
                    if (temp.remainingTime > 0) {
                        allProcessesCompleted = false;
                        break;
                    }
                    temp = temp.next;
                } while (temp != head);

                if (allProcessesCompleted) {
                    break;
                }

                // Execute the current process for the time quantum or until it completes
                if (current.remainingTime > 0) {
                    System.out.print("P" + current.processId + " -> ");

                    // Execute for time quantum or until process completes
                    int executeTime = Math.min(timeQuantum, current.remainingTime);
                    current.remainingTime -= executeTime;
                    currentTime += executeTime;

                    // If the process has completed
                    if (current.remainingTime == 0) {
                        completionTime[current.processId] = currentTime;
                    }
                }

                // Move to the next process
                current = current.next;
            }

            System.out.println("End");

            // Calculate waiting time and turnaround time for each process
            calculateTimes(completionTime);

            // Display the list of processes after simulation
            displayProcesses();

            // Calculate and display average waiting time and turnaround time
            calculateAverageTimes();

            // Reset remaining times for potential re-simulation
            resetRemainingTimes();
        }

        // Calculate waiting time and turnaround time for each process
        private void calculateTimes(int[] completionTime) {
            Node current = head;

            if (current == null) {
                return;
            }

            do {
                current.turnaroundTime = completionTime[current.processId];
                current.waitingTime = current.turnaroundTime - current.burstTime;
                current = current.next;
            } while (current != head);
        }

        // Calculate and display average waiting time and turnaround time
        private void calculateAverageTimes() {
            if (head == null) {
                return;
            }

            double totalWaitingTime = 0;
            double totalTurnaroundTime = 0;
            Node current = head;

            do {
                totalWaitingTime += current.waitingTime;
                totalTurnaroundTime += current.turnaroundTime;
                current = current.next;
            } while (current != head);

            double avgWaitingTime = totalWaitingTime / processCount;
            double avgTurnaroundTime = totalTurnaroundTime / processCount;

            System.out.println("\nAverage Waiting Time: " + String.format("%.2f", avgWaitingTime));
            System.out.println("Average Turnaround Time: " + String.format("%.2f", avgTurnaroundTime));
        }

        // Reset remaining times for re-simulation
        private void resetRemainingTimes() {
            if (head == null) {
                return;
            }

            Node current = head;

            do {
                current.remainingTime = current.burstTime;
                current = current.next;
            } while (current != head);
        }

        // Display all processes in the circular queue
        public void displayProcesses() {
            if (head == null) {
                System.out.println("No processes in the queue.");
                return;
            }

            Node current = head;
            System.out.println("\nProcesses in the Queue:");
            System.out.println("Process ID | Burst Time | Priority | Waiting Time | Turnaround Time");
            System.out.println("------------------------------------------------------------------");

            do {
                System.out.printf("%-11d | %-10d | %-8d | %-12d | %-15d\n",
                        current.processId, current.burstTime, current.priority,
                        current.waitingTime, current.turnaroundTime);
                current = current.next;
            } while (current != head);
        }

        // Search for a process by Priority
        public void searchByPriority(int priority) {
            if (head == null) {
                System.out.println("No processes in the queue.");
                return;
            }

            Node current = head;
            boolean found = false;

            System.out.println("\nProcesses with Priority " + priority + ":");
            System.out.println("Process ID | Burst Time | Priority");
            System.out.println("-----------------------------------");

            do {
                if (current.priority == priority) {
                    System.out.printf("%-11d | %-10d | %-8d\n",
                            current.processId, current.burstTime, current.priority);
                    found = true;
                }
                current = current.next;
            } while (current != head);

            if (!found) {
                System.out.println("No processes found with Priority " + priority + ".");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProcessCircularLinkedList processQueue = new ProcessCircularLinkedList();
        int choice, processId, burstTime, priority, timeQuantum;

        do {
            System.out.println("\nRound Robin CPU Scheduling");
            System.out.println("1. Add a new process");
            System.out.println("2. Remove a process");
            System.out.println("3. Simulate round-robin scheduling");
            System.out.println("4. Display all processes");
            System.out.println("5. Search for a process by Priority");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    processId = scanner.nextInt();
                    System.out.print("Enter Burst Time: ");
                    burstTime = scanner.nextInt();
                    System.out.print("Enter Priority: ");
                    priority = scanner.nextInt();
                    processQueue.addProcess(processId, burstTime, priority);
                    break;

                case 2:
                    System.out.print("Enter Process ID to remove: ");
                    processId = scanner.nextInt();
                    processQueue.removeProcess(processId);
                    break;

                case 3:
                    System.out.print("Enter Time Quantum: ");
                    timeQuantum = scanner.nextInt();
                    processQueue.simulateRoundRobin(timeQuantum);
                    break;

                case 4:
                    processQueue.displayProcesses();
                    break;

                case 5:
                    System.out.print("Enter Priority to search: ");
                    priority = scanner.nextInt();
                    processQueue.searchByPriority(priority);
                    break;

                case 6:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}