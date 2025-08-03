import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetToSortedList {

    public static <T extends Comparable<T>> List<T> convertSetToSortedList(Set<T> set) {
        List<T> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println("--- Convert a Set to a Sorted List ---");

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(9);
        hashSet.add(1);
        hashSet.add(5); // Duplicate, will be ignored by HashSet

        System.out.println("Input HashSet: " + hashSet);

        List<Integer> sortedList = convertSetToSortedList(hashSet);
        System.out.println("Output Sorted List: " + sortedList);
    }
}
