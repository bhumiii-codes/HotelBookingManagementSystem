package reservation;

/**
 * Represents a guest's booking request.
 * This class contains the basic information required
 * to process a reservation later.
 */
public class Reservation {

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
        System.out.println("Guest: " + guestName +
                " | Requested Room: " + roomType);
    }
}