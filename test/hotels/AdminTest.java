package hotels;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void testThatAdminCanViewAllRooms(){
        Hotel hotel = new Hotel();
        Admin admin = new Admin("ade", "09038150060", "adin@gmail.com", "hhh", hotel);
        Room room = new Room(1, RoomType.SUITE, RoomStatus.ISAVAILIABLE);
        hotel.addRooms( RoomType.SUITE,1);
        Room lastRoomAdded = admin.viewRoom().get(admin.viewRoom().size() - 1);
        assertEquals( RoomType.SUITE, lastRoomAdded.getType());


    }
    @Test
    void testThatAdminCanAddRoom(){
        Hotel hotel = new Hotel();
        Admin admin = new Admin("ade", "09038150060", "adin@gmail.com","hhh",hotel);
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        Room lastRoomAdded = admin.viewRoom().get(admin.viewRoom().size() - 1);
        hotel.addRooms(RoomType.SINGLE,1);
        assertEquals(RoomType.SINGLE, room.getType());
    }
    @Test
    void testThatAdminCanAddReservation(){
        Hotel hotel = new Hotel();
        Admin admin = new Admin("ade", "09038150060", "adin@gmail.com","hhh", hotel);
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        Booking booking = new Booking(guest,room);
        admin.addBooking(booking);
        assertTrue(hotel.getRecords().getBookings().contains(booking));
    }

    @Test
    void testThatAdminCanCancelBookings(){
        Hotel hotel = new Hotel();
        Admin admin = new Admin("ade", "09038150060", "adin@gmail.com","hhh", hotel);
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        Booking booking = new Booking(guest,room);
        admin.cancelBooking(booking);
        assertFalse(hotel.getRecords().getBookings().contains(booking));

    }
    @Test
    void testThatAdminCanAddGuest(){
        Hotel hotel = new Hotel();
        Admin admin = new Admin("ade", "09038150060", "adin@gmail.com","hhh", hotel);
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        admin.addGuest(guest);
        assertTrue(hotel.getGuests().contains(guest));

    }

    @Test
    void testThatAdminCanManageGuestDetails(){
        Hotel hotel = new Hotel();
        Admin admin = new Admin("ade", "09038150060", "adin@gmail.com","hhh", hotel);
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        Booking booking = new Booking(guest,room);
        booking.setRoomBooked(room);
        admin.addBooking(booking);
        admin.manageGuestDetails(1);
        assertEquals(guest, booking.getGuestDetails());

    }

    @Test
    void testThatAdminCanMarkRoomAsMaintainance(){
        Hotel hotel = new Hotel();
        Admin admin = new Admin("ade", "09038150060", "adin@gmail.com","hhh", hotel);
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISMAINTAINENCE);
        hotel.addRooms(RoomType.SINGLE,1);
        admin.markRoomAsMaintance(room);
        assertEquals(RoomStatus.ISMAINTAINENCE,room.getStatus());
    }

//    @Test
//    void testThatAdminCanGenerateWeekLyReport(){}

}


