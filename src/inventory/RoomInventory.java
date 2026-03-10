package inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the centralized inventory of rooms.
 * Uses HashMap to store room type and availability.
 */
public class RoomInventory {

    private Map<String, Integer> roomAvailability;

    // Constructor initializes inventory
    public RoomInventory() {

        roomAvailability = new HashMap<>();

        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);
    }

    // Get availability of a room type
    public int getAvailability(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int newCount) {
        roomAvailability.put(roomType, newCount);
    }

    // Display entire inventory
    public void displayInventory() {

        System.out.println("\n--- Current Room Inventory ---");

        for (Map.Entry<String, Integer> entry : roomAvailability.entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue() + " available");
        }
    }
}