package hotels;

import java.util.ArrayList;

public class Record {
    ArrayList<Booking> bookings;

    public Record() {
        bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }
    public void removeBooking(Booking booking){
        this.bookings.remove(booking);
    }
    public int getNumberOfBookings(){
        return bookings.size();
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }
}
