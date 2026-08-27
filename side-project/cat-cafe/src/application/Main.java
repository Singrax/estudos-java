package application;

import entities.Booking;
import entities.Cat;
import entities.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int response;
        boolean menuContinue = true;


        List<Cat> residentCats = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();
        List<String> availableTimes = new ArrayList<>();

        loadBookings(bookings);

        //banco de dados fake temp
        residentCats.add(new Cat("Frajola", "Ama dormir no sol e odeia carinho na barriga.", 4));
        residentCats.add(new Cat("Luna", "A mais agitada da casa, caça qualquer laser.", 2));
        residentCats.add(new Cat("Garfield", "Só acorda para comer sachê.", 6));

        availableTimes.add("18:00-18:30");
        availableTimes.add("18:30-19:00");
        availableTimes.add("19:30-20:30");
        availableTimes.add("20:30-21:00");
        availableTimes.add("21:00-21:30");

        while (menuContinue) {
            System.out.println("=====================================");
            System.out.println("  Welcome to Ronron Cat Café System  ");
            System.out.println("=====================================\n");
            System.out.println("O que você deseja fazer?");
            System.out.println("1 - Conhecer Gatinhos");
            System.out.println("2 - Reservar horário de visita");
            System.out.println("3 - Cancelar visita");
            System.out.println("4 - Sair do Sistema");
            response = sc.nextInt();
            sc.nextLine();

            if (response == 1) {
                for (Cat cat : residentCats) {
                    System.out.println(cat);
                }
                String menuAction = "x";
                while (menuAction.charAt(0) != 'n' && menuAction.charAt(0) != 's') {
                    System.out.println("Deseja voltar ao menu? (s/n)");
                    menuAction = sc.next();
                    sc.nextLine();
                    if (menuAction.charAt(0) == 's') {
                        menuContinue = true;
                    } else if (menuAction.charAt(0) == 'n') {
                        menuContinue = false;
                    }
                }

            } else if (response == 2) {

                System.out.println("\n--- Bookings de Hoje---");
                for (Booking b : bookings) {
                    System.out.println(b);
                }
                if (bookings.isEmpty()) {
                    System.out.println("Sem Bookings hoje!");
                }

                System.out.println("Escolha um dia (00/00)");
                String date = sc.next();
                sc.nextLine();
                System.out.println("Horários disponíveis:");
                for (String availableTime : availableTimes) {
                    System.out.println(availableTime);
                }
                String timeChoice;
                do {
                    System.out.println("Escolha um horário válido:");
                    timeChoice = sc.nextLine();
                } while (!availableTimes.contains(timeChoice));
                System.out.println("Digite seu nome: ");
                String name = sc.nextLine();
                System.out.println("Digite seu email: ");
                String email = sc.nextLine();
                System.out.println("Digite seu telefone: ");
                String number = sc.nextLine();
                Client client = new Client(name, email, number);
                System.out.println("Quantas pessoas?");
                int guestCounts = sc.nextInt();
                int currentGuests = getSessionGuests(bookings, date, timeChoice);
                if (currentGuests + guestCounts <= 10) {
                    Random rng = new Random();
                    int generatedId;
                    do {
                        generatedId = rng.nextInt(999) + 1;
                    } while (isIdTaken(bookings, generatedId));
                    bookings.add(new Booking(client, date, timeChoice, guestCounts, generatedId));
                    System.out.println(bookings.getLast());
                    System.out.println("Reserva confirmada com sucesso!");
                } else {
                    int availableSpots = 10 - currentGuests;
                    System.out.println("Desculpe, esse horário só tem " + availableSpots + " vagas sobrando.");
                }
            } else if (response == 3) {
                System.out.println("Qual o id da reserva?");
                int reservationId = sc.nextInt();
                sc.nextLine();
                Booking bookingToRemove = null;

                for (Booking b : bookings) {
                    if (b.getId() == reservationId) {
                        bookingToRemove = b;
                        break;
                    }

                }

                if (bookingToRemove != null) {
                    bookings.remove(bookingToRemove);
                    System.out.println("Reserva #" + reservationId + " cancelada com sucesso!");
                } else {
                    System.out.println("Erro: ID não encontrado no sistema.");
                }
            }
            else if (response == 4) {
                System.out.println("Salvando dados e encerrando...");
                saveBookings(bookings);
                menuContinue = false;
            }
        }
        sc.close();
    }

    public static int getSessionGuests(List<Booking> bookings, String date, String time) {
        int totalGuests = 0;

        for (Booking b : bookings) {
            // Se a data E o horário forem iguais, somamos a quantidade de pessoas
            if (b.getDate().equals(date) && b.getTime().equals(time)) {
                totalGuests += b.getGuestCount();
            }
        }

        return totalGuests;
    }
    public static boolean isIdTaken(List<Booking> bookings, int id) {
        for (Booking b : bookings) {
            if (b.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public static void saveBookings(List<Booking> bookings) {

        String path = "bookings.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            for (Booking b : bookings) {

                String line = b.getId() + "," +
                        b.getClient().getName() + "," +
                        b.getClient().getEmail() + "," +
                        b.getClient().getPhone() + "," +
                        b.getDate() + "," +
                        b.getTime() + "," +
                        b.getGuestCount();

                bw.write(line);
                bw.newLine();
            }
            System.out.println("Dados salvos com sucesso no arquivo: " + path);

        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public static void loadBookings(List<Booking> bookings) {
        String path = "bookings.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {

                String[] fields = line.split(",");

                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String email = fields[2];
                String phone = fields[3];
                String date = fields[4];
                String time = fields[5];
                int guestCount = Integer.parseInt(fields[6]);

                Client client = new Client(name, email, phone);
                Booking booking = new Booking(client, date, time, guestCount, id);

                bookings.add(booking);

                line = br.readLine();
            }
            System.out.println("Histórico de reservas carregado com sucesso\n");

        } catch (Exception e) {
            System.out.println("Aviso: Nenhum histórico encontrado. Iniciando sistema zerado.\n");
        }
    }

}