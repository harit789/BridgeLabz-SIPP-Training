// Problem: Remove Duplicates from a String Using StringBuilder
import java.util.HashSet;

public class StringBuilder_RemoveDuplicates {
    public static String removeDuplicates(String input) {
        HashSet<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        System.out.println("Without duplicates: " + removeDuplicates(input));
    }
}