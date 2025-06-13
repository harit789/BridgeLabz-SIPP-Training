import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Num1: ");
        int num1 = sc.nextInt();
        System.out.print("Num2: ");
        int num2 = sc.nextInt();
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("The swapped numbers are " + num1  + " an d " + num2);
    }
}