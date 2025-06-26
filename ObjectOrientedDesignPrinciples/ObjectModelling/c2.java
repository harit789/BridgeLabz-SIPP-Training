class Customer {
    String name;
    double balance;

    public Customer(String name) {
        this.name = name;
        this.balance = 0.0;
    }

    public void viewBalance() {
        System.out.println(name + "'s Balance: $" + balance);
    }
}

class Bank {
    String name;

    public Bank(String name) {
        this.name = name;
    }

    public void openAccount(Customer customer, double initialDeposit) {
        customer.balance = initialDeposit;
        System.out.println("Account opened for " + customer.name + " with $" + initialDeposit);
    }
}
