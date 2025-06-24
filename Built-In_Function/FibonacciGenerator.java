package Built_In_Function.Level_1;
import java.util.*;
public class FibonacciGenerator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the numbers of terms: ");
        int terms=scanner.nextInt();
        if(terms<=0){
            System.out.println("Enter Positive Number please:");
        }else{
            generare(terms);
        }

        System.out.println("Fibonacci Sum upto n terms: "+ fibonaccisum(terms));
scanner.close();
    }
    public static void generare(int terms){
        int num1=0;int num2=1;
        if(terms>=1){
            System.out.println(num1+" ");
        }
        if(terms>=2){
            System.out.println(num2+" ");
        }
        for(int i=3;i<=terms;i++){
            int fibonacci=num1+num2;
            System.out.println(fibonacci+" ");
            num1=num2;
            num2=fibonacci;
        }
        System.out.println();
        
    }
    public static int fibonaccisum(int terms){
        if(terms==0 || terms==1) return terms;
        return fibonaccisum(terms-1)+fibonaccisum(terms-2);
    }
}
