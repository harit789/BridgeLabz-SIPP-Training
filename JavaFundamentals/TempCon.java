import java.util.Scanner;

public class TempCon {
    public static void main(String[] args) {
        double celsius, fahrenheitResult;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        celsius = input.nextDouble();
        fahrenheitResult = (celsius * 9 / 5) + 32;
        System.out.println("The " + celsius + " Celsius is " + fahrenheitResult + " Fahrenheit.");
    }
}
