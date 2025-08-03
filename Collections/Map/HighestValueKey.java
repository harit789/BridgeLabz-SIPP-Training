import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HighestValueKey {

    public static String findKeyWithHighestValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        System.out.println("--- Find the Key with the Highest Value ---");

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 10);
        map1.put("B", 20);
        map1.put("C", 15);
        System.out.println("Input: " + map1);
        System.out.println("Output: " + findKeyWithHighestValue(map1));

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("X", 100);
        map2.put("Y", 50);
        map2.put("Z", 120);
        map2.put("W", 120); // Test with duplicate max value
        System.out.println("\nInput: " + map2);
        System.out.println("Output: " + findKeyWithHighestValue(map2)); // Will return one of the keys with max value

        Map<String, Integer> emptyMap = new HashMap<>();
        System.out.println("\nInput: " + emptyMap);
        System.out.println("Output: " + findKeyWithHighestValue(emptyMap));
    }
}
