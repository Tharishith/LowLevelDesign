package ParkingLotDesign.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Ticket {
    private final int id;
    private static int counter;
    private final ParkingSpot parkingSpot;
    private LocalDateTime entryTime;

    public Ticket(ParkingSpot parkingSpot) {
        this.id = counter++;
        this.parkingSpot = parkingSpot;
        entryTime =LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
