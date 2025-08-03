import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RotateList {

    public static <T> void rotateList(List<T> list, int positions) {
        if (list == null || list.isEmpty() || positions == 0) {
            return;
        }

        int n = list.size();
        int actualPositions = positions % n;
        if (actualPositions < 0) {
            actualPositions += n;
        }

        for (int i = 0; i < actualPositions; i++) {
            T firstElement = list.remove(0);
            list.add(firstElement);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- List Rotation ---");
        List<Integer> rotateListExample = new ArrayList<>();
        rotateListExample.add(10);
        rotateListExample.add(20);
        rotateListExample.add(30);
        rotateListExample.add(40);
        rotateListExample.add(50);
        System.out.println("Original List for Rotation: " + rotateListExample);
        rotateList(rotateListExample, 2);
        System.out.println("Rotated List (by 2): " + rotateListExample);

        List<Character> rotateLinkedListExample = new LinkedList<>();
        rotateLinkedListExample.add('a');
        rotateLinkedListExample.add('b');
        rotateLinkedListExample.add('c');
        rotateLinkedListExample.add('d');
        System.out.println("Original LinkedList for Rotation: " + rotateLinkedListExample);
        rotateList(rotateLinkedListExample, 1);
        System.out.println("Rotated LinkedList (by 1): " + rotateLinkedListExample);

        List<Integer> rotateNegativeExample = new ArrayList<>();
        rotateNegativeExample.add(1);
        rotateNegativeExample.add(2);
        rotateNegativeExample.add(3);
        rotateNegativeExample.add(4);
        rotateNegativeExample.add(5);
        System.out.println("Original List for Negative Rotation: " + rotateNegativeExample);
        rotateList(rotateNegativeExample, -2);
        System.out.println("Rotated List (by -2): " + rotateNegativeExample);
    }
}
