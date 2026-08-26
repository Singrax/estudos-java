package entities;

public class BankAccount {

    private final int accountNumber;
    private double balance;
    private String name;

    public int getAccountNumber() {
        return accountNumber;
    }


    private double getBalance() {
        return balance;
    }
    public void addBalance(double value) {
        this.balance += value;
    }
    public void removeBalance(double value) {
        this.balance -= (value + 5);
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BankAccount(int accountNumber, String name, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.name = name;
        addBalance(initialDeposit);
    }

    public BankAccount(int accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account %d, Holder: %s, Balance: $ %.2f".formatted(accountNumber, name, balance);
    }
}
