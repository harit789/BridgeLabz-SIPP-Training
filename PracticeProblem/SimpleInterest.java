import java.util.*;

class Main{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.print("Principal : ");
int p = sc.nextInt();
System.out.print("Rate : ");
float r = sc.nextFloat();
System.out.print("Time : ");
float t = sc.nextFloat();
float si = (p*r*t)/100;
System.out.print("SI : " + si);
}
}

