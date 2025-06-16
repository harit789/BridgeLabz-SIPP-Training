import java.util.Scanner;

public class TemperaturConversion {
    public static void main(String[] args) {
        double fahrenheit, celsiusResult;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        fahrenheit = input.nextDouble();

        celsiusResult = (fahrenheit - 32) * 5 / 9;
        System.out.println("The " + fahrenheit + " Fahrenheit is " + celsiusResult + " Celsius.");
    }
}
