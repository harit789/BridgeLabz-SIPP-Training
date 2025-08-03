import java.util.LinkedList;

public class NthElementFromEnd {

    public static <T> T findNthElementFromEnd(LinkedList<T> linkedList, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be a positive integer.");
        }
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }

        int slowIndex = 0;
        int fastIndex = 0;

        for (int i = 0; i < n; i++) {
            if (fastIndex >= linkedList.size()) {
                return null;
            }
            fastIndex++;
        }

        while (fastIndex < linkedList.size()) {
            slowIndex++;
            fastIndex++;
        }

        return linkedList.get(slowIndex);
    }

    public static void main(String[] args) {
        System.out.println("--- Find Nth Element from End (LinkedList) ---");
        LinkedList<String> charLinkedList = new LinkedList<>();
        charLinkedList.add("A");
        charLinkedList.add("B");
        charLinkedList.add("C");
        charLinkedList.add("D");
        charLinkedList.add("E");
        System.out.println("LinkedList: " + charLinkedList);

        int n1 = 2;
        String nthElement1 = findNthElementFromEnd(charLinkedList, n1);
        System.out.println("N=" + n1 + " (from end): " + nthElement1);

        int n2 = 1;
        String nthElement2 = findNthElementFromEnd(charLinkedList, n2);
        System.out.println("N=" + n2 + " (from end): " + nthElement2);

        int n3 = 5;
        String nthElement3 = findNthElementFromEnd(charLinkedList, n3);
        System.out.println("N=" + n3 + " (from end): " + nthElement3);

        int n4 = 6;
        String nthElement4 = findNthElementFromEnd(charLinkedList, n4);
        System.out.println("N=" + n4 + " (from end): " + nthElement4);

        try {
            findNthElementFromEnd(charLinkedList, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error for N=0: " + e.getMessage());
        }
    }
}
