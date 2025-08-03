import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class VotingSystem {
    private Map<String, Integer> hashMapVotes;
    private Map<String, Integer> linkedHashMapVotes;
    private TreeMap<String, Integer> treeMapVotes;

    public VotingSystem() {
        this.hashMapVotes = new HashMap<>();
        this.linkedHashMapVotes = new LinkedHashMap<>();
        this.treeMapVotes = new TreeMap<>();
    }

    public void castVote(String candidateName) {
        // Update HashMap
        hashMapVotes.put(candidateName, hashMapVotes.getOrDefault(candidateName, 0) + 1);

        // Update LinkedHashMap (maintains insertion order of candidates)
        linkedHashMapVotes.put(candidateName, linkedHashMapVotes.getOrDefault(candidateName, 0) + 1);

        // Update TreeMap (maintains sorted order of candidate names)
        treeMapVotes.put(candidateName, treeMapVotes.getOrDefault(candidateName, 0) + 1);
    }

    public int getVotes(String candidateName) {
        return hashMapVotes.getOrDefault(candidateName, 0);
    }

    public void displayResultsHashMap() {
        System.out.println("\n--- Current Votes (HashMap - No guaranteed order) ---");
        if (hashMapVotes.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }
        hashMapVotes.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes + " votes"));
    }

    public void displayResultsLinkedHashMap() {
        System.out.println("\n--- Current Votes (LinkedHashMap - Insertion order) ---");
        if (linkedHashMapVotes.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }
        linkedHashMapVotes.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes + " votes"));
    }

    public void displayResultsTreeMap() {
        System.out.println("\n--- Current Votes (TreeMap - Sorted by Candidate Name) ---");
        if (treeMapVotes.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }
        treeMapVotes.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes + " votes"));
    }

    public List<String> getWinner() {
        if (hashMapVotes.isEmpty()) {
            return Collections.emptyList();
        }

        int maxVotes = Collections.max(hashMapVotes.values());
        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : hashMapVotes.entrySet()) {
            if (entry.getValue() == maxVotes) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        System.out.println("--- Casting Votes ---");
        system.castVote("Alice");
        System.out.println("Voted for Alice.");
        system.castVote("Bob");
        System.out.println("Voted for Bob.");
        system.castVote("Alice");
        System.out.println("Voted for Alice.");
        system.castVote("Charlie");
        System.out.println("Voted for Charlie.");
        system.castVote("Bob");
        System.out.println("Voted for Bob.");
        system.castVote("Alice");
        System.out.println("Voted for Alice.");
        system.castVote("David");
        System.out.println("Voted for David.");

        System.out.println("\n--- Displaying Results ---");
        system.displayResultsHashMap();
        system.displayResultsLinkedHashMap();
        system.displayResultsTreeMap();

        System.out.println("\n--- Getting Vote Count for Specific Candidates ---");
        System.out.println("Votes for Alice: " + system.getVotes("Alice"));
        System.out.println("Votes for Bob: " + system.getVotes("Bob"));
        System.out.println("Votes for Charlie: " + system.getVotes("Charlie"));
        System.out.println("Votes for NonExistent: " + system.getVotes("NonExistent"));

        List<String> winners = system.getWinner();
        if (winners.isEmpty()) {
            System.out.println("\nNo winner determined (no votes cast).");
        } else if (winners.size() == 1) {
            System.out.println("\nWinner: " + winners.get(0) + " with " + system.getVotes(winners.get(0)) + " votes.");
        } else {
            System.out.println("\nIt's a tie! Winners: " + String.join(", ", winners) + " with " + system.getVotes(winners.get(0)) + " votes each.");
        }

        System.out.println("\n--- Adding more votes for tie-breaking ---");
        system.castVote("Bob");
        System.out.println("Voted for Bob.");

        List<String> newWinners = system.getWinner();
        if (newWinners.isEmpty()) {
             System.out.println("\nNo winner determined (no votes cast).");
        } else if (newWinners.size() == 1) {
            System.out.println("\nNew Winner: " + newWinners.get(0) + " with " + system.getVotes(newWinners.get(0)) + " votes.");
        } else {
            System.out.println("\nIt's still a tie! New Winners: " + String.join(", ", newWinners) + " with " + system.getVotes(newWinners.get(0)) + " votes each.");
        }

        System.out.println("\n--- Final Results (TreeMap) ---");
        system.displayResultsTreeMap();
    }
}
