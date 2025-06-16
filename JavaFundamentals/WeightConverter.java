import java.util.Scanner;

public class WeightConverter {
    public static void main(String[] args) {
        double weightInPounds, weightInKg;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the weight in pounds: ");
        weightInPounds = input.nextDouble();

        weightInKg = weightInPounds / 2.2;
        System.out.println("The weight of the person in pounds is " + weightInPounds +
                           " and in kg is " + weightInKg);
    }
}
