package com.ronron.catcafe.entities;

public class Booking {
    private Long id;
    private Client client;
    private String date;
    private String time;
    private int guestCount;

    public Booking(Long id, Client client, String date, String time, int guestCount) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.time = time;
        this.guestCount = guestCount;
    }

    public Long getId() { return id; }
    public Client getClient() { return client; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public int getGuestCount() { return guestCount; }
}