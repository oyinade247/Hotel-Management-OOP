package hotels;

import java.util.ArrayList;

public class Hotel {
    ArrayList<Guest>guests;
    ArrayList<Room>rooms;
    private Record records;

    public Hotel() {
        records = new Record();
        rooms = new ArrayList<>();
        guests = new ArrayList<>();
        createRoom();
    }

    public boolean getRoomIsEmpty() {
        return true;
    }
    public int getHotelRoomSize() {
        return rooms.size();
    }
    public int getNumberOfGuest(){
        return guests.size();
    }


    public void addRooms(RoomType type, int count) {
        int startRoomNumber = rooms.size() + 1;
        int endRoomNumber = startRoomNumber + count - 1;

        for (int roomNumber = startRoomNumber; roomNumber <= endRoomNumber; roomNumber++) {
            rooms.add(new Room(roomNumber, type, RoomStatus.ISAVAILIABLE));
        }
    }

    public void addBookings(Booking booking) {
        records.addBooking(booking);
    }
    public void removeBooking(Booking booking){
        records.removeBooking(booking);
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public ArrayList<Guest> getGuests(){
        return guests;

    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }


    public ArrayList<Booking> getBookings() {
        return records.getBookings();
    }
    public Record getRecords(){
        return records;
    }
    public int getNumberOfBookings(){
        return records.getNumberOfBookings();

    }

    public Guest loginGuest(String email, String password) {
        for(Guest guest: guests){
            if(guest.getPassword().equals(password) && guest.getEmailAddress().equals(email)){
                return guest;
            }
        }
        return null;

    }

    public Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }


    private void createRoom(){
        for(int count = 1; count <= 3; count++){
            rooms.add(new Room(count,RoomType.SINGLE,RoomStatus.ISAVAILIABLE));
        }
        for(int count = 4; count <=6; count++){
            rooms.add(new Room(count,RoomType.DOUBLE,RoomStatus.ISAVAILIABLE));
        }
        for(int count = 7; count <= 9; count++){
            rooms.add(new Room(count,RoomType.SUITE,RoomStatus.ISAVAILIABLE));
        }
    }


}
