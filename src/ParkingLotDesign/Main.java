package ParkingLotDesign;

import ParkingLotDesign.model.ParkingSpot;
import ParkingLotDesign.model.Ticket;
import ParkingLotDesign.model.Vehicle;
import ParkingLotDesign.model.VehicleType;
import ParkingLotDesign.service.EntranceGate;
import ParkingLotDesign.service.EntranceGateImpl;
import ParkingLotDesign.service.ExitGate;
import ParkingLotDesign.service.ExitGateImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        List<ParkingSpot> spotList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            spotList.add(new ParkingSpot(i, 20, VehicleType.TWO_WHEELER));
        }

        for (int i = 4; i <= 6; i++) {
            spotList.add(new ParkingSpot(i, 50, VehicleType.FOUR_WHEELER));
        }

        EntranceGate entranceGate = new EntranceGateImpl(spotList);

        Vehicle bike = new Vehicle(VehicleType.TWO_WHEELER, "KA-01-AB-1234");
        Vehicle car = new Vehicle(VehicleType.FOUR_WHEELER, "KA-01-CD-5678");

        Optional<Ticket> bikeTicket = entranceGate.generateTicket(bike);
        Optional<Ticket> carTicket = entranceGate.generateTicket(car);

        bikeTicket.ifPresent(ticket -> {
            System.out.println("Bike parked at spot: " + ticket.getParkingSpot());
        });

        carTicket.ifPresent(ticket -> {
            System.out.println("Car is parked at spot : "+ ticket.getParkingSpot());
        });

        ExitGate exitGate = new ExitGateImpl();

        Thread.sleep(1000);

        bikeTicket.ifPresent(ticket -> {
            long price = exitGate.calculatePrice(ticket);
            System.out.println("Bike exited. Price: ₹" + price);
        });

        carTicket.ifPresent(ticket -> {
            long price = exitGate.calculatePrice(ticket);
            System.out.println("Car exited. Price: ₹" + price);
        });

    }

}
