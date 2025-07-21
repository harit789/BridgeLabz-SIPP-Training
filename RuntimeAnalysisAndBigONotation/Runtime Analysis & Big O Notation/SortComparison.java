import java.util.Arrays;
import java.util.Random;

public class SortComparison {

    // Generate random data
    public static int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int size = 10_000; // Try with 1000, 10_000, or 1_000_000
        int[] original = generateArray(size);

        // Bubble Sort
        int[] bubbleData = Arrays.copyOf(original, original.length);
        long startBubble = System.nanoTime();
        bubbleSort(bubbleData);
        long endBubble = System.nanoTime();

        // Merge Sort
        int[] mergeData = Arrays.copyOf(original, original.length);
        long startMerge = System.nanoTime();
        mergeSort(mergeData, 0, mergeData.length - 1);
        long endMerge = System.nanoTime();

        // Quick Sort
        int[] quickData = Arrays.copyOf(original, original.length);
        long startQuick = System.nanoTime();
        quickSort(quickData, 0, quickData.length - 1);
        long endQuick = System.nanoTime();

        // Results
        System.out.println("Dataset size: " + size);
        System.out.println("Bubble Sort time: " + (endBubble - startBubble) / 1_000_000.0 + " ms");
        System.out.println("Merge Sort time: " + (endMerge - startMerge) / 1_000_000.0 + " ms");
        System.out.println("Quick Sort time: " + (endQuick - startQuick) / 1_000_000.0 + " ms");
    }
}
