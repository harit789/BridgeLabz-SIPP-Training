import java.util.Scanner;

public class SumOfNaturural {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

    
        if (n <= 0) {
            System.out.println("Please enter a valid natural number (greater than 0).");
            return;
        }

        int i = 1;
        int sumWhile = 0;
        while (i <= n) {
            sumWhile += i;
            i++;
        }

        int sumFormula = n * (n + 1) / 2;

        
        System.out.println("Sum using while loop: " + sumWhile);
        System.out.println("Sum using formula  : " + sumFormula);

        if (sumWhile == sumFormula) {
            System.out.println("Both results are correct and equal.");
        } else {
            System.out.println("There is a mismatch in the results!");
        }

        sc.close();
    }
}
