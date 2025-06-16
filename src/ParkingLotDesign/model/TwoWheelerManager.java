package ParkingLotDesign.model;

import java.util.List;

public class TwoWheelerManager extends ParkingSpotManager{

    public TwoWheelerManager(List<ParkingSpot> spots){
        super(spots);
    }

    @Override
    public ParkingSpot findParkingSpace() {
       return getParkingSpots().stream().filter(ParkingSpot::isAvailable)
        .findFirst().orElseThrow(()-> new IllegalStateException("No Available two wheeler parking spots"));
    }

}
