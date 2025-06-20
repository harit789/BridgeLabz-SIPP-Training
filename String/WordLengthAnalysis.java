import java.util.Scanner;

public class WordLengthAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] words = splitTextIntoWords(input);
        String[][] wordLengths = getWordsWithLengths(words);
        int[] result = findShortestAndLongest(wordLengths);

        System.out.println("Shortest word: " + words[result[0]]);
        System.out.println("Longest word: " + words[result[1]]);
    }

    public static String[] splitTextIntoWords(String text) {
        int start = 0;
        int count = 0;
        String[] tempWords = new String[100];
        for (int i = 0; i <= getLength(text); i++) {
            if (i == getLength(text) || text.charAt(i) == ' ') {
                String word = "";
                for (int j = start; j < i; j++) {
                    word += text.charAt(j);
                }
                tempWords[count++] = word;
                start = i + 1;
            }
        }
        String[] words = new String[count];
        for (int i = 0; i < count; i++) {
            words[i] = tempWords[i];
        }
        return words;
    }

    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestAndLongest(String[][] wordLengths) {
        int minIndex = 0;
        int maxIndex = 0;
        int minLength = Integer.parseInt(wordLengths[0][1]);
        int maxLength = Integer.parseInt(wordLengths[0][1]);

        for (int i = 1; i < wordLengths.length; i++) {
            int len = Integer.parseInt(wordLengths[i][1]);
            if (len < minLength) {
                minLength = len;
                minIndex = i;
            }
            if (len > maxLength) {
                maxLength = len;
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }
}
