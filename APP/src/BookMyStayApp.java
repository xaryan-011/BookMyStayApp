/**
 * UseCase1HotelBookingApp
 *
 * This class represents the entry point of the Hotel Booking Management System.
 * It demonstrates how a Java application starts execution and prints output
 * to the console.
 *
 * The program displays a welcome message along with the application name
 * and version information.
 *
 * @author YourName
 * @version 1.0
 */
public class UseCase1HotelBookingApp {

    /**
     * Main method - entry point of the application
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        // Display welcome message
        System.out.println("=====================================");
        System.out.println("   Welcome to Book My Stay App");
        System.out.println("   Hotel Booking System v1.0");
        System.out.println("=====================================");
        System.out.println("Application started successfully!");
        System.out.println("Thank you for using our service.");
    }
}
/**
 * Abstract class representing a generic Room
 */
abstract class Room {
    protected String roomType;
    protected int numberOfBeds;
    protected double pricePerNight;

    // Constructor
    public Room(String roomType, int numberOfBeds, double pricePerNight) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
    }

    // Abstract method
    public abstract void displayRoomDetails();
}
/**
 * Represents a Single Room
 */
class SingleRoom extends Room {

    public SingleRoom() {
        super("Single Room", 1, 1000.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Price per night: ₹" + pricePerNight);
    }
}
/**
 * Represents a Double Room
 */
class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double Room", 2, 1800.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Price per night: ₹" + pricePerNight);
    }
}
/**
 * Represents a Suite Room
 */
class SuiteRoom extends Room {

    public SuiteRoom() {
        super("Suite Room", 3, 3000.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Price per night: ₹" + pricePerNight);
    }
}
/**
 * UseCase2RoomInitialization
 *
 * Demonstrates room initialization using abstraction,
 * inheritance, and static availability.
 *
 * @author Aryan
 * @version 2.1
 */
public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=====================================");
        System.out.println("   Welcome to Book My Stay App");
        System.out.println("   Hotel Booking System v2.1");
        System.out.println("=====================================\n");

        // Create room objects (Polymorphism)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability (simple variables)
        int singleRoomAvailable = 5;
        int doubleRoomAvailable = 3;
        int suiteRoomAvailable = 2;

        // Display details
        System.out.println("---- Room Details ----\n");

        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailable + "\n");

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailable + "\n");

        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailable + "\n");

        System.out.println("Application terminated successfully.");
    }
}
