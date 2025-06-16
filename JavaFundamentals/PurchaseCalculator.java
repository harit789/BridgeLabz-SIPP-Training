import java.util.Scanner;

public class PurchaseCalculator {
    public static void main(String[] args) {
        double unitPrice;
        int quantity;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the unit price (INR): ");
        unitPrice = input.nextDouble();

        System.out.print("Enter the quantity: ");
        quantity = input.nextInt();
        double totalPrice = unitPrice * quantity;
        System.out.println("The total purchase price is INR " + totalPrice +
                " if the quantity is " + quantity + " and the unit price is INR " + unitPrice);
    }
}
