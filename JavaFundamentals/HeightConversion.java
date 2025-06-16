import java.util.Scanner;
public class HeightConversion{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your height in cm:");
		double Height = scan.nextDouble();
		double totalInches = Height / 2.54;
                int feet = (int)(totalInches / 12);
                double inches = totalInches % 12;
		System.out.printf("Your height in cm is %.2f while in feet is %d and inches is %.2f%n", Height, feet, inches);
	}
}
