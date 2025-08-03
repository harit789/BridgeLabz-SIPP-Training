import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    public static <T> List<T> reverseList(List<T> originalList) {
        List<T> reversedList = new ArrayList<>();
        for (int i = originalList.size() - 1; i >= 0; i--) {
            reversedList.add(originalList.get(i));
        }
        return reversedList;
    }

    public static void main(String[] args) {
        System.out.println("--- List Reversal ---");
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println("Original ArrayList: " + arrayList);
        List<Integer> reversedArrayList = reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + reversedArrayList);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        System.out.println("Original LinkedList: " + linkedList);
        List<String> reversedLinkedList = reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
    }
}
