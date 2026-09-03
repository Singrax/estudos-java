package com.ronron.catcafe.controllers;

import com.ronron.catcafe.entities.Booking;
import com.ronron.catcafe.entities.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bookings") // Define um prefixo padrão para as rotas de reserva
public class BookingController {

    private List<Booking> bookings = new ArrayList<>();

    // Construtor para popular uma reserva de teste assim que o servidor ligar
    public BookingController() {
        Client client = new Client("Victor", "victor@email.com", "11999999999");
        bookings.add(new Booking(1L, client, "04/05/2025", "18:00-18:30", 2));
    }

    @PostMapping
    public String criarBooking(@RequestBody Booking novaReserva) {
        bookings.add(novaReserva);
        return "Reserva cadastrada com sucesso via web!";
    }

    @GetMapping
    public List<Booking> listarBookings() {
        return bookings; // O Spring converte essa lista em JSON automaticamente na web
    }
}