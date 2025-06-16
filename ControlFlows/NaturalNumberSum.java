
import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Invalid input! Please enter a natural number (positive integer).");
            return;
        }

        int sumWhile = 0, i = 1;
        while (i <= n) {
            sumWhile += i;
            i++;
        }

        int sumFormula = n * (n + 1) / 2;
        System.out.println("Sum using while loop: " + sumWhile);
        System.out.println("Sum using formula  : " + sumFormula);

        if (sumWhile == sumFormula) {
            System.out.println(" Both results match. The computation is correct.");
        } else {
            System.out.println("Results do not match. Please check the logic.");
        }
    }
}
