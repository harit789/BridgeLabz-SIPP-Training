import java.util.Scanner;

public class NumberFormat {

    public static void generateException(String input) {
        int number = Integer.parseInt(input);
        System.out.println("Parsed number: " + number);
    }

    public static void handleException(String input) {
        try {
            int number = Integer.parseInt(input);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: Input is not a valid integer.");
        } catch (RuntimeException e) {
            System.out.println("Caught a generic RuntimeException.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value: ");
        String userInput = scanner.nextLine();
       
        handleException(userInput);
    }
}
