// Binary Search - Find Peak Element
public class BinarySearch_PeakElement {
    public static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        return arr[left];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 20, 4, 1, 0};
        System.out.println("Peak element: " + findPeak(nums));
    }
}