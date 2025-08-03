import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ElementFrequency {

    public static Map<String, Integer> findFrequencyOfElements(List<String> stringList) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String element : stringList) {
            int count = frequencyMap.getOrDefault(element, 0);
            frequencyMap.put(element, count + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        System.out.println("--- Element Frequency ---");
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("apple");
        words.add("orange");
        words.add("banana");
        words.add("apple");
        System.out.println("Input List for Frequency: " + words);
        Map<String, Integer> frequency = findFrequencyOfElements(words);
        System.out.println("Element Frequencies: " + frequency);
    }
}
