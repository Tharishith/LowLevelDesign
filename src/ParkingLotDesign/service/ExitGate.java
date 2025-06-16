package ParkingLotDesign.service;

import ParkingLotDesign.model.Ticket;
import ParkingLotDesign.model.Vehicle;

public interface ExitGate {

    long calculatePrice(Ticket ticket);

}
