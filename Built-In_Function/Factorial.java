package Built_In_Function.Level_1;
import java.util.*;
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int number=scanner.nextInt();
        System.out.println("Factorial is : " + calculate(number));
    }
    public static int calculate(int number){
        if(number ==0 || number==1) return 1;
        return number * calculate(number-1);
    }
}
