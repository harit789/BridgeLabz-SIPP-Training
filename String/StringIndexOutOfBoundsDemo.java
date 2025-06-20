import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public static void generateException(String input) {
        System.out.println("Accessing character beyond string length...");
        char ch = input.charAt(input.length());
        System.out.println("Character: " + ch);
    }

    public static void handleException(String input) {
        try {
            System.out.println("Trying to access character beyond string length...");
            char ch = input.charAt(input.length());
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught General Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();

        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }

        handleException(input);
    }
}
