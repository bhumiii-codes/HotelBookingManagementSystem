import reservation.Reservation;
import reservation.BookingRequestQueue;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hotel Booking Management System v1.0");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Guests submit booking requests
        Reservation r1 = new Reservation("Alice", "Single Room");
        Reservation r2 = new Reservation("Bob", "Double Room");
        Reservation r3 = new Reservation("Charlie", "Suite Room");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Display queued requests
        bookingQueue.displayQueue();

        // Peek next request
        System.out.println("\nNext request to process:");
        bookingQueue.peekNextRequest().displayRequest();

    }
}