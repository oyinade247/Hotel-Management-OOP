package hotels;

import java.util.Date;

public class Room {
        private int roomNumber;
        private int referenceNumber;
        private static int number;
        private RoomType type;
        private int price;
        private RoomStatus status;
        private Date checkIn;

    private Date checkOut;



    public Room(){


        }

        public Room(int roomNumber, RoomType type, RoomStatus status){
            this.roomNumber = roomNumber;
            this.type = type;
            this.price = type.getPrice();
            this.status = status;
            this.referenceNumber = ++number;

        }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

//    public void setReferenceNumber(int referenceNumber) {
//        this.referenceNumber = referenceNumber;
//    }

//    public static int getNumber() {
//        return number;
//    }

//    public static void setNumber(int number) {
//        Room.number = number;
//    }

    public RoomType getType() {
        return type;
    }

//    public void setType(RoomType type) {
//        this.type = type;
//    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
            this.price = price;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}
