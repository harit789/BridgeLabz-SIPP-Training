import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        LocalDate date1 = getDate("Enter first date (yyyy-MM-dd): ");
        LocalDate date2 = getDate("Enter second date (yyyy-MM-dd): ");
        compareDates(date1, date2);
    }

    public static LocalDate getDate(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        String input = sc.nextLine();
        return LocalDate.parse(input);
    }

    public static void compareDates(LocalDate d1, LocalDate d2) {
        if (d1.isBefore(d2)) {
            System.out.println("First date is before second date.");
        } else if (d1.isAfter(d2)) {
            System.out.println("First date is after second date.");
        } else {
            System.out.println("Both dates are the same.");
        }
    }
}
