package application;

import entities.BankAccount;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        Locale.setDefault(Locale.US);

        String name;
        int accountNumber;
        BankAccount account;

        System.out.println("Enter Account Number:");
        accountNumber = sc.nextInt();
        System.out.println("Enter Account Holder:");
        name = sc.nextLine();
        System.out.println("Is there an initial deposit (y/n)?");
        char response = sc.next().charAt(0);
        if (response == 'y') {
            System.out.println("Enter initial deposit value:");
            double initialDeposit = sc.nextDouble();
            account = new BankAccount(accountNumber, name, initialDeposit);
        } else {
            account = new BankAccount(accountNumber, name);
        }

        System.out.println();
        System.out.println("Account data:");
        System.out.println(account);

        System.out.println();
        System.out.println("Enter a deposit value:");
        double deposit = sc.nextDouble();
        account.addBalance(deposit);
        System.out.println("Updated account data:");
        System.out.println(account);

        System.out.println();
        System.out.println("Enter a withdraw value:");
        double withdraw = sc.nextDouble();
        account.removeBalance(withdraw);
        System.out.println("Updated account data:");
        System.out.println(account);

        sc.close();

    }
}