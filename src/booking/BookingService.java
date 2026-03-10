package booking;

import inventory.RoomInventory;
import reservation.BookingRequestQueue;
import reservation.Reservation;

import java.util.*;

/**
 * Handles booking confirmation and room allocation.
 * Prevents double-booking by enforcing unique room IDs.
 */
public class BookingService {

    private RoomInventory inventory;
    private BookingRequestQueue queue;

    // Tracks assigned room IDs
    private Set<String> allocatedRoomIds;

    // Maps room type -> assigned room IDs
    private Map<String, Set<String>> allocationMap;

    public BookingService(RoomInventory inventory, BookingRequestQueue queue) {

        this.inventory = inventory;
        this.queue = queue;

        allocatedRoomIds = new HashSet<>();
        allocationMap = new HashMap<>();
    }

    public void processNextReservation() {

        Reservation reservation = queue.pollRequest();

        if (reservation == null) {
            System.out.println("No pending reservations.");
            return;
        }

        String roomType = reservation.getRoomType();

        int availability = inventory.getAvailability(roomType);

        if (availability <= 0) {
            System.out.println("No rooms available for " + roomType);
            return;
        }

        String roomId = generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        allocationMap
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.updateAvailability(roomType, availability - 1);

        System.out.println("Reservation confirmed for "
                + reservation.getGuestName()
                + " | Room ID: " + roomId);
    }

    private String generateRoomId(String roomType) {

        String prefix = roomType.replaceAll(" ", "").substring(0,3).toUpperCase();
        String roomId;

        do {
            roomId = prefix + "-" + (100 + allocatedRoomIds.size());
        } while (allocatedRoomIds.contains(roomId));

        return roomId;
    }

    public void displayAllocations() {

        System.out.println("\n--- Room Allocations ---");

        for (Map.Entry<String, Set<String>> entry : allocationMap.entrySet()) {

            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}