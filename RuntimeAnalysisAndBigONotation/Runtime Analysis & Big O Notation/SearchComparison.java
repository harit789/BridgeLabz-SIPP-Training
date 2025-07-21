import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Generate an array with random integers
    public static int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10); // Keep range wider than size
        }
        return arr;
    }

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // Binary Search (Array must be sorted)
    public static int binarySearch(int[] arr, int target) {
        return Arrays.binarySearch(arr, target);
    }

    public static void main(String[] args) {
        int size = 1_000_000; // Try with 1000, 10000, 1000000
        int[] data = generateArray(size);
        int target = data[new Random().nextInt(size)]; // Pick a random target from the array

        // Measure Linear Search Time
        long startLinear = System.nanoTime();
        int resultLinear = linearSearch(data, target);
        long endLinear = System.nanoTime();

        // Sort array before Binary Search
        Arrays.sort(data);
        long startBinary = System.nanoTime();
        int resultBinary = binarySearch(data, target);
        long endBinary = System.nanoTime();

        // Output Results
        System.out.println("Dataset size: " + size);
        System.out.println("Target: " + target);
        System.out.println("Linear Search found at index: " + resultLinear + ", Time: " + (endLinear - startLinear) / 1_000_000.0 + " ms");
        System.out.println("Binary Search found at index: " + resultBinary + ", Time: " + (endBinary - startBinary) / 1_000_000.0 + " ms");
    }
}
