package ParkingLotDesign.model;

import java.util.List;
import java.util.PriorityQueue;

public class FourWheelerManager extends ParkingSpotManager{

    private PriorityQueue<ParkingSpot> availableSpots;

    public FourWheelerManager(List<ParkingSpot> parkingSpotList){
        super(parkingSpotList);
    }

    @Override
    public ParkingSpot findParkingSpace() {
        return getParkingSpots().stream()
                .filter(ParkingSpot::isAvailable)
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("No Four space is Available"));
    }


}
