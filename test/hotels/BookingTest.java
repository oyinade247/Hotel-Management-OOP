package hotels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    @Test
    void testThatBookingCanGetGuestDetails(){
        Hotel hotel = new Hotel();
        Guest guest = new Guest("oyin","09038150060","ade@gmail.com","password");
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);

        Booking booking = new Booking(guest, room);
        hotel.addBookings(booking);
        assertEquals(guest,booking.getGuestDetails());
    }
    @Test
    void testThatBookingCanSetGuestDetails(){
        Hotel hotel = new Hotel();
        Guest guest = new Guest("oyin","09038150060","ade@gmail.com","password");
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        Booking booking = new Booking(guest, room);
        hotel.addBookings(booking);
        booking.setGuestDetails(guest);
        assertEquals(guest,booking.getGuestDetails());

    }

//    @Test
//    void testThat

}