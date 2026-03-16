import java.util.HashMap;

public class BookMyStay {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Book My Stay - Room Search");
        System.out.println("=================================");

        // Centralized room inventory
        HashMap<String, Integer> inventory = new HashMap<>();

        inventory.put("Single Room", 10);
        inventory.put("Double Room", 5);
        inventory.put("Suite Room", 0);

        // Room details (domain model information)
        HashMap<String, Integer> roomPrices = new HashMap<>();

        roomPrices.put("Single Room", 2000);
        roomPrices.put("Double Room", 3500);
        roomPrices.put("Suite Room", 6000);

        System.out.println("Available Rooms:\n");

        // Read-only search operation
        for (String roomType : inventory.keySet()) {

            int availableRooms = inventory.get(roomType);

            // Validation: show only rooms with availability > 0
            if (availableRooms > 0) {

                System.out.println("Room Type : " + roomType);
                System.out.println("Price     : ₹" + roomPrices.get(roomType));
                System.out.println("Available : " + availableRooms);
                System.out.println("-------------------------------");

            }
        }

    }
}


