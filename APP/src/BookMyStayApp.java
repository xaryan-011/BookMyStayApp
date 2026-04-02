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
/**
 * Reservation
 *
 * Represents a guest booking request.
 * Contains guest name and requested room type.
 *
 * @author Aryan
 * @version 5.0
 */
class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayRequest() {
        System.out.println("Guest: " + guestName + " | Requested Room: " + roomType);
    }
}import java.util.LinkedList;
import java.util.Queue;

/**
 * BookingRequestQueue
 *
 * Manages incoming booking requests using FIFO Queue.
 * Ensures fairness (First-Come-First-Served).
 *
 * @author Aryan
 * @version 5.0
 */
class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added for " + reservation.getGuestName());
    }

    // View all requests (without removing)
    public void displayAllRequests() {
        System.out.println("\n---- Booking Requests Queue ----");

        if (queue.isEmpty()) {
            System.out.println("No booking requests available.");
            return;
        }

        for (Reservation r : queue) {
            r.displayRequest();
        }
    }
}/**
 * UseCase5BookingRequestQueue
 *
 * Demonstrates FIFO booking request handling using Queue.
 * No inventory updates are performed here.
 *
 * @author Aryan
 * @version 5.1
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   Welcome to Book My Stay App");
        System.out.println("   Hotel Booking System v5.1");
        System.out.println("=====================================\n");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Simulate booking requests
        bookingQueue.addRequest(new Reservation("Aryan", "Single Room"));
        bookingQueue.addRequest(new Reservation("Neha", "Double Room"));
        bookingQueue.addRequest(new Reservation("Rahul", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Sneha", "Single Room"));

        // Display queue (FIFO order)
        bookingQueue.displayAllRequests();

        System.out.println("\nAll requests are stored in arrival order (FIFO).");
        System.out.println("No inventory changes performed.");
    }
}/**
 * UseCase5BookingRequestQueue
 *
 * Demonstrates FIFO booking request handling using Queue.
 * No inventory updates are performed here.
 *
 * @author Aryan
 * @version 5.1
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   Welcome to Book My Stay App");
        System.out.println("   Hotel Booking System v5.1");
        System.out.println("=====================================\n");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Simulate booking requests
        bookingQueue.addRequest(new Reservation("Aryan", "Single Room"));
        bookingQueue.addRequest(new Reservation("Neha", "Double Room"));
        bookingQueue.addRequest(new Reservation("Rahul", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Sneha", "Single Room"));

        // Display queue (FIFO order)
        bookingQueue.displayAllRequests();

        System.out.println("\nAll requests are stored in arrival order (FIFO).");
        System.out.println("No inventory changes performed.");
    }
}
/**
 * Represents a booking request
 */
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}import java.util.LinkedList;
import java.util.Queue;

class BookingRequestQueue {
    private Queue<Reservation> queue = new LinkedList<>();

    public void addRequest(Reservation r) {
        queue.offer(r);
    }

    public Reservation getNextRequest() {
        return queue.poll(); // FIFO
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}import java.util.HashMap;
import java.util.Map;

class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void decrement(String type) {
        inventory.put(type, getAvailability(type) - 1);
    }

