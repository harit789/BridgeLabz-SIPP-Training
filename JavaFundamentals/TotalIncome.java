import java.util.Scanner;

public class TotalIncome {
    public static void main(String[] args) {
        double salary, bonus, totalIncome;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your salary (INR): ");
        salary = input.nextDouble();

        System.out.print("Enter your bonus (INR): ");
        bonus = input.nextDouble();

        totalIncome = salary + bonus;
        System.out.println("The salary is INR " + salary + " and the bonus is INR " + bonus +
                ". Hence Total Income is INR " + totalIncome + ".");

        input.close();
    }
}
