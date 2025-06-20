import java.util.Scanner;

public class CharArrayCompare {


    public static char[] getCharsFromString(String input) {
        char[] chars = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            chars[i] = input.charAt(i);
        }
        return chars;
    }

   
    public static boolean compareCharArrays(char[] a1, char[] a2) {
        if (a1.length != a2.length)
            return false;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.print("Enter a word: ");
        String input = scanner.next();
        char[] customChars = getCharsFromString(input);


        char[] builtInChars = input.toCharArray();

      
        boolean isEqual = compareCharArrays(customChars, builtInChars);
        System.out.print("Custom Characters: ");
        for (char c : customChars) System.out.print(c + " ");
        System.out.println();

        System.out.print("Built-in Characters: ");
        for (char c : builtInChars) System.out.print(c + " ");
        System.out.println();

        System.out.println("Are both character arrays equal? " + isEqual);
    }
}