    public void displayInventory() {
        System.out.println("\nRemaining Inventory:");
        for (Map.Entry<String, Integer> e : inventory.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}import java.util.*;

/**
 * BookingService handles allocation and confirmation
 */
class BookingService {

    private RoomInventory inventory;

    // Track allocated room IDs per type
    private Map<String, Set<String>> allocatedRooms = new HashMap<>();

    // Global set to ensure uniqueness
    private Set<String> allRoomIds = new HashSet<>();

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // Generate unique room ID
    private String generateRoomId(String roomType) {
        String prefix = roomType.replace(" ", "").substring(0, 2).toUpperCase();
        String id;

        do {
            id = prefix + (int)(Math.random() * 1000);
        } while (allRoomIds.contains(id));

        return id;
    }

    // Process booking
    public void processReservation(Reservation r) {

        String type = r.getRoomType();

        if (inventory.getAvailability(type) > 0) {

            String roomId = generateRoomId(type);

            // Store in global set
            allRoomIds.add(roomId);

            // Map to room type
            allocatedRooms.putIfAbsent(type, new HashSet<>());
            allocatedRooms.get(type).add(roomId);

            // Update inventory immediately
            inventory.decrement(type);

            System.out.println("Booking Confirmed!");
            System.out.println("Guest: " + r.getGuestName());
            System.out.println("Room Type: " + type);
            System.out.println("Allocated Room ID: " + roomId + "\n");

        } else {
            System.out.println("Booking Failed for " + r.getGuestName() +
                    " (No " + type + " available)\n");
        }
    }
}/**
 * UseCase6RoomAllocationService
 *
 * Demonstrates FIFO booking processing,
 * safe allocation, and prevention of double booking.
 *
 * @author Aryan
 * @version 6.1
 */
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   Welcome to Book My Stay App");
        System.out.println("   Hotel Booking System v6.1");
        System.out.println("=====================================\n");

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        BookingService service = new BookingService(inventory);

        // Add booking requests (FIFO)
        queue.addRequest(new Reservation("Aryan", "Single Room"));
        queue.addRequest(new Reservation("Neha", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Single Room")); // should fail
        queue.addRequest(new Reservation("Sneha", "Suite Room"));

        // Process queue
        while (!queue.isEmpty()) {
            Reservation r = queue.getNextRequest();
            service.processReservation(r);
        }

        // Final inventory
        inventory.displayInventory();

        System.out.println("\nAll bookings processed safely.");
    }
}/**
 * Represents an optional service (e.g., WiFi, Breakfast)
 */
class AddOnService {

    private String serviceName;
    private double cost;

    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }
}import java.util.*;

/**
 * Manages mapping between reservation IDs and selected services
 */
class AddOnServiceManager {

    // Map: Reservation ID → List of Services
    private Map<String, List<AddOnService>> serviceMap = new HashMap<>();

    // Add service to a reservation
    public void addService(String reservationId, AddOnService service) {

        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);

        System.out.println(service.getServiceName() +
                " added to Reservation ID: " + reservationId);
    }

    // Display services for a reservation
    public void displayServices(String reservationId) {

        System.out.println("\nServices for Reservation ID: " + reservationId);

        List<AddOnService> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No add-on services selected.");
            return;
        }

        for (AddOnService s : services) {
            System.out.println("- " + s.getServiceName() + " : ₹" + s.getCost());
        }
    }

    // Calculate total cost
    public double calculateTotalCost(String reservationId) {

        List<AddOnService> services = serviceMap.get(reservationId);

        double total = 0;

        if (services != null) {
            for (AddOnService s : services) {
                total += s.getCost();
            }
        }

        return total;
    }
}/**
 * UseCase7AddOnServiceSelection
 *
 * Demonstrates adding optional services to a reservation
 * without modifying booking or inventory logic.
 *
 * @author Aryan
 * @version 7.1
 */
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   Welcome to Book My Stay App");
        System.out.println("   Hotel Booking System v7.1");
        System.out.println("=====================================\n");

        // Simulated reservation ID (from previous use case)
        String reservationId = "RES101";

        // Create service manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Create services
        AddOnService wifi = new AddOnService("WiFi", 200);
        AddOnService breakfast = new AddOnService("Breakfast", 300);
        AddOnService spa = new AddOnService("Spa Access", 800);

        // Add services to reservation
        manager.addService(reservationId, wifi);
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);

        // Display selected services
        manager.displayServices(reservationId);

        // Calculate total cost
        double total = manager.calculateTotalCost(reservationId);

        System.out.println("\nTotal Add-On Cost: ₹" + total);

        System.out.println("\nNote: Booking & inventory remain unchanged.");
    }
}import java.util.ArrayList;
import java.util.List;

// Reservation class representing a confirmed booking
class Reservation {
    private int reservationId;
    private String guestName;
    private String roomType;
    private int nights;

    public Reservation(int reservationId, String guestName, String roomType, int nights) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId +
                ", Guest: " + guestName +
                ", Room Type: " + roomType +
                ", Nights: " + nights;
    }
}

// BookingHistory class to store confirmed reservations
class BookingHistory {
    private List<Reservation> reservations;

    public BookingHistory() {
        reservations = new ArrayList<>();
    }

    // Add confirmed reservation to history
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    // Retrieve all reservations
    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations); // Return a copy to avoid modification
    }
}

// BookingReportService class to generate reports
class BookingReportService {
    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    // Generate a summary report
    public void generateReport() {
        List<Reservation> allReservations = history.getAllReservations();
        System.out.println("===== Booking History Report =====");
        if (allReservations.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Reservation r : allReservations) {
                System.out.println(r);
            }
        }
        System.out.println("Total Reservations: " + allReservations.size());
        System.out.println("=================================");
    }
}

