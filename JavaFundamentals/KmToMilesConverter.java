import java.util.Scanner;

public class KmToMilesConverter {
    public static void main(String[] args) {
        double km;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        km = input.nextDouble();
        double miles = km / 1.6;
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");

    }
}
