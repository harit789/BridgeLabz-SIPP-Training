import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Current Year : ");
        int curr = sc.nextInt();
        System.out.print("Birth Year : ");
        int birth = sc.nextInt();
        int age = curr - birth;
        System.out.println("Harry's age in 2024 is : " + age);
    }
}