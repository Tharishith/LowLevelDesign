package ParkingLotDesign.service;

import ParkingLotDesign.model.Ticket;
import ParkingLotDesign.model.Vehicle;

import java.util.Optional;

public interface EntranceGate {

    Optional<Ticket> generateTicket(Vehicle vehicle);
}
