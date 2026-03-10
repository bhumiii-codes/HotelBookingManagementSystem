import inventory.RoomInventory;
import model.*;
import service.RoomSearchService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hotel Booking Management System v1.0");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        List<Room> rooms = new ArrayList<>();

        rooms.add(single);
        rooms.add(doubleRoom);
        rooms.add(suite);

        // Search service
        RoomSearchService searchService = new RoomSearchService(inventory);

        // Perform search
        searchService.searchAvailableRooms(rooms);

    }
}