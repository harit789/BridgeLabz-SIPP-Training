
import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = input.nextInt();

        double[][] personData = new double[number][3]; // 0: weight (kg), 1: height (cm), 2: BMI
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Person " + (i + 1));

            double weight;
            do {
                System.out.print("Enter weight in kg: ");
                weight = input.nextDouble();
            } while (weight <= 0);

            double height;
            do {
                System.out.print("Enter height in cm: ");
                height = input.nextDouble();
            } while (height <= 0);

            double heightInMeters = height / 100.0;
            double bmi = weight / (heightInMeters * heightInMeters);

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nBMI Report:");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1)
                    + " - Weight: " + personData[i][0] + " kg, "
                    + "Height: " + personData[i][1] + " cm, "
                    + "BMI: " + String.format("%.2f", personData[i][2]) + ", "
                    + "Status: " + weightStatus[i]);
        }
    }
}
