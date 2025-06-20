import java.util.Scanner;

public class CharTypeIdentifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[][] classified = classifyCharacters(input);
        displayClassification(classified);
    }

    public static String checkCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    public static String[][] classifyCharacters(String text) {
        int length = getLength(text);
        String[][] result = new String[length][2];
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }
        return result;
    }

    public static void displayClassification(String[][] data) {
        System.out.println("Character | Type");
        System.out.println("----------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("    %s     | %s%n", data[i][0], data[i][1]);
        }
    }

    public static int getLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {
           
        }
        return count;
    }
}
