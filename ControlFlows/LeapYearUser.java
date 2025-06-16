
import java.util.Scanner;

public class LeapYearUser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        if (year < 1582) {
            System.out.println("The year " + year + " is before the Gregorian calendar. Not a Leap Year.");
        } else if (year % 400 == 0) {
            System.out.println("The year " + year + " is a Leap Year.");
        } else if (year % 100 == 0) {
            System.out.println("The year " + year + " is Not a Leap Year.");
        } else if (year % 4 == 0) {
            System.out.println("The year " + year + " is a Leap Year.");
        } else {
            System.out.println("The year " + year + " is Not a Leap Year.");
        }
    }
}
