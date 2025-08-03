import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertMap {

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();
        if (originalMap == null || originalMap.isEmpty()) {
            return invertedMap;
        }

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        return invertedMap;
    }

    public static void main(String[] args) {
        System.out.println("--- Invert a Map ---");

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 1);
        System.out.println("Input: " + map1);
        System.out.println("Output: " + invertMap(map1));

        Map<String, String> map2 = new HashMap<>();
        map2.put("Red", "Color");
        map2.put("Blue", "Color");
        map2.put("Apple", "Fruit");
        System.out.println("\nInput: " + map2);
        System.out.println("Output: " + invertMap(map2));

        Map<Integer, String> map3 = new HashMap<>();
        map3.put(10, "X");
        map3.put(20, "Y");
        map3.put(30, "X");
        map3.put(40, "Z");
        System.out.println("\nInput: " + map3);
        System.out.println("Output: " + invertMap(map3));
    }
}
