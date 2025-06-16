import java.util.Scanner;

public class AthleteRun {
    public static void main(String[] args) {
        double side1, side2, side3, perimeter, rounds;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter side 1 in meters: ");
        side1 = input.nextDouble();

        System.out.print("Enter side 2 in meters: ");
        side2 = input.nextDouble();

        System.out.print("Enter side 3 in meters: ");
        side3 = input.nextDouble();
        perimeter = side1 + side2 + side3;

        rounds = 5000 / perimeter;

        System.out.println("The total number of rounds the athlete will run is " + rounds +
                           " to complete 5 km");

        input.close();
    }
}
