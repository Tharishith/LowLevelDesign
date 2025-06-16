package ParkingLotDesign.service;

import ParkingLotDesign.model.ParkingSpot;
import ParkingLotDesign.model.Ticket;


import java.time.Duration;
import java.time.LocalDateTime;

public class ExitGateImpl implements ExitGate{


    @Override
    public long calculatePrice(Ticket ticket) {

        LocalDateTime exitTime = LocalDateTime.now();
        LocalDateTime entryTime = ticket.getEntryTime();
        long durationHours = Duration.between(exitTime,entryTime).toHours();
        if(durationHours == 0)
            durationHours = 1;

        long price = ticket.getParkingSpot().getPrice()*durationHours;

        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.removeVehicle();
        return price;
    }
}