// Main class to demonstrate Use Case 8
public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        // Create booking history
        BookingHistory history = new BookingHistory();

        // Simulate confirmed bookings
        history.addReservation(new Reservation(101, "Alice Johnson", "Deluxe", 3));
        history.addReservation(new Reservation(102, "Bob Smith", "Standard", 2));
        history.addReservation(new Reservation(103, "Charlie Brown", "Suite", 5));

        // Admin generates booking report
        BookingReportService reportService = new BookingReportService(history);
        reportService.generateReport();
    }
}import java.util.*;

// Custom Exception for invalid bookings
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Enum for room types
enum RoomType {
    SINGLE, DOUBLE, SUITE
}

// Hotel class with inventory management
class Hotel {
    private Map<RoomType, Integer> roomInventory = new HashMap<>();

    public Hotel() {
        // Initial inventory
        roomInventory.put(RoomType.SINGLE, 5);
        roomInventory.put(RoomType.DOUBLE, 3);
        roomInventory.put(RoomType.SUITE, 2);
    }

    public void bookRoom(RoomType type) throws InvalidBookingException {
        if (!roomInventory.containsKey(type)) {
            throw new InvalidBookingException("Room type " + type + " does not exist.");
        }

        int available = roomInventory.get(type);
        if (available <= 0) {
            throw new InvalidBookingException("No " + type + " rooms available.");
        }

        roomInventory.put(type, available - 1); // Update inventory
        System.out.println("Booking confirmed for a " + type + " room. Remaining: " + (available - 1));
    }

    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<RoomType, Integer> entry : roomInventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

// Main program to handle user input and booking
public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        boolean continueBooking = true;

        System.out.println("Welcome to Book My Stay App");

        while (continueBooking) {
            hotel.displayInventory();

            System.out.println("Enter room type to book (SINGLE, DOUBLE, SUITE) or QUIT to exit:");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("QUIT")) {
                continueBooking = false;
                System.out.println("Thank you for using Book My Stay App!");
                break;
            }

            try {
                // Validate and book room
                RoomType roomType = RoomType.valueOf(input); // This throws IllegalArgumentException for invalid input
                hotel.bookRoom(roomType);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Invalid room type entered.");
            } catch (InvalidBookingException e) {
                System.out.println("Booking failed: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

            System.out.println(); // Blank line for readability
        }

        scanner.close();
    }
}import java.util.*;

// Custom Exception for invalid bookings
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Enum for room types
enum RoomType {
    SINGLE, DOUBLE, SUITE
}

// Booking class to store details
class Booking {
    String guestName;
    RoomType roomType;
    String roomId; // Unique room identifier

    public Booking(String guestName, RoomType roomType, String roomId) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return guestName + " - " + roomType + " (" + roomId + ")";
    }
}

// Hotel class with inventory and booking management
class Hotel {
    private Map<RoomType, Integer> roomInventory = new HashMap<>();
    private Map<RoomType, Stack<String>> availableRoomIds = new HashMap<>();
    private List<Booking> bookings = new ArrayList<>();

    public Hotel() {
        // Initial inventory and room IDs
        roomInventory.put(RoomType.SINGLE, 5);
        roomInventory.put(RoomType.DOUBLE, 3);
        roomInventory.put(RoomType.SUITE, 2);

        availableRoomIds.put(RoomType.SINGLE, new Stack<>());
        availableRoomIds.put(RoomType.DOUBLE, new Stack<>());
        availableRoomIds.put(RoomType.SUITE, new Stack<>());

        // Pre-populate room IDs
        for (int i = 1; i <= 5; i++) availableRoomIds.get(RoomType.SINGLE).push("S" + i);
        for (int i = 1; i <= 3; i++) availableRoomIds.get(RoomType.DOUBLE).push("D" + i);
        for (int i = 1; i <= 2; i++) availableRoomIds.get(RoomType.SUITE).push("SU" + i);
    }

    // Book a room
    public void bookRoom(String guestName, RoomType type) throws InvalidBookingException {
        if (!roomInventory.containsKey(type)) {
            throw new InvalidBookingException("Room type " + type + " does not exist.");
        }
        int available = roomInventory.get(type);
        if (available <= 0) {
            throw new InvalidBookingException("No " + type + " rooms available.");
        }
        // Allocate room
        String roomId = availableRoomIds.get(type).pop();
        roomInventory.put(type, available - 1);
        bookings.add(new Booking(guestName, type, roomId));
        System.out.println("Booking confirmed: " + guestName + " in " + type + " room " + roomId);
    }

