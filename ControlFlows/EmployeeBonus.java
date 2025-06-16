import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter your years of service: ");
        int yearsOfService = scanner.nextInt();

        if (yearsOfService > 5) {
            double bonus = 0.05 * salary; 
            System.out.println("You are eligible for a bonus of: ₹" + bonus);
        } else {
            System.out.println("You are not eligible for a bonus.");
        }

    }
}
 
