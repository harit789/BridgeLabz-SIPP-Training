import java.util.Scanner;

public class SumUntilNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter natural numbers to add. Enter 0 or a negative number to stop:");

        while (true) {
            System.out.print("Enter number: ");
            int num = scanner.nextInt();

            if (num <= 0) {
                System.out.println("Stopping input. Final sum calculated.");
                break;
            }

            sum += num;
        }

        System.out.println("Total sum = " + sum);
    }
}
