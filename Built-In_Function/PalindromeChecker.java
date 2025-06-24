package Built_In_Function.Level_1;
import java.util.*;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String to Check: ");
        String word=scanner.nextLine();
        boolean answer=isPalindrome(word);
        if(answer){
            System.out.println(word +" is Palindrome");
        }
        else{
            System.out.println(word +" is not Palindrome");
        }
        scanner.close();
    }
    public static boolean isPalindrome(String word){
        word=word.toLowerCase();
        String reverse="";
        for(int i=word.length()-1;i>=0;i--){
            reverse+=word.charAt(i);
        }
        if(word.equals(reverse)) return true;

        return false;
    }
}
