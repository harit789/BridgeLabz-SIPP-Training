import java.util.*;

public class DataStructureSearch {

    public static void benchmarkSearch(int size, int target) {
        System.out.println("\nDataset Size: " + size);

        // Generate sample data
        List<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            hashSet.add(i);
            treeSet.add(i);
        }

        // Array Search
        long startArray = System.nanoTime();
        boolean foundInArray = false;
        for (int num : arrayList) {
            if (num == target) {
                foundInArray = true;
                break;
            }
        }
        long endArray = System.nanoTime();
        System.out.println("Array Search: Found=" + foundInArray + " | Time: " + (endArray - startArray) / 1_000_000.0 + " ms");

        // HashSet Search
        long startHash = System.nanoTime();
        boolean foundInHash = hashSet.contains(target);
        long endHash = System.nanoTime();
        System.out.println("HashSet Search: Found=" + foundInHash + " | Time: " + (endHash - startHash) / 1_000_000.0 + " ms");

        // TreeSet Search
        long startTree = System.nanoTime();
        boolean foundInTree = treeSet.contains(target);
        long endTree = System.nanoTime();
        System.out.println("TreeSet Search: Found=" + foundInTree + " | Time: " + (endTree - startTree) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {
        benchmarkSearch(1_000, 999);
        benchmarkSearch(100_000, 99_999);
        benchmarkSearch(1_000_000, 999_999);
    }
}
