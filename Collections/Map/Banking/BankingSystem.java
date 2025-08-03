import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Represents a withdrawal request
class WithdrawalRequest {
    private String accountNumber;
    private double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "WithdrawalRequest{account='" + accountNumber + "', amount=$" + String.format("%.2f", amount) + "}";
    }
}

public class BankingSystem {
    // HashMap to store customer accounts (AccountNumber -> Balance) for quick lookups
    private Map<String, Double> accounts;

    // TreeMap to store customers sorted by balance (Balance -> List of Account Numbers)
    // This allows displaying accounts sorted by balance.
    private TreeMap<Double, List<String>> accountsSortedByBalance;

    // Queue to process withdrawal requests in FIFO order
    private Queue<WithdrawalRequest> withdrawalQueue;

    public BankingSystem() {
        this.accounts = new HashMap<>();
        this.accountsSortedByBalance = new TreeMap<>();
        this.withdrawalQueue = new LinkedList<>();
    }

    /**
     * Creates a new customer account with an initial balance.
     *
     * @param accountNumber The unique account number.
     * @param initialBalance The initial balance for the account.
     */
    public void createAccount(String accountNumber, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Error: Account number " + accountNumber + " already exists.");
            return;
        }
        if (initialBalance < 0) {
            System.out.println("Error: Initial balance cannot be negative.");
            return;
        }

        accounts.put(accountNumber, initialBalance);
        // Add to sorted map. Handle existing balance if any, though new account implies unique balance for now.
        accountsSortedByBalance.computeIfAbsent(initialBalance, k -> new ArrayList<>()).add(accountNumber);
        System.out.println("Account " + accountNumber + " created with initial balance $" + String.format("%.2f", initialBalance));
    }

    /**
     * Deposits money into a specified account.
     *
     * @param accountNumber The account number to deposit into.
     * @param amount The amount to deposit.
     */
    public void deposit(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Error: Account " + accountNumber + " not found.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be positive.");
            return;
        }

        double oldBalance = accounts.get(accountNumber);
        double newBalance = oldBalance + amount;
        accounts.put(accountNumber, newBalance);

        // Update TreeMap: remove from old balance list, add to new balance list
        accountsSortedByBalance.get(oldBalance).remove(accountNumber);
        if (accountsSortedByBalance.get(oldBalance).isEmpty()) {
            accountsSortedByBalance.remove(oldBalance);
        }
        accountsSortedByBalance.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);

        System.out.println("Deposited $" + String.format("%.2f", amount) + " into account " + accountNumber + ". New balance: $" + String.format("%.2f", newBalance));
    }

    /**
     * Requests a withdrawal from a specified account by adding it to a queue.
     * Actual processing happens when `processWithdrawalRequests` is called.
     *
     * @param accountNumber The account number to withdraw from.
     * @param amount The amount to withdraw.
     */
    public void requestWithdrawal(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Error: Withdrawal request for non-existent account " + accountNumber + ".");
            return;
        }
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return;
        }
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Withdrawal request for $" + String.format("%.2f", amount) + " from account " + accountNumber + " added to queue.");
    }

    /**
     * Processes all pending withdrawal requests in the queue.
     */
    public void processWithdrawalRequests() {
        System.out.println("\n--- Processing Withdrawal Requests ---");
        if (withdrawalQueue.isEmpty()) {
            System.out.println("No pending withdrawal requests.");
            return;
        }

        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.remove();
            String accountNumber = request.getAccountNumber();
            double amount = request.getAmount();

            if (!accounts.containsKey(accountNumber)) {
                System.out.println("Failed: Account " + accountNumber + " not found during processing. Request: " + request);
                continue;
            }

            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                accounts.put(accountNumber, newBalance);

                // Update TreeMap: remove from old balance list, add to new balance list
                accountsSortedByBalance.get(currentBalance).remove(accountNumber);
                if (accountsSortedByBalance.get(currentBalance).isEmpty()) {
                    accountsSortedByBalance.remove(currentBalance);
                }
                accountsSortedByBalance.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);

                System.out.println("Processed: Withdrew $" + String.format("%.2f", amount) + " from account " + accountNumber + ". New balance: $" + String.format("%.2f", newBalance));
            } else {
                System.out.println("Failed: Insufficient funds in account " + accountNumber + " for withdrawal of $" + String.format("%.2f", amount) + ". Current balance: $" + String.format("%.2f", currentBalance));
            }
        }
    }

    /**
     * Retrieves the current balance for a given account number.
     *
     * @param accountNumber The account number.
     * @return The balance, or -1.0 if the account is not found.
     */
    public double getBalance(String accountNumber) {
        return accounts.getOrDefault(accountNumber, -1.0);
    }

    /**
     * Displays all customer accounts and their balances (from HashMap).
     */
    public void displayAccountsByAccountNumber() {
        System.out.println("\n--- All Accounts (by Account Number) ---");
        if (accounts.isEmpty()) {
            System.out.println("No accounts registered.");
            return;
        }
        accounts.forEach((accNum, balance) -> System.out.println("Account " + accNum + ": $" + String.format("%.2f", balance)));
    }

    /**
     * Displays all customer accounts sorted by their balance (using TreeMap).
     */
    public void displayAccountsSortedByBalance() {
        System.out.println("\n--- All Accounts (Sorted by Balance) ---");
        if (accountsSortedByBalance.isEmpty()) {
            System.out.println("No accounts registered.");
            return;
        }
        accountsSortedByBalance.forEach((balance, accountNumbers) -> {
            accountNumbers.forEach(accNum -> System.out.println("Account " + accNum + ": $" + String.format("%.2f", balance)));
        });
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        System.out.println("--- Creating Accounts ---");
        bank.createAccount("ACC001", 1000.00);
        bank.createAccount("ACC002", 500.00);
        bank.createAccount("ACC003", 1500.00);
        bank.createAccount("ACC004", 500.00); // Same balance as ACC002

        bank.displayAccountsByAccountNumber();
        bank.displayAccountsSortedByBalance();

        System.out.println("\n--- Deposits ---");
        bank.deposit("ACC001", 200.00);
        bank.deposit("ACC003", 50.00);
        bank.deposit("ACC005", 100.00); // Non-existent account

        bank.displayAccountsSortedByBalance(); // Check sorting after deposits

        System.out.println("\n--- Withdrawal Requests ---");
        bank.requestWithdrawal("ACC002", 100.00);
        bank.requestWithdrawal("ACC001", 1500.00); // Will fail (insufficient funds)
        bank.requestWithdrawal("ACC003", 200.00);
        bank.requestWithdrawal("ACC002", 500.00); // Will fail (insufficient funds after first withdrawal)

        bank.processWithdrawalRequests();

        bank.displayAccountsByAccountNumber();
        bank.displayAccountsSortedByBalance();

        System.out.println("\n--- Checking Balances ---");
        System.out.println("Balance for ACC001: $" + String.format("%.2f", bank.getBalance("ACC001")));
        System.out.println("Balance for ACC002: $" + String.format("%.2f", bank.getBalance("ACC002")));
        System.out.println("Balance for ACC003: $" + String.format("%.2f", bank.getBalance("ACC003")));
        System.out.println("Balance for ACC005 (non-existent): $" + String.format("%.2f", bank.getBalance("ACC005")));
    }
}
