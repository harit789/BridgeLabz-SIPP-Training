package Built_In_Function.Level_1;

import java.util.Scanner;

public class MaximumThree {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("Enter All Three Numbers : ");
        int num1=scanner.nextInt();
        int num2=scanner.nextInt();
        int num3=scanner.nextInt();
        int maximum = findMaximum(num1, num2, num3);
        System.out.println("The maximum number is: " + maximum);

        scanner.close();
    }
     
    public static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

  
}
