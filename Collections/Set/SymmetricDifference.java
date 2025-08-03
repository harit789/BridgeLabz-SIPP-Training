import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);

        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);

        Set<T> result = new HashSet<>(unionSet);
        result.removeAll(intersectionSet);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("--- Symmetric Difference ---");

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        Set<Integer> symDiff = symmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + symDiff);
    }
}
