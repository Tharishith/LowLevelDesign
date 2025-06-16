package ParkingLotDesign.service;

import ParkingLotDesign.model.*;

import java.util.List;
import java.util.Optional;

public class EntranceGateImpl implements EntranceGate{

    private final List<ParkingSpot> allSpots;

    public EntranceGateImpl(List<ParkingSpot> allSpots) {
        this.allSpots = allSpots;
    }

    @Override
    public Optional<Ticket> generateTicket(Vehicle vehicle) {
        try {
            System.out.println("Looking for spot for: " + vehicle.getVehicleType());

            ParkingSpotManager parkingSpotManager = ParkingSpotManagerFactory.getParkingSpot(allSpots, vehicle.getVehicleType());

            if (parkingSpotManager == null) {
                System.out.println("No manager found for vehicle type");
                return Optional.empty();
            }

            ParkingSpot spot = parkingSpotManager.parkVehicle(vehicle);

            System.out.println("Assigned spot: " + spot.getId());

            Ticket ticket = new Ticket(spot);
            return Optional.of(ticket);
        }
        catch (Exception e) {
            System.out.println("Exception in generateTicket: " + e.getMessage());
            return Optional.empty();
        }
    }
}
