import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class BinaryNumberGenerator {

    public static List<String> generateBinaryNumbers(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);

            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--- Generate Binary Numbers Using a Queue ---");

        int n1 = 5;
        System.out.println("First " + n1 + " binary numbers: " + generateBinaryNumbers(n1));

        int n2 = 10;
        System.out.println("First " + n2 + " binary numbers: " + generateBinaryNumbers(n2));
    }
}
