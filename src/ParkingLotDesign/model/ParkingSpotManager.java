package ParkingLotDesign.model;

import java.util.List;

public abstract class ParkingSpotManager {

    List<ParkingSpot> parkingSpotList;

    public ParkingSpotManager(List<ParkingSpot> parkingSpotList){
        this.parkingSpotList = parkingSpotList;
    }

    public abstract ParkingSpot findParkingSpace();

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot = findParkingSpace();
        spot.assignVehicle(vehicle);
        return spot;
    }

    public void removeVehicle(Vehicle vehicle){

        for (ParkingSpot spot : parkingSpotList)
            if (spot != null && spot.equals(vehicle)) {
                spot.removeVehicle();
                break;
            }

    }

    protected List<ParkingSpot> getParkingSpots(){
        return parkingSpotList;
    }
}