import java.util.Scanner;

public class WordLengthFinder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] words = splitIntoWords(text);
        String[][] wordLengths = getWordsWithLengths(words);

        System.out.println("Word\tLength");
        for (int i = 0; i < wordLengths.length; i++) {
            System.out.println(wordLengths[i][0] + "\t" + Integer.parseInt(wordLengths[i][1]));
        }
    }

    public static String[] splitIntoWords(String text) {
        int length = getLength(text);
        String[] temp = new String[length]; 
        int index = 0;
        String word = "";

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else {
                if (!word.equals("")) {
                    temp[index++] = word;
                    word = "";
                }
            }
        }
        if (!word.equals("")) {
            temp[index++] = word;
        }

        String[] words = new String[index];
        for (int i = 0; i < index; i++) {
            words[i] = temp[i];
        }
        return words;
    }

    public static int getLength(String s) {
        int count = 0;
        try {
            while(true) {
                s.charAt(count);
                count++;
            }
        } catch(Exception e) {
        }
        return count;
    }

    public static String[][] getWordsWithLengths(String[] words) {
        int n = words.length;
        String[][] result = new String[n][2];
        for (int i = 0; i < n; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }
}
