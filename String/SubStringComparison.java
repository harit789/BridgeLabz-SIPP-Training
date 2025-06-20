import java.util.Scanner;

 class SubstringComparison {

    public static String manualSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end && i < text.length(); i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.next();
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        String manualSub = manualSubstring(text, start, end);
        String builtInSub = "";
        if (start >= 0 && end <= text.length()) {
            builtInSub = text.substring(start, end);
        } else {
            System.out.println("Invalid index range for built-in substring.");
        }

        System.out.println("Manual Substring: " + manualSub);
        System.out.println("Built-in Substring: " + builtInSub);
        System.out.println("Are both substrings equal? " + compareStrings(manualSub, builtInSub));
    }
}
