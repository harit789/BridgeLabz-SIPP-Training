import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        formatDate(today, "dd/MM/yyyy");
        formatDate(today, "yyyy-MM-dd");
        formatDate(today, "EEE, MMM dd, yyyy");
    }

    public static void formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        System.out.println(date.format(formatter));
    }
}
