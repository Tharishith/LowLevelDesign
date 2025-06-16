package ParkingLotDesign.model;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingSpotManagerFactory {
    public static ParkingSpotManager getParkingSpot(List<ParkingSpot> parkingSpotList,VehicleType vehicleType){

        List<ParkingSpot> filtered = parkingSpotList.stream()
                .filter(s-> s.isAvailable() && s.getSupportedType() == vehicleType)
                .collect(Collectors.toList());

        if(VehicleType.TWO_WHEELER.equals(vehicleType)){
            return new TwoWheelerManager(filtered);
        }
        else if(VehicleType.FOUR_WHEELER.equals(vehicleType)){
            return new FourWheelerManager(filtered);
        }
        else{
            throw new IllegalStateException("Unknown vehicle Type");
        }

    }
}