    // Cancel a booking
    public void cancelBooking(String guestName) throws InvalidBookingException {
        Booking found = null;
        for (Booking b : bookings) {
            if (b.guestName.equalsIgnoreCase(guestName)) {
                found = b;
                break;
            }
        }
        if (found == null) {
            throw new InvalidBookingException("No booking found for guest: " + guestName);
        }

        // Rollback inventory and room ID
        roomInventory.put(found.roomType, roomInventory.get(found.roomType) + 1);
        availableRoomIds.get(found.roomType).push(found.roomId);
        bookings.remove(found);
        System.out.println("Booking cancelled for " + guestName + " (" + found.roomType + " room " + found.roomId + ")");
    }

    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<RoomType, Integer> entry : roomInventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No current bookings.");
            return;
        }
        System.out.println("Current Bookings:");
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }
}

// Main program
public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        boolean running = true;

        System.out.println("Welcome to Book My Stay App (Cancellation Enabled)");

        while (running) {
            System.out.println("\n1. Book Room\n2. Cancel Booking\n3. Show Inventory\n4. Show Bookings\n5. Quit");
            System.out.print("Select option: ");
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter guest name: ");
                        String guest = scanner.nextLine().trim();
                        System.out.print("Enter room type (SINGLE, DOUBLE, SUITE): ");
                        RoomType type = RoomType.valueOf(scanner.nextLine().trim().toUpperCase());
                        hotel.bookRoom(guest, type);
                        break;
                    case "2":
                        System.out.print("Enter guest name to cancel: ");
                        String cancelGuest = scanner.nextLine().trim();
                        hotel.cancelBooking(cancelGuest);
                        break;
                    case "3":
                        hotel.displayInventory();
                        break;
                    case "4":
                        hotel.displayBookings();
                        break;
                    case "5":
                        running = false;
                        System.out.println("Thank you for using Book My Stay App!");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Invalid room type entered.");
            } catch (InvalidBookingException e) {
                System.out.println("Operation failed: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}import java.util.*;
        import java.util.concurrent.*;

// Custom Exception for invalid bookings
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Enum for room types
enum RoomType {
    SINGLE, DOUBLE, SUITE
}

// Hotel class with thread-safe inventory management
class Hotel {
    private Map<RoomType, Integer> roomInventory = new EnumMap<>(RoomType.class);

    public Hotel() {
        roomInventory.put(RoomType.SINGLE, 5);
        roomInventory.put(RoomType.DOUBLE, 3);
        roomInventory.put(RoomType.SUITE, 2);
    }

    // Thread-safe booking method
    public synchronized void bookRoom(String guestName, RoomType type) throws InvalidBookingException {
        int available = roomInventory.getOrDefault(type, 0);
        if (available <= 0) {
            throw new InvalidBookingException("No " + type + " rooms available for " + guestName);
        }
        roomInventory.put(type, available - 1);
        System.out.println("Booking confirmed: " + guestName + " booked a " + type + " room. Remaining: " + (available - 1));
    }

    public synchronized void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<RoomType, Integer> entry : roomInventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

// Runnable task representing a guest booking
class BookingTask implements Runnable {
    private String guestName;
    private RoomType roomType;
    private Hotel hotel;

    public BookingTask(String guestName, RoomType roomType, Hotel hotel) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.hotel = hotel;
    }

    @Override
    public void run() {
        try {
            hotel.bookRoom(guestName, roomType);
        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }
}

// Main simulation class
public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) throws InterruptedException {
        Hotel hotel = new Hotel();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Simulate multiple guests trying to book rooms concurrently
        List<BookingTask> tasks = Arrays.asList(
                new BookingTask("Alice", RoomType.SINGLE, hotel),
                new BookingTask("Bob", RoomType.SINGLE, hotel),
                new BookingTask("Charlie", RoomType.DOUBLE, hotel),
                new BookingTask("Diana", RoomType.SUITE, hotel),
                new BookingTask("Ethan", RoomType.SINGLE, hotel),
                new BookingTask("Fiona", RoomType.DOUBLE, hotel),
                new BookingTask("George", RoomType.SUITE, hotel),
                new BookingTask("Hannah", RoomType.SINGLE, hotel)
        );

        // Submit tasks to executor
        for (BookingTask task : tasks) {
            executor.submit(task);
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("\nFinal Room Inventory:");
        hotel.displayInventory();
    }
}import java.io.*;
        import java.util.*;

// Custom Exception for invalid bookings
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Enum for room types
enum RoomType {
    SINGLE, DOUBLE, SUITE
}

// Booking class with Serializable for persistence
class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    String guestName;
    RoomType roomType;
    String roomId;

    public Booking(String guestName, RoomType roomType, String roomId) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return guestName + " - " + roomType + " (" + roomId + ")";
    }
}

