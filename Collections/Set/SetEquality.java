import java.util.HashSet;
import java.util.Set;

public class SetEquality {

    public static boolean areSetsEqual(Set<?> set1, Set<?> set2) {
        if (set1 == null && set2 == null) {
            return true;
        }
        if (set1 == null || set2 == null) {
            return false;
        }
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        System.out.println("--- Check if Two Sets Are Equal ---");

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        Set<Integer> set3 = new HashSet<>();
        set3.add(1);
        set3.add(2);
        set3.add(4);

        System.out.println("Set1: " + set1 + ", Set2: " + set2 + " -> Equal? " + areSetsEqual(set1, set2));
        System.out.println("Set1: " + set1 + ", Set3: " + set3 + " -> Equal? " + areSetsEqual(set1, set3));
        System.out.println("Set1: " + set1 + ", Set1: " + set1 + " -> Equal? " + areSetsEqual(set1, set1));
    }
}
