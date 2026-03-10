import model.SingleRoom;
import model.DoubleRoom;
import model.SuiteRoom;
import model.Room;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hotel Booking Management System v1.0");

        // Create room objects (polymorphism)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Availability variables (not using data structures yet)
        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        System.out.println("\n--- Room Details ---");

        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailability);

        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailability);

        System.out.println();

        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailability);

    }
}