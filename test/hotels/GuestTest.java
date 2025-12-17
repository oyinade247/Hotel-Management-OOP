package hotels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    @Test
    void testThatGuestHasAName(){
         Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
         guest.setName("Oyin");
         assertEquals("Oyin", guest.getName());
    }

    @Test
    void testThatGuestHasAPhoneNumber(){
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        guest.setPhoneNumber("09038150060");
        assertEquals("09038150060", guest.getPhoneNumber());
    }
    @Test
    void testThatGuestEmailAddress(){
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        guest.setEmailAddress("ade@gmail.com");
        assertEquals("ade@gmail.com", guest.getEmailAddress());
    }

    @Test
    void testThatGuestCanBooKARoomIfRoomIsAvailiable(){
        Hotel hotel = new Hotel();
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        Booking booking = new Booking(guest, room);
        guest.bookRoom(hotel,room,booking);
        assertEquals( RoomStatus.ISOCCUPIED, room.getStatus());
        assertEquals(guest,booking.getGuestDetails());
    }

    @Test
    void testThatGuestCanCheckIfRoomIsAvailiable(){
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISAVAILIABLE);
        assertTrue(guest.checkRoomAvailiabity( room));

    }
    @Test
    void testThatGuestCanCanReservation(){
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        Room room = new Room(1, RoomType.SINGLE, RoomStatus.ISOCCUPIED);
        Booking booking = new Booking(guest, room);
        Hotel hotel = new Hotel();
        guest.bookRoom(hotel,room,booking);
        guest.cancelReservation(hotel, booking, room);
        assertEquals(RoomStatus.ISAVAILIABLE, room.getStatus());

    }
    @Test
    void testThatGuestCanEditProfile(){
        Guest guest = new Guest("Oyin", "09038150060", "ade@gmail.com", "1234");
        guest.editProfile("ade","ola@gmail.come","09036150060");
        assertEquals("ade", guest.getName());
        assertEquals("ola@gmail.come", guest.getEmailAddress());
        assertEquals("09036150060",guest.getPhoneNumber());

    }


}