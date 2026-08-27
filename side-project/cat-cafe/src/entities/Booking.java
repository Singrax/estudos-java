package entities;

public class Booking {

    private Client client;
    private String date, time;
    private int guestCount;
    private int id;

    public Booking(Client client, String date, String time, int guestCount, int id) {
        this.client = client;
        this.date = date;
        this.time = time;
        this.guestCount = guestCount;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    @Override
    public String toString() {
        return "--- BOOKING DETAILS ---\n" +
                "#" + id + "\n" +
                "Date: " + date + " | Time: " + time + " | Guests: " + guestCount + "\n" +
                "Client Info: " + client + "\n" +
                "-----------------------";
    }
}
