import java.util.Scanner;

public class MaxHandshakes {
    public static void main(String[] args) {
        int numberOfStudents, maxHandshakes;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        numberOfStudents = input.nextInt();

        maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        System.out.println("The maximum number of handshakes possible among " + numberOfStudents +
                " students is " + maxHandshakes);
    }
}
