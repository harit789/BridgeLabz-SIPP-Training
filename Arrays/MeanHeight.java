
import java.util.Scanner;

public class MeanHeight {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0;

        System.out.println("Enter the height of 11 football players (in cm or meters):");

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
            sum += heights[i];
        }

        double mean = sum / 11;
        System.out.println("The mean height of the football players is: " + mean);
    }
}
