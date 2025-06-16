import java.util.Scanner;

public class ChocolateDivider {
    public static void main(String[] args) {
        int numberOfChocolates, numberOfChildren;
        int chocolatesPerChild, remainingChocolates;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        numberOfChocolates = input.nextInt();

        System.out.print("Enter the number of children: ");
        numberOfChildren = input.nextInt();

        chocolatesPerChild = numberOfChocolates / numberOfChildren;
        remainingChocolates = numberOfChocolates % numberOfChildren;
        System.out.println("The number of chocolates each child gets is " + chocolatesPerChild +
                " and the number of remaining chocolates is " + remainingChocolates);
    }
}
