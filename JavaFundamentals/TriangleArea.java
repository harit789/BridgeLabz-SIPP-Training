import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        double base, height;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the base of the triangle in cm: ");
        base = input.nextDouble();

        System.out.print("Enter the height of the triangle in cm: ");
        height = input.nextDouble();

        double areaCm2 = 0.5 * base * height;

        double areaIn2 = areaCm2 / 6.4516;

        System.out.println("The Area of the triangle in sq in is " + areaIn2 + " and sq cm is " + areaCm2);
    }
}
