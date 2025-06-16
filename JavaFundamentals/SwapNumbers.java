import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        int number1, number2, temp;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number1: ");
        number1 = input.nextInt();

        System.out.print("Enter number2: ");
        number2 = input.nextInt();

        temp = number1;
        number1 = number2;
        number2 = temp;

        System.out.println("The swapped numbers are " + number1 + " and " + number2);
    }
}
