package hotels;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HotelTest {

    @Test
    void testThatHotelHasNoRoom(){
        Hotel hotel = new Hotel();
        assertTrue(hotel.getRoomIsEmpty());

    }
    @Test
    void testThatIfHotelHasOneRoomHotelRoomSizeIncreases(){
        Hotel hotel = new Hotel();
        Room room = new Room(1,RoomType.SINGLE,RoomStatus.ISAVAILIABLE);
        hotel.addRooms(RoomType.SINGLE,1);
        assertEquals(1, hotel.getHotelRoomSize());


    }

    @Test
    void testThatHotelCanAddRoom(){
        Hotel hotel = new Hotel();
        Room room = new Room(1,RoomType.SINGLE,RoomStatus.ISAVAILIABLE);
        hotel.addRooms(RoomType.SINGLE,1);
        assertEquals(1,hotel.getHotelRoomSize());

    }
    @Test
    void TestThatHotelCanAddbookings(){
        Hotel hotel = new Hotel();
        Room room = new Room(1,RoomType.SINGLE,RoomStatus.ISAVAILIABLE);
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        Booking booking = new Booking(guest,room);
        hotel.addBookings(booking);
        hotel.addRooms(RoomType.SINGLE,1);
        assertEquals(1,hotel.getNumberOfBookings());

    }
    @Test
    void TestThatHotelCanRemovebookings() {
        Hotel hotel = new Hotel();
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        Booking booking = new Booking(guest, room);
        hotel.removeBooking(booking);
        assertEquals(0, hotel.getNumberOfBookings());
    }

    @Test
    void testThatHotelCanAddGuest(){
        Hotel hotel = new Hotel();
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        Booking booking = new Booking(guest, room);
        hotel.addGuest(guest);
        assertEquals(1, hotel.getNumberOfGuest());

    }
    @Test
    void testThatHotelCanGetGuests(){
        Hotel hotel = new Hotel();
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        hotel.getGuests();
        assertEquals("Oyin", guest.getName());

    }
    @Test
    void testThatHotelCanGetRooms(){
        Hotel hotel = new Hotel();
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        hotel.getRooms();
        assertEquals(1, room.getRoomNumber());
    }
    @Test
    void testThatHotelCanGetBookings(){
        Hotel hotel = new Hotel();
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        Booking booking = new Booking(guest,room);
        hotel.addBookings(booking);
        hotel.getBookings();
        assertTrue(hotel.getRecords().getBookings().contains(booking));
    }
//    @Test
//    void testThatHotelCanGetRecords(){
//
//    }

    @Test
    void testThatHotelCanGetNumberOfBooking(){
            Hotel hotel = new Hotel();
            Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
            Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
            Booking booking = new Booking(guest, room);
            hotel.addBookings(booking);
            assertEquals(1, hotel.getNumberOfBookings());

    }
}