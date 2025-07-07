import java.util.Scanner;

public class TextEditorUndoRedo {
    static class StateNode {
        String text;
        StateNode prev;
        StateNode next;
        public StateNode(String text) {
            this.text = text;
            this.prev = null;
            this.next = null;
        }
    }

    static class UndoRedoList {
        StateNode head;
        StateNode tail;
        StateNode current;
        int size;
        int maxSize;

        public UndoRedoList(int maxSize) {
            this.head = null;
            this.tail = null;
            this.current = null;
            this.size = 0;
            this.maxSize = maxSize;
        }

        public void addState(String text) {
            StateNode newNode = new StateNode(text);
            if (head == null) {
                head = tail = current = newNode;
                size = 1;
                return;
            }
            // Remove all redo states
            if (current != tail) {
                StateNode temp = current.next;
                while (temp != null) {
                    StateNode next = temp.next;
                    temp.prev = null;
                    temp.next = null;
                    temp = next;
                    size--;
                }
                current.next = null;
                tail = current;
            }
            // Add new state
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = newNode;
            size++;
            // Limit history size
            while (size > maxSize) {
                head = head.next;
                if (head != null) head.prev = null;
                size--;
            }
        }

        public boolean undo() {
            if (current != null && current.prev != null) {
                current = current.prev;
                return true;
            }
            return false;
        }

        public boolean redo() {
            if (current != null && current.next != null) {
                current = current.next;
                return true;
            }
            return false;
        }

        public String getCurrentState() {
            return current != null ? current.text : "";
        }

        public void displayHistory() {
            StateNode temp = head;
            int idx = 1;
            System.out.println("\nUndo/Redo History:");
            while (temp != null) {
                String marker = (temp == current) ? " <== Current" : "";
                System.out.println(idx + ". " + temp.text + marker);
                temp = temp.next;
                idx++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UndoRedoList editor = new UndoRedoList(10); // Limit history to last 10 states
        int choice;
        do {
            System.out.println("\nText Editor Undo/Redo");
            System.out.println("1. Type new text (add state)");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display current text");
            System.out.println("5. Display undo/redo history");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = scanner.nextLine();
                    editor.addState(text);
                    System.out.println("Text state added.");
                    break;
                case 2:
                    if (editor.undo()) {
                        System.out.println("Undo successful.");
                    } else {
                        System.out.println("No more undo available.");
                    }
                    break;
                case 3:
                    if (editor.redo()) {
                        System.out.println("Redo successful.");
                    } else {
                        System.out.println("No more redo available.");
                    }
                    break;
                case 4:
                    System.out.println("Current text: " + editor.getCurrentState());
                    break;
                case 5:
                    editor.displayHistory();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
        scanner.close();
    }
}