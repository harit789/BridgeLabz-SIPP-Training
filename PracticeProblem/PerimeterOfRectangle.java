import java.util.*;

class Main{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.print("Length : ");
int l = sc.nextInt();
System.out.print("Width : ");
int w = sc.nextInt();
double perimeter = 2 * (l + w);
System.out.print("Perimeter : " + perimeter);
}
}