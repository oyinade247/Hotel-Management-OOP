package hotels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    void testThatRoomHasANumber(){
        Room room = new Room(1, RoomType.SINGLE,RoomStatus.ISAVAILIABLE);
       assertEquals( 1,room.getRoomNumber());
    }
    @Test
    void testThatRoomNumberCanBeSwt(){
        Room room = new Room(1, RoomType.SINGLE,RoomStatus.ISAVAILIABLE);
        room.setRoomNumber(1);
        assertEquals( 1,room.getRoomNumber());
    }

    @Test
    void testThatRoomHasReferenceNumber(){
        Room room = new Room(1, RoomType.SINGLE,RoomStatus.ISAVAILIABLE);
        assertEquals( 5,room.getReferenceNumber());
    }
    @Test
    void testThatRoomHasType(){
        Room room = new Room(1, RoomType.SINGLE,RoomStatus.ISAVAILIABLE);
        assertEquals( RoomType.SINGLE,room.getType());

    }
    @Test
    void testThatRoomCanGetPrice(){
        Room room = new Room(1, RoomType.SINGLE,RoomStatus.ISAVAILIABLE);
        room.setPrice(10000);
        assertEquals(10000,room.getPrice());
    }
    @Test
    void testThatRoomCanSetPrice(){
        Room room = new Room(1, RoomType.SINGLE,RoomStatus.ISAVAILIABLE);
        room.setPrice(10000);
        assertEquals(10000,room.getPrice());
    }

    @Test
    void testThatRoomHasAStatus(){
        Room room = new Room(1, RoomType.SINGLE,RoomStatus.ISAVAILIABLE);
        assertEquals(RoomStatus.ISAVAILIABLE,room.getStatus());

    }

}