package hotels;

import java.util.ArrayList;

public class Admin  extends User{
    private Hotel hotel;
    private String password;
    public Admin(String name, String phoneNumber, String emailAddress,String password, Hotel hotel) {
        super(name, phoneNumber, emailAddress);
        this.hotel = hotel;
        this.password = password;

    }

    public ArrayList<Room> viewRoom() {
        return hotel.getRooms();


    }

    public void addRoom(RoomType type, int count) {
        hotel.addRooms(type, count);
    }

    public void addBooking(Booking booking) {
        hotel.addBookings(booking);
    }

    public void cancelBooking(Booking booking) {
        hotel.removeBooking(booking);
    }

    public void addGuest(Guest guest) {
        hotel.addGuest(guest);
    }


    public Booking manageGuestDetails(int roomNumber) {
        return hotel.getBookings().stream().
                filter(booking1 -> booking1.getRoomBooked().getRoomNumber() == roomNumber).
                    findFirst().orElse(null);
    }

    public void markRoomAsMaintance(Room room) {
        room.setStatus(RoomStatus.ISMAINTAINENCE);
    }


    public Guest loginGuest(String email, String password) {
       return hotel.loginGuest(email,password);


    }

    public String getPassword() {
        return password;
    }
}
