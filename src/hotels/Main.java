package hotels;

import hotels.Admin;
import hotels.Guest;
import hotels.Hotel;
import hotels.Room;

import java.util.Objects;
import java.util.Scanner;


public class Main {
   static Hotel hotel = new Hotel();
    static Admin admin = new Admin("Oyin","09038150060","ade@gmail.com","password", hotel);
    static Guest currentUser = null;
    public static void main(String[] args) {
        homePage();

    }

    public static void homePage(){
        String prompt = """
                    MONARCH HOTEL
                  1 => SIGNUP AS A GUEST
                  2 => LOGIN AS ADMIN OR GUEST
                
                """;
        print(prompt);
        String choice = input("Enter an option from above: ");
        switch (choice){
            case "1" -> signUpGuest();
            case "2" -> loginGuestAndAdmin();
        }
    }

    public static void signUpGuest(){
        String prompt = """
                       WELCOME\s
                    \s""";

        String name = "";
        String phone = "";
        String email = "";
        String password = "";
        do {
            name = input("Enter your name: ");
            if(name.isBlank()) print("invalid name, enter again");
        }while(name.isBlank());

        do {
            phone = input("Enter your phoneNumber: ");
            if(phone.length() != 11 || phone.isBlank() )print("invalid number , enter again");
        }while(((phone.length() != 11) || phone.isBlank()) || phone.contains("abcdefghijklmnopqrstuvwxyz"));


        do {
            email = input("Enter your email: ");
            if(email.isBlank() || !email.contains("@gmail.com"))print("invalid email(e.g aaa@gmail.com)");
        }while(email.isBlank() || !email.contains("@gmail.com"));

        do {
            password = input("Enter your password: ");

            if(password.trim().length() < 6)print("invalid password, re-enter!!(minimum of 6 characters)");
        }while(password.trim().length() < 6);
        Guest guest = new Guest(name,phone,email, password);
        admin.addGuest(guest);
        timer();

        println("");
        homePage();


    }

    public static void timer(){
        print("Loading");
        for(int count = 1; count < 5; count++){
            for(int counter = 1; counter < 4000000; counter++){
                print("");
            }
            print(".");
        }
        println("SIGNUP SUCCESSFULLY");

    }


    public static void loginTimer(){
        print("Loading");
        for(int count = 1; count < 5; count++){
            for(int counter = 1; counter < 3000000; counter++){
                print("");
            }
            print(".");
        }


    }






    public static void loginGuestAndAdmin(){
        String email = "";
        String password = "";

        do {
            email = input("Enter your email: ");
            if (isNotValidEmail(email)) print("Invalid email, try again");
        } while (isNotValidEmail(email));

        do {
            password = input ("Enter your password: ");
            if (password.trim().length() < 6) print("Invalid password, try again");
        } while (password.trim().length() < 6);

        if (admin.getEmailAddress().equals(email) && admin.getPassword().equals(password)) {
            adminMenu();
            return;
        }

        Guest guest  = admin.loginGuest(email, password);

        if(guest != null){
            currentUser = guest;
            loginTimer();
            println("Login successfully");
            guestMenu();

        }

        else{
            print("invalid email or password");
            homePage();
        }


    }
    private static boolean isNotValidEmail(String email) {
        return Objects.equals(email, "") || !email.contains("@gmail.com");
    }




    public static void adminMenu(){
        String prompt = """
                       WELCOME MADAM OYINADEE
                      \s
                       OPTIONS
                      \s
                       1 => VIEW ALL ROOMS
                      \s
                       2 => ADD ROOMS
                      \s
                       3 => view guest bookings
                      \s
                       4 => MARK ROOM FOR MAINTENANCE
                      \s
                       5 => VIEW GUEST DETAILS
                   \s""";
        print(prompt);
      String guests = input("Enter  any option from above: ");
        switch(guests) {
            case "1" -> viewAllRooms();
            case "2" -> addRooms();
            case "3" -> viewGuestBookings();
            case "4" -> markRoomForMaintanance();
            case "0" -> System.out.println("existing");
            default -> {
                println("Invalid input");
                adminMenu();
            }
        }


    }
    public static void viewAllRooms(){
        for(Room room : admin.viewRoom()){
            System.out.print("Room Number" + "      " +  room.getRoomNumber() +"        " + "|" + "     " + "Type" + "      " + room.getType() +"       " + "|" + "Price" +"       " + room.getPrice());
            System.out.println();
        }
        adminMenu();
    }

