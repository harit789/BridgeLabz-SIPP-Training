import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManagementSystem_Map {

    // ======= Policy Class ========
    static class Policy {
        String policyNumber;
        String policyHolderName;
        LocalDate expiryDate;
        String coverageType;
        double premiumAmount;

        public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate,
                      String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyHolderName = policyHolderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        public String getPolicyHolderName() {
            return policyHolderName;
        }

        @Override
        public String toString() {
            return String.format("Policy[Number=%s, Name=%s, Expiry=%s, Type=%s, Premium=%.2f]",
                    policyNumber, policyHolderName, expiryDate, coverageType, premiumAmount);
        }
    }

    // ======= Policy Manager Class ========
    static class PolicyManager {
        Map<String, Policy> hashMap = new HashMap<>();
        Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
        TreeMap<LocalDate, List<Policy>> expiryMap = new TreeMap<>();

        public void addPolicy(Policy policy) {
            // Store in HashMap and LinkedHashMap
            hashMap.put(policy.getPolicyNumber(), policy);
            linkedHashMap.put(policy.getPolicyNumber(), policy);

            // Store in TreeMap by expiry date
            expiryMap.putIfAbsent(policy.getExpiryDate(), new ArrayList<>());
            expiryMap.get(policy.getExpiryDate()).add(policy);
        }

        public Policy getPolicyByNumber(String policyNumber) {
            return hashMap.get(policyNumber);
        }

        public void listPoliciesExpiringInNext30Days() {
            System.out.println("\n--- Policies Expiring Within 30 Days ---");
            LocalDate now = LocalDate.now();
            LocalDate limit = now.plusDays(30);

            expiryMap.subMap(now, true, limit, true)
                     .values()
                     .forEach(policies -> policies.forEach(System.out::println));
        }

        public void listPoliciesByPolicyholder(String name) {
            System.out.println("\n--- Policies for Policyholder: " + name + " ---");
            for (Policy p : hashMap.values()) {
                if (p.getPolicyHolderName().equalsIgnoreCase(name)) {
                    System.out.println(p);
                }
            }
        }

        public void removeExpiredPolicies() {
            System.out.println("\n--- Removing Expired Policies ---");
            LocalDate today = LocalDate.now();
            Iterator<Map.Entry<LocalDate, List<Policy>>> it = expiryMap.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<LocalDate, List<Policy>> entry = it.next();
                if (entry.getKey().isBefore(today)) {
                    for (Policy p : entry.getValue()) {
                        hashMap.remove(p.getPolicyNumber());
                        linkedHashMap.remove(p.getPolicyNumber());
                        System.out.println("Removed: " + p);
                    }
                    it.remove();
                }
            }
        }

        public void listAllPoliciesInInsertionOrder() {
            System.out.println("\n--- All Policies (Insertion Order) ---");
            for (Policy p : linkedHashMap.values()) {
                System.out.println(p);
            }
        }
    }

    // ======= Main Method ========
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        // Sample Data
        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 1000));
        manager.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(5), "Auto", 1200));
        manager.addPolicy(new Policy("P1003", "Alice", LocalDate.now().plusDays(40), "Home", 1500));
        manager.addPolicy(new Policy("P1004", "Charlie", LocalDate.now().minusDays(2), "Health", 1800)); // Expired

        // Demonstrate functionality
        manager.listAllPoliciesInInsertionOrder();

        System.out.println("\nRetrieved Policy P1002:");
        System.out.println(manager.getPolicyByNumber("P1002"));

        manager.listPoliciesExpiringInNext30Days();
        manager.listPoliciesByPolicyholder("Alice");

        manager.removeExpiredPolicies();
        manager.listAllPoliciesInInsertionOrder();
    }
}
