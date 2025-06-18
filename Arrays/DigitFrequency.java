import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        number = Math.abs(number);

        int temp = number;
        int[] digits = new int[10];

        while (temp != 0) {
            int digit = temp % 10;
            digits[digit]++;
            temp /= 10;
        }

        System.out.println("\nDigit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (digits[i] > 0) {
                System.out.println("Digit " + i + " occurs " + digits[i] + " time(s)");
            }
        }

        input.close();
    }
}
