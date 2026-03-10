import inventory.RoomInventory;
import reservation.*;
import booking.BookingService;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hotel Booking Management System v1.0");

        RoomInventory inventory = new RoomInventory();

        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Alice", "Single Room"));
        queue.addRequest(new Reservation("Bob", "Double Room"));
        queue.addRequest(new Reservation("Charlie", "Suite Room"));

        BookingService bookingService = new BookingService(inventory, queue);

        bookingService.processNextReservation();
        bookingService.processNextReservation();
        bookingService.processNextReservation();

        bookingService.displayAllocations();

    }
}