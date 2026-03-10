import inventory.RoomInventory;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hotel Booking Management System v1.0");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display current inventory
        inventory.displayInventory();

        // Example lookup
        System.out.println("\nAvailable Single Rooms: "
                + inventory.getAvailability("Single Room"));

        // Example update
        inventory.updateAvailability("Single Room", 4);

        System.out.println("\nAfter update:");

        inventory.displayInventory();
    }
}