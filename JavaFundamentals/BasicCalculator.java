import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        double number1, number2;
        double addition, subtraction, multiplication, division;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        number1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        number2 = input.nextDouble();

        addition = number1 + number2;
        subtraction = number1 - number2;
        multiplication = number1 * number2;

        if (number2 != 0) {
            division = number1 / number2;
        } else {
            division = Double.NaN;
        }

        System.out.println(
                "The addition, subtraction, multiplication, and division value of 2 numbers " +
                        number1 + " and " + number2 + " is " +
                        addition + ", " + subtraction + ", " + multiplication + ", and " + division);
    }
}
