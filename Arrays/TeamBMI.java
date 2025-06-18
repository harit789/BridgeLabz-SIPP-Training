import java.util.Scanner;

public class TeamBMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int number = input.nextInt();

        double[] weight = new double[number];
        double[] height = new double[number];
        double[] bmi = new double[number];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));

            do {
                System.out.print("Enter weight in kg: ");
                weight[i] = input.nextDouble();
                if (weight[i] <= 0) System.out.println("Please enter a positive weight.");
            } while (weight[i] <= 0);

            do {
                System.out.print("Enter height in cm: ");
                height[i] = input.nextDouble();
                if (height[i] <= 0) System.out.println("Please enter a positive height.");
            } while (height[i] <= 0);

            double heightInMeters = height[i] / 100;
            bmi[i] = weight[i] / (heightInMeters * heightInMeters);

            if (bmi[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi[i] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("\n=== BMI Report ===");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d -> Height: %.2f cm, Weight: %.2f kg, BMI: %.2f, Status: %s\n",
                    i + 1, height[i], weight[i], bmi[i], weightStatus[i]);
        }

        input.close();
    }
}
