import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static <T> List<T> removeDuplicatesPreservingOrder(List<T> originalList) {
        Set<T> uniqueElements = new LinkedHashSet<>(originalList);
        return new ArrayList<>(uniqueElements);
    }

    public static void main(String[] args) {
        System.out.println("--- Remove Duplicates Preserving Order ---");
        List<Integer> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add(3);
        listWithDuplicates.add(1);
        listWithDuplicates.add(2);
        listWithDuplicates.add(2);
        listWithDuplicates.add(3);
        listWithDuplicates.add(4);
        System.out.println("Original List with Duplicates: " + listWithDuplicates);
        List<Integer> uniqueList = removeDuplicatesPreservingOrder(listWithDuplicates);
        System.out.println("List after removing duplicates: " + uniqueList);
    }
}