    public static void addRooms(){
        RoomType room = RoomType.valueOf(input("Enter Room type: "));
        int numberOfRooms = Integer.parseInt(input("How many rooms do you want to add: "));
        admin.addRoom(room, numberOfRooms);
        print("Room added successfully");
        adminMenu();
    }

    public static void viewGuestBookings(){
        int roomNumber = Integer.parseInt(input("Enter Room number:"));
        admin.manageGuestDetails(roomNumber);
        println("Guest details:");
        println("Name :" + currentUser.getName());
        println("Phone: " + currentUser.getPhoneNumber());
        println("Email: " + currentUser.getEmailAddress());
        println("Reservation Detail:");
        println("Room Number : " );
        adminMenu();
    }

    public static void markRoomForMaintanance(){
        int  roomNumber = Integer.parseInt(input("Enter Room number:"));
        Room room = hotel.findRoomByNumber(roomNumber);
        admin.markRoomAsMaintance(room);
        print("Room marked under maintainance");
    }



















    public static void guestMenu(){
        String prompt = """
                WELCOME, OUR ESTEEMED CUSTOMER!
                OPTIONS:
        1. BOOK ROOM
        2. VIEW BOOKING
        3. EDIT PROFILE
        4. CANCEL BOOKING
        5. VIEW NOTIFICATION
        
        """;
        print(prompt);
        String choice = input("Enter an option from above: ");
        switch(choice){
            case "1" ->bookRoom();
            case "2" -> viewBookings();
            case "3" -> editProfile();
            case "4" -> cancelRoom();
            case "0" -> println("Exiting....");

        }
    }

    public static void bookRoom(){
        int  roomNumber = Integer.parseInt(input("Enter Room number:"));
        int numberOfNight = Integer.parseInt(input("Enter Room number:"));
        Room room = hotel.findRoomByNumber(roomNumber);
        if(room == null){
            println("Room doesn't exist");
            guestMenu();
        }
        if(room.getStatus() != RoomStatus.ISAVAILIABLE){
            println("Room is unavailiable");
        }
        Booking booking = new Booking(currentUser,room);
        currentUser.bookRoom(hotel, room,booking );
        hotel.addBookings(booking);
        println("Your reference number is " + booking.getRoomBooked().getReferenceNumber());
        println("Room " + roomNumber + " booked successfully!");
        guestMenu();

    }


    public static void viewBookings(){
            for (Booking booking : hotel.getBookings()) {
                if (booking.getGuestDetails() == currentUser) {
                    println("----- YOUR BOOKING DETAILS -----");
                    println("Guest Name: " + booking.getGuestDetails().getName());
                    println("Room Number: " + booking.getRoomBooked().getRoomNumber());
                    println("Room Type: " + booking.getRoomBooked().getType());
                    println("Amount: ₦" + booking.getRoomBooked().getPrice());
                    println("Reference number:  " +booking.getRoomBooked().getReferenceNumber());
                    println("Status: " + booking.getRoomBooked().getStatus());
                    println("Date: " + booking.getDate());
                    println("--------------------------------");
                    guestMenu();
                }
            }
            println("You do not have any booking.");
            guestMenu();

    }

    public  static void editProfile(){
        String newName = input("Enter your name: ");
        String newEmail = input("Enter new email address: ");
        String newPhone = input("Enter new phone number: ");
        currentUser.editProfile(newName, newEmail, newPhone);
        guestMenu();
    }

    public static void cancelRoom(){
        int roomNumber = Integer.parseInt(input("Enter your room number: "));
        Room room = hotel.findRoomByNumber(roomNumber);
        Booking booking = new Booking(currentUser, room);
        currentUser.cancelReservation(hotel, booking, room);
        hotel.removeBooking(booking);
        println("Reservation cancelled successfully");
        guestMenu();
    }


















    public static void print(String message){
        System.out.print(message);
    }

    public static void println(String message){
        System.out.println(message);
    }

    public static String input(String prompt){
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}