package UseOfKeywords;

public class BankAccount {
    // Static variable
    static String bankName = "Bank of Java"; // Static variable shared by all instances
    private static int totalAccounts = 0;

    // Instance variables
    private final String accountNumber; // final variable
    private String accountHolderName;
    private double balance;

    // Constructor using 'this' keyword
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;             // 'this' resolves ambiguity
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;  // Increments whenever a new account is created
    }

    // Static method to get total accounts
    public static void getTotalAccounts() {
        System.out.println("Total Bank Accounts: " + totalAccounts);
    }

    // Method to display account details
    public void displayAccountDetails() {
        if (this instanceof BankAccount) {  // instanceof check
            System.out.println("\n--- Account Details ---");
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Invalid object type!");
        }
    }

    // Main method to test the program
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("SBJ1001", "Sumit Kumar", 5000000.00);
        BankAccount acc2 = new BankAccount("SBJ1002", "Khushi Sharma", 3000000.00);

        acc1.displayAccountDetails();
        acc2.displayAccountDetails();

        // Show total number of accounts
        BankAccount.getTotalAccounts();
    }
}
