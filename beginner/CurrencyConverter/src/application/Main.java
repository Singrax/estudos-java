package application;

import util.CurrencyConverter;
import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main() {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        Locale.setDefault(Locale.US);

        double dollarPrice, amount, reaisPaid;

        System.out.println("What is the dollar price?");
        dollarPrice = sc.nextDouble();
        System.out.println("How many dollars will be bought?");
        amount = sc.nextDouble();
        reaisPaid = CurrencyConverter.priceCalc(dollarPrice, amount);

        System.out.printf("Amount to be paid in reais = %.2f%n", reaisPaid);
        sc.close();
    }
}
