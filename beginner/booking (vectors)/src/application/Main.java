package application;

import entities.Rent;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int totalRooms;
        Rent rentedRoom[] = new Rent[10];

        System.out.printf("How many rooms will be rented?");
        totalRooms =  sc.nextInt();
        sc.nextLine();


        for (int i = 0; i < totalRooms; i++) {
            System.out.println("Rent #" + (i + 1));
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("Email: ");
            String email = sc.nextLine();
            System.out.println("Room: ");
            int room = sc.nextInt();
            sc.nextLine();
            rentedRoom[room]  = new Rent(name, email, room);
        }

        System.out.println();
        System.out.println("Busy rooms:");
        for (int i = 0; i < 10; i++) {
            if (rentedRoom[i] != null) {
                System.out.println(rentedRoom[i]);
            }
        }
        sc.close();

    }

}
