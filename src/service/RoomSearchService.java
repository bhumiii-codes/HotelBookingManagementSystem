package service;

import inventory.RoomInventory;
import model.Room;

import java.util.List;

/**
 * Handles read-only search operations for rooms.
 * Retrieves availability from inventory and displays
 * only rooms that are currently available.
 */
public class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms(List<Room> rooms) {

        System.out.println("\n--- Available Rooms ---");

        for (Room room : rooms) {

            int availability = inventory.getAvailability(room.getRoomType());

            if (availability > 0) {

                room.displayRoomDetails();
                System.out.println("Available: " + availability);
                System.out.println();
            }
        }
    }
}