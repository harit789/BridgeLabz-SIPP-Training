import java.util.Scanner;

public class DiscountCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Student Fee (INR): ");
        double fee = scanner.nextDouble();
        System.out.print("Enter the University Discount Percentage: ");
        double discountPercent = scanner.nextDouble();

        // Calculating discount amount and final fee
        double discount = (discountPercent / 100) * fee;
        double finalFee = fee - discount;
        System.out.println("The discount amount is INR " + discount +
                " and final discounted fee is INR " + finalFee);

        scanner.close();
    }
}
