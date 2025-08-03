import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        if (text == null || text.trim().isEmpty()) {
            return wordFrequencies;
        }

        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text.toLowerCase());

        while (matcher.find()) {
            String word = matcher.group();
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }
        return wordFrequencies;
    }

    public static void main(String[] args) {
        System.out.println("--- Word Frequency Counter ---");

        String text1 = "Hello world, hello Java!";
        System.out.println("Input: \"" + text1 + "\"");
        System.out.println("Output: " + countWordFrequency(text1));

        String text2 = "Java is great. Java programming is fun.";
        System.out.println("\nInput: \"" + text2 + "\"");
        System.out.println("Output: " + countWordFrequency(text2));

        String text3 = "One, two, one, three, one.";
        System.out.println("\nInput: \"" + text3 + "\"");
        System.out.println("Output: " + countWordFrequency(text3));

        String text4 = "";
        System.out.println("\nInput: \"" + text4 + "\"");
        System.out.println("Output: " + countWordFrequency(text4));
    }
}
