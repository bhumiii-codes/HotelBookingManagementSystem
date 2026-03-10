package reservation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages incoming booking requests using FIFO order.
 */
public class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {

        requestQueue.offer(reservation);

        System.out.println("Booking request added for "
                + reservation.getGuestName());
    }

    // Display queued requests
    public void displayQueue() {

        System.out.println("\n--- Booking Request Queue ---");

        for (Reservation reservation : requestQueue) {
            reservation.displayRequest();
        }
    }

    // Get next request (not processing yet)
    public Reservation peekNextRequest() {
        return requestQueue.peek();
    }
}