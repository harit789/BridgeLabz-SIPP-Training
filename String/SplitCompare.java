import java.util.Scanner;

public class SplitCompare {

    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    public static String[] customSplit(String text) {
        int length = getStringLength(text);
        int spaceCount = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int[] spaceIndexes = new int[spaceCount + 2];
        spaceIndexes[0] = -1;
        int index = 1;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        spaceIndexes[spaceCount + 1] = length;

        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            int start = spaceIndexes[i] + 1;
            int end = spaceIndexes[i + 1];
            String word = "";
            for (int j = start; j < end; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }

        return words;
    }

    public static boolean compareStringArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String[] builtInSplit = input.split(" ");
        String[] customSplit = customSplit(input);
        boolean match = compareStringArrays(builtInSplit, customSplit);

        System.out.println("\nBuilt-in split result:");
        for (String word : builtInSplit) {
            System.out.println(word);
        }

        System.out.println("\nCustom split result:");
        for (String word : customSplit) {
            System.out.println(word);
        }

        System.out.println("\nDo both methods give the same result? " + match);
    }
}
