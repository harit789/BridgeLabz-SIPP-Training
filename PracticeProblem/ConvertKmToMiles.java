import java.util.*;

class Main{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.print("Kilometers : ");
int km = sc.nextInt();
double miles = km * 0.621371;
System.out.println("Miles : " + miles);
}
}