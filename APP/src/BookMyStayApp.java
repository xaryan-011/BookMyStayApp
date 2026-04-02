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
/**
 * RoomInventory
 *
 * Manages centralized room availability using HashMap.
 * Acts as a single source of truth for all room types.
 *
 * @author Aryan
 * @version 3.0
 */
import java.util.HashMap;
import java.util.Map;

class RoomInventory {

    private Map<String, Integer> inventory;

    // Constructor to initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        // Initialize room availability
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Get availability for a specific room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability (increase/decrease)
    public void updateAvailability(String roomType, int change) {
        int current = inventory.getOrDefault(roomType, 0);
        int updated = current + change;

        if (updated >= 0) {
            inventory.put(roomType, updated);
        } else {
            System.out.println("Invalid operation: Not enough rooms available for " + roomType);
        }
    }

    // Display full inventory
    public void displayInventory() {
        System.out.println("---- Current Room Inventory ----");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
/**
 * UseCase3InventorySetup
 *
 * Demonstrates centralized inventory management using HashMap.
 *
 * @author Aryan
 * @version 3.1
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   Welcome to Book My Stay App");
        System.out.println("   Hotel Booking System v3.1");
        System.out.println("=====================================\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Simulate updates
        System.out.println("\nUpdating Inventory...\n");

        // Booking a Single Room (-1)
        inventory.updateAvailability("Single Room", -1);

        // Booking a Suite Room (-1)
        inventory.updateAvailability("Suite Room", -1);

        // Cancelling a Double Room booking (+1)
        inventory.updateAvailability("Double Room", +1);

        // Display updated inventory
        System.out.println("\n---- Updated Inventory ----");
        inventory.displayInventory();

        System.out.println("\nApplication terminated successfully.");
    }
}
/**
 * Abstract Room class representing room details
 */
abstract class Room {
    protected String roomType;
    protected int beds;
    protected double price;

    public Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public abstract void displayDetails();
}
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 1000);
    }

    public void displayDetails() {
        System.out.println(roomType + " | Beds: " + beds + " | Price: ₹" + price);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 1800);
    }

    public void displayDetails() {
        System.out.println(roomType + " | Beds: " + beds + " | Price: ₹" + price);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 3000);
    }

    public void displayDetails() {
        System.out.println(roomType + " | Beds: " + beds + " | Price: ₹" + price);
    }
}
import java.util.HashMap;
import java.util.Map;

/**
 * Centralized inventory (same concept as Use Case 3)
 */
class RoomInventory {

    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0); // intentionally unavailable
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}
/**
 * SearchService handles room search (read-only)
 */
class SearchService {

    private RoomInventory inventory;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms(Room[] rooms) {

        System.out.println("---- Available Rooms ----\n");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getRoomType());

            // Validation: show only available rooms
            if (available > 0) {
                room.displayDetails();
                System.out.println("Available: " + available + "\n");
            }
        }
    }
}
/**
 * UseCase4RoomSearch
 *
 * Demonstrates read-only room search using inventory
 * without modifying system state.
 *
 * @author Aryan
 * @version 4.0
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   Welcome to Book My Stay App");
        System.out.println("   Hotel Booking System v4.0");
        System.out.println("=====================================\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Create room objects
        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        // Search service (read-only)
        SearchService searchService = new SearchService(inventory);

        // Perform search
        searchService.searchAvailableRooms(rooms);

        System.out.println("Search completed. No changes made to inventory.");
    }
}
