package hotels;

import java.util.Date;

public class Guest extends User {
    private String password;

    public Guest(String name, String phoneNumber, String emailAddress,String password){
        super(name, phoneNumber, emailAddress);
        this.password = password;

    }

    public String getPassword(){
        return password;
    }

    public void bookRoom(Hotel hotel,Room room, Booking booking) {
        if(room.getStatus() == RoomStatus.ISAVAILIABLE){
            room.setStatus(RoomStatus.ISOCCUPIED);
            room.setCheckIn(new Date());
            booking.setRoomBooked(room);
            booking.setGuestDetails(this);
            hotel.addBookings(booking);
        }
    }

    public boolean checkRoomAvailiabity(Room room) {
        return room.getStatus() == RoomStatus.ISAVAILIABLE;
    }

    public void cancelReservation(Hotel  hotel,Booking booking,Room room) {
       if(booking.getGuestDetails() == this){
           hotel.removeBooking(booking);
           room.setStatus(RoomStatus.ISAVAILIABLE);

       }
    }

    public void editProfile(String name, String email, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmailAddress(email);
    }
}
