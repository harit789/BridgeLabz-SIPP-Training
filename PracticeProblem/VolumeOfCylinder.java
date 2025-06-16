import java.util.*;
class Main{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.print("Radius : ");
int radius = sc.nextInt();
System.out.print("Height : ");
int height = sc.nextInt();
double pie = 3.14;
double volume = pie * (radius * radius) * height;
System.out.print("Volume : " + volume);
}
}