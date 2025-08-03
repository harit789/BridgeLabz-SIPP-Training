import java.util.HashMap;
import java.util.Map;

public class MergeMaps {

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return mergedMap;
    }

    public static void main(String[] args) {
        System.out.println("--- Merge Two Maps ---");

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        System.out.println("Map1: " + map1);
        System.out.println("Map2: " + map2);
        System.out.println("Merged Map: " + mergeMaps(map1, map2));

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("X", 10);
        map3.put("Y", 20);

        Map<String, Integer> map4 = new HashMap<>();
        map4.put("Y", 5);
        map4.put("Z", 15);
        map4.put("X", 30);

        System.out.println("\nMap3: " + map3);
        System.out.println("Map4: " + map4);
        System.out.println("Merged Map: " + mergeMaps(map3, map4));

        Map<String, Integer> emptyMap1 = new HashMap<>();
        Map<String, Integer> emptyMap2 = new HashMap<>();
        emptyMap2.put("Data", 100);
        System.out.println("\nMap (empty): " + emptyMap1);
        System.out.println("Map (with data): " + emptyMap2);
        System.out.println("Merged Map: " + mergeMaps(emptyMap1, emptyMap2));
    }
}
