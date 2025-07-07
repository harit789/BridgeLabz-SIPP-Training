package EncapsulationAndPlymorphism;

import java.util.*;

// Interface: Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract class: BankAccount
abstract class BankAccount implements Loanable {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(holderName + " withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.printf("Balance: ₹%.2f\n", balance);
        System.out.printf("Interest: ₹%.2f\n", calculateInterest());
        System.out.println("Loan Eligible: " + (calculateLoanEligibility() ? "Yes" : "No"));
        System.out.println("------------------------------------");
    }

    // Abstract Method
    public abstract double calculateInterest();

    // Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}

// SavingsAccount class
class SavingsAccount extends BankAccount {
    private final double interestRate = 0.04; // 4%

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Application: ₹" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount {
    private final double interestRate = 0.02; // 2%

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Application: ₹" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 20000;
    }
}

// Main class to demonstrate polymorphism
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        BankAccount acc1 = new SavingsAccount("SAV123", "Alice", 12000);
        BankAccount acc2 = new CurrentAccount("CUR456", "Bob", 25000);
        BankAccount acc3 = new SavingsAccount("SAV789", "Charlie", 8000);

        // Perform operations
        acc1.deposit(2000);
        acc2.withdraw(5000);
        acc3.deposit(1000);

        // Add to list
        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);

        // Polymorphic processing
        for (BankAccount acc : accounts) {
            acc.displayDetails();
            acc.applyForLoan(50000);  // Common interface method
        }
    }
}

