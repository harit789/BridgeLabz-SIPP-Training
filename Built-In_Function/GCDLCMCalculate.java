package Built_In_Function.Level_1;
import java.util.*;
public class GCDLCMCalculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int number1=scanner.nextInt();
        int number2=scanner.nextInt();
        System.out.println("GCD is : "+ gcdcalculate(number1, number2));
        System.out.println("LCM is : "+ lcm(number1, number2));
        
    }
    public static int gcdcalculate(int number1,int number2){
        while(number2 !=0){
            int temp=number2;
            number2=number1%number2;
            number1=temp;
        }
        return number1;
    }
    public static int lcm(int number1,int number2){
        return (number1*number2)/gcdcalculate(number1, number2);
    }
}
