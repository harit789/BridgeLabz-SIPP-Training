import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        String name, fromCity, viaCity, toCity;
        double fromToVia, viaToFinalCity, timeFromToVia, timeViaToFinalCity;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        name = input.nextLine();

        System.out.print("Enter From City: ");
        fromCity = input.nextLine();

        System.out.print("Enter Via City: ");
        viaCity = input.nextLine();

        System.out.print("Enter Final Destination City: ");
        toCity = input.nextLine();

        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " (in miles): ");
        fromToVia = input.nextDouble();

        System.out.print("Enter distance from " + viaCity + " to " + toCity + " (in miles): ");
        viaToFinalCity = input.nextDouble();

        System.out.print("Enter time from " + fromCity + " to " + viaCity + " (in hours): ");
        timeFromToVia = input.nextDouble();

        System.out.print("Enter time from " + viaCity + " to " + toCity + " (in hours): ");
        timeViaToFinalCity = input.nextDouble();

        double totalDistance = fromToVia + viaToFinalCity;
        double totalTime = timeFromToVia + timeViaToFinalCity;

        System.out.println("\nHello " + name + "!");
        System.out.println("Your travel route is: " + fromCity + " → " + viaCity + " → " + toCity);
        System.out.println("Total distance traveled: " + totalDistance + " miles");
        System.out.println("Total time taken: " + totalTime + " hours");

        input.close();
    }
}