// Hotel class with inventory and booking management
class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<RoomType, Integer> roomInventory = new EnumMap<>(RoomType.class);
    private Map<RoomType, Stack<String>> availableRoomIds = new EnumMap<>(RoomType.class);
    private List<Booking> bookings = new ArrayList<>();

    public Hotel() {
        // Default inventory
        roomInventory.put(RoomType.SINGLE, 5);
        roomInventory.put(RoomType.DOUBLE, 3);
        roomInventory.put(RoomType.SUITE, 2);

        availableRoomIds.put(RoomType.SINGLE, new Stack<>());
        availableRoomIds.put(RoomType.DOUBLE, new Stack<>());
        availableRoomIds.put(RoomType.SUITE, new Stack<>());

        for (int i = 1; i <= 5; i++) availableRoomIds.get(RoomType.SINGLE).push("S" + i);
        for (int i = 1; i <= 3; i++) availableRoomIds.get(RoomType.DOUBLE).push("D" + i);
        for (int i = 1; i <= 2; i++) availableRoomIds.get(RoomType.SUITE).push("SU" + i);
    }

    // Book a room
    public synchronized void bookRoom(String guestName, RoomType type) throws InvalidBookingException {
        int available = roomInventory.getOrDefault(type, 0);
        if (available <= 0) throw new InvalidBookingException("No " + type + " rooms available.");

        String roomId = availableRoomIds.get(type).pop();
        roomInventory.put(type, available - 1);
        bookings.add(new Booking(guestName, type, roomId));
        System.out.println("Booking confirmed: " + guestName + " in " + type + " room " + roomId);
    }

    // Cancel a booking
    public synchronized void cancelBooking(String guestName) throws InvalidBookingException {
        Booking found = null;
        for (Booking b : bookings) {
            if (b.guestName.equalsIgnoreCase(guestName)) {
                found = b;
                break;
            }
        }
        if (found == null) throw new InvalidBookingException("No booking found for guest: " + guestName);

        roomInventory.put(found.roomType, roomInventory.get(found.roomType) + 1);
        availableRoomIds.get(found.roomType).push(found.roomId);
        bookings.remove(found);
        System.out.println("Booking cancelled for " + guestName + " (" + found.roomType + " room " + found.roomId + ")");
    }

    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<RoomType, Integer> entry : roomInventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No current bookings.");
            return;
        }
        System.out.println("Current Bookings:");
        for (Booking b : bookings) System.out.println(b);
    }

    // Save hotel state to file
    public void saveState(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
            System.out.println("System state saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving state: " + e.getMessage());
        }
    }

    // Load hotel state from file
    public static Hotel loadState(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Hotel) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Persistence file not found. Starting with default state.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading state: " + e.getMessage());
        }
        return new Hotel();
    }
}

// Main program
public class UseCase12DataPersistenceRecovery {
    private static final String STATE_FILE = "hotel_state.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = Hotel.loadState(STATE_FILE);
        boolean running = true;

        System.out.println("Welcome to Book My Stay App (Persistent Version)");

        while (running) {
            System.out.println("\n1. Book Room\n2. Cancel Booking\n3. Show Inventory\n4. Show Bookings\n5. Save & Exit");
            System.out.print("Select option: ");
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter guest name: ");
                        String guest = scanner.nextLine().trim();
                        System.out.print("Enter room type (SINGLE, DOUBLE, SUITE): ");
                        RoomType type = RoomType.valueOf(scanner.nextLine().trim().toUpperCase());
                        hotel.bookRoom(guest, type);
                        break;
                    case "2":
                        System.out.print("Enter guest name to cancel: ");
                        String cancelGuest = scanner.nextLine().trim();
                        hotel.cancelBooking(cancelGuest);
                        break;
                    case "3":
                        hotel.displayInventory();
                        break;
                    case "4":
                        hotel.displayBookings();
                        break;
                    case "5":
                        hotel.saveState(STATE_FILE);
                        running = false;
                        System.out.println("Exiting application. State saved.");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Invalid room type entered.");
            } catch (InvalidBookingException e) {
                System.out.println("Operation failed: " + e.getMessage());
            }
        }

        scanner.close();
    }
}