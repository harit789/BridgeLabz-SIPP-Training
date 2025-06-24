package Built_In_Function.Level_1;
import java.util.*;
public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int number =scanner.nextInt();
        if(check(number)){
            System.out.println(number +" is Prime Number.");
        }
        else{
            System.out.println(number+" is not Prime Number.");
        }



    }
    public static boolean check(int number){
        if(number <=1) return false;

        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i ==0) return false;
        }
        return true;

    }
}
