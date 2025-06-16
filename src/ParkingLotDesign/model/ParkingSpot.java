package ParkingLotDesign.model;

public class ParkingSpot {

    private final int id;
    private Vehicle vehicle;
    private boolean isOccupied;
    private final int price;
    private final VehicleType supportedType;

    public ParkingSpot(int id, int price, VehicleType supportedType) {
        this.id = id;
        this.price = price;
        this.supportedType = supportedType;
    }


    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }

    public void assignVehicle(Vehicle vehicle){
        if(!isAvailable()){
            throw  new IllegalStateException("ParkingSpt is filled. Vehicle cannot be assigned ");
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle(){
        if(isAvailable()){
            throw new IllegalStateException("Vehicle cannot be removed,Parking Spot is empty.");
        }

        this.vehicle = null;
        isOccupied = false;
    }

    public VehicleType getSupportedType() {
        return supportedType;
    }
}
