import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    public static void generateException(String[] names) {
        System.out.println("Accessing invalid index...");
        String name = names[names.length];
        System.out.println("Name: " + name);
    }

    public static void handleException(String[] names) {
        try {
            System.out.println("Trying to access invalid index...");
            String name = names[names.length];
            System.out.println("Name: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught General Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = scanner.nextInt();
        String[] names = new String[n];
        System.out.println("Enter names:");
        for (int i = 0; i < n; i++) {
            names[i] = scanner.next();
        }

        try {
            generateException(names);
        } catch (Exception e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }

        handleException(names);
    }
}
