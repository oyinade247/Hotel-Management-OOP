package hotels;

import java.util.Date;

public class Booking {
    private Guest guestDetails;
    private Date date;
    private double amount;
    private Room roomBooked;


    public Booking() {}


    public Booking(Guest guestDetails, Room roomBooked) {
        this.guestDetails = guestDetails;
        this.date = new Date();
        this.amount = amount;
        this.roomBooked = roomBooked;
    }


    public Guest getGuestDetails() {
        return guestDetails;
    }

    public void setGuestDetails(Guest guestDetails) {
        this.guestDetails = guestDetails;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Room getRoomBooked() {
        return roomBooked;
    }

    public void setRoomBooked(Room roomBooked) {
        this.roomBooked = roomBooked;
    }
}
