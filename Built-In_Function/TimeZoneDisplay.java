import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneDisplay {
    public static void main(String[] args) {
        displayTime("GMT");
        displayTime("Asia/Kolkata");
        displayTime("America/Los_Angeles");
    }

    public static void displayTime(String zone) {
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of(zone));
        System.out.println(zone + ": " + time.toLocalTime());
    }
}
