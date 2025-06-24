import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        LocalDate date = getDateInput();
        LocalDate modifiedDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        System.out.println("Final date after operations: " + modifiedDate);
    }

    public static LocalDate getDateInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date (yyyy-MM-dd): ");
        String input = sc.nextLine();
        return LocalDate.parse(input);
    }
}
