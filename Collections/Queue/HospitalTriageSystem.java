import java.util.PriorityQueue;
import java.util.Queue;

class Patient implements Comparable<Patient> {
    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return "Patient{" +
               "name='" + name + '\'' +
               ", severity=" + severity +
               '}';
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {
        System.out.println("--- Hospital Triage System ---");

        Queue<Patient> triageQueue = new PriorityQueue<>();

        System.out.println("Adding patients to triage queue:");
        triageQueue.add(new Patient("John", 3));
        System.out.println("  Added: John (Severity 3)");
        triageQueue.add(new Patient("Alice", 5));
        System.out.println("  Added: Alice (Severity 5)");
        triageQueue.add(new Patient("Bob", 2));
        System.out.println("  Added: Bob (Severity 2)");
        triageQueue.add(new Patient("Carol", 5));
        System.out.println("  Added: Carol (Severity 5)");


        System.out.println("\nTreating patients in order of priority:");
        while (!triageQueue.isEmpty()) {
            Patient treatedPatient = triageQueue.remove();
            System.out.println("  Treating: " + treatedPatient.getName() + " (Severity: " + treatedPatient.getSeverity() + ")");
        }
    }
}
