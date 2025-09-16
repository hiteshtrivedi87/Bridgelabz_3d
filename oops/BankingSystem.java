// BankingSystem.java

import java.util.ArrayList;
import java.util.List;

// Interface
interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation - Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String num) {
        this.accountNumber = num;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String name) {
        this.holderName = name;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double b) {
        this.balance = b;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited: ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew: ₹" + amount);
        } else {
            System.out.println("Insufficient funds for " + holderName);
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: ₹" + balance);
    }
}

// Subclass: Savings Account
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; // 4% annual

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public boolean applyForLoan(double amount) {
        double eligibility = calculateLoanEligibility();
        return amount <= eligibility;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 2; // Loan eligibility: 2x balance
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Savings");
        System.out.println("Interest (4%): ₹" + calculateInterest());
        System.out.println("Loan Eligibility: ₹" + calculateLoanEligibility());
        System.out.println("-----------------------------");
    }
}

// Subclass: Current Account
class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02; // 2% annual

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public boolean applyForLoan(double amount) {
        double eligibility = calculateLoanEligibility();
        return amount <= eligibility;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance(); // 1x balance
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Current");
        System.out.println("Interest (2%): ₹" + calculateInterest());
        System.out.println("Loan Eligibility: ₹" + calculateLoanEligibility());
        System.out.println("-----------------------------");
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        BankAccount acc1 = new SavingsAccount("SAV123", "Alice", 50000);
        BankAccount acc2 = new CurrentAccount("CUR456", "Bob", 100000);

        acc1.deposit(5000);
        acc2.withdraw(10000);

        accounts.add(acc1);
        accounts.add(acc2);

        for (BankAccount account : accounts) {
            // Polymorphic behavior
            account.displayDetails();
        }

        // Loan application examples
        System.out.println("Loan Check:");
        for (BankAccount account : accounts) {
            if (account instanceof Loanable) {
                Loanable l = (Loanable) account;
                double requestAmount = 60000;
                boolean approved = l.applyForLoan(requestAmount);
                System.out.println(account.getHolderName() + " loan of ₹" + requestAmount + ": " + (approved ? "Approved" : "Denied"));
            }
        }
    }
}
