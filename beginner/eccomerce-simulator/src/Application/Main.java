package Application;

import Entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());
        Client client = new Client(name, email, birthDate);
        Order order = new Order(client, new Date(), OrderStatus.PROCESSING);
        System.out.println("Enter order data:");
        System.out.println("Status: " + order.getStatus());
        System.out.println("How many items to this order?");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.println("Product name: ");
            String productName = sc.nextLine();
            System.out.println("Product price: ");
            double price = sc.nextDouble();
            System.out.println("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            Product product = new Product(productName, price);
            OrderItem orderItem = new OrderItem(product, quantity);
            order.addItem(orderItem);
        }

        System.out.println(order);

        sc.close();

    }
}
