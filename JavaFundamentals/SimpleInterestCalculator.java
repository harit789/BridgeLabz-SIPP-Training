import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        double principal, rate, time, simpleInterest;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Principal amount: ");
        principal = input.nextDouble();

        System.out.print("Enter the Rate of Interest: ");
        rate = input.nextDouble();

        System.out.print("Enter the Time in years: ");
        time = input.nextDouble();

        simpleInterest = (principal * rate * time) / 100;
        System.out.println("The Simple Interest is " + simpleInterest +
                           " for Principal " + principal +
                           ", Rate of Interest " + rate +
                           " and Time " + time);
    }
}
