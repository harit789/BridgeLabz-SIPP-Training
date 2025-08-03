import java.util.HashSet;
import java.util.Set;

public class FindSubsets {

    public static <T> boolean isSubset(Set<T> subsetCandidate, Set<T> superset) {
        if (subsetCandidate == null || superset == null) {
            return false;
        }
        return superset.containsAll(subsetCandidate);
    }

    public static void main(String[] args) {
        System.out.println("--- Find Subsets ---");

        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> set3 = new HashSet<>();
        set3.add(1);
        set3.add(5);

        System.out.println("Set1: " + set1 + ", Set2: " + set2 + " -> Is Set1 a subset of Set2? " + isSubset(set1, set2));
        System.out.println("Set2: " + set2 + ", Set1: " + set1 + " -> Is Set2 a subset of Set1? " + isSubset(set2, set1));
        System.out.println("Set1: " + set1 + ", Set3: " + set3 + " -> Is Set1 a subset of Set3? " + isSubset(set1, set3));
        System.out.println("Empty Set: " + new HashSet<>() + ", Set2: " + set2 + " -> Is Empty Set a subset of Set2? " + isSubset(new HashSet<>(), set2));
    }
}
