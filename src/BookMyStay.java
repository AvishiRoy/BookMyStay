import java.util.*;

public class BookMyStay {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Book My Stay - Reservation Allocation");
        System.out.println("=================================");

        // Inventory (room availability)
        HashMap<String, Integer> inventory = new HashMap<>();

        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);

        // Booking request queue (FIFO)
        Queue<String> bookingQueue = new LinkedList<>();

        bookingQueue.add("Guest A:Single Room");
        bookingQueue.add("Guest B:Double Room");
        bookingQueue.add("Guest C:Single Room");
        bookingQueue.add("Guest D:Suite Room");

        // Track allocated room IDs (prevents duplicates)
        Set<String> allocatedRoomIds = new HashSet<>();

        // Map room types to assigned room IDs
        HashMap<String, Set<String>> allocationMap = new HashMap<>();

        int roomCounter = 1;

        System.out.println("\nProcessing Reservations:\n");

        // Process queue
        while (!bookingQueue.isEmpty()) {

            String request = bookingQueue.poll();

            String[] parts = request.split(":");

            String guestName = parts[0];
            String roomType = parts[1];

            int availableRooms = inventory.getOrDefault(roomType, 0);

            if (availableRooms > 0) {

                // Generate unique room ID
                String roomId = roomType.replace(" ", "") + "-" + roomCounter++;

                // Ensure uniqueness
                if (!allocatedRoomIds.contains(roomId)) {

                    allocatedRoomIds.add(roomId);

                    allocationMap.putIfAbsent(roomType, new HashSet<>());
                    allocationMap.get(roomType).add(roomId);

                    // Update inventory
                    inventory.put(roomType, availableRooms - 1);

                    System.out.println("Reservation Confirmed:");
                    System.out.println(guestName + " → " + roomType + " (" + roomId + ")");
                    System.out.println();
                }

            } else {

                System.out.println("Reservation Failed:");
                System.out.println(guestName + " → " + roomType + " (No Availability)");
                System.out.println();
            }
        }

        System.out.println("Final Inventory State:");

        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " Remaining : " + inventory.get(roomType));
        }

    }
}




