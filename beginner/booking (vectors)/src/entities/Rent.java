package entities;

public class Rent {

    private String name;
    private String email;
    private int roomNumber;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Rent(String name, String email, int roomNumber) {
        this.name = name;
        this.email = email;
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return roomNumber + ":  " + name + ", " + email;
    }

}
