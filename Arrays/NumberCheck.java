import java.util.Scanner;

public class NumberCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            System.out.print("Number " + num + " is ");

            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println("positive and even");
                } else {
                    System.out.println("positive and odd");
                }
            } else if (num < 0) {
                System.out.println("negative");
            } else {
                System.out.println("zero");
            }
        }

        int first = numbers[0];
        int last = numbers[4];

        System.out.print("Comparison of first and last elements: ");
        if (first == last) {
            System.out.println("They are equal");
        } else if (first > last) {
            System.out.println("First element is greater than the last");
        } else {
            System.out.println("First element is less than the last");
        }
    }
}
