import java.util.LinkedList;
import java.util.Queue;

public class BookMyStay {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Book My Stay - Booking Request Queue");
        System.out.println("=================================");

        // Queue to store booking requests
        Queue<String> bookingQueue = new LinkedList<>();

        // Guests submitting booking requests
        bookingQueue.add("Reservation: Guest A - Single Room");
        bookingQueue.add("Reservation: Guest B - Double Room");
        bookingQueue.add("Reservation: Guest C - Suite Room");

        System.out.println("Booking Requests Received:\n");

        // Display queue contents in arrival order
        for (String request : bookingQueue) {
            System.out.println(request);
        }

        System.out.println("\nRequests are stored in FIFO order.");
        System.out.println("No room allocation performed at this stage.");

    }
}



