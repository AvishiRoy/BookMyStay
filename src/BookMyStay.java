import java.util.HashMap;

public class BookMyStay {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Book My Stay - Centralized Inventory");
        System.out.println("=================================");

        // HashMap to store room availability
        HashMap<String, Integer> roomInventory = new HashMap<>();

        roomInventory.put("Single Room", 10);
        roomInventory.put("Double Room", 5);
        roomInventory.put("Suite Room", 2);

        System.out.println("Current Room Availability:");

        for (String roomType : roomInventory.keySet()) {
            System.out.println(roomType + " : " + roomInventory.get(roomType));
        }

    }
}

