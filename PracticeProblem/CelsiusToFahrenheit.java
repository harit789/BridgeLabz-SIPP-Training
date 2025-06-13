import java.util.*;

class Main{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.print("Celsius : ");
int celsius = sc.nextInt();
float fahrenheit = (celsius * 9/5) + 32;
System.out.println("Fahrenheit : " + fahrenheit);
}
}