package entity;

public class ParkingSpot {
  private boolean isFree;
  private Vehicle vehicle;
//  private ParkingSpotType parkingSpotType; check if has to be written

  public ParkingSpot(){
    this.isFree = true;
  }

  public void assignVehicle(Vehicle vehicle){
    System.out.println("Parking spot assigned to vehicle " + vehicle.getVehicleNumber());
    this.isFree = false;
    this.vehicle = vehicle;
  }

  public boolean isFree() {
    return isFree;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void removeVehicle() {
    this.isFree = true;
    this.vehicle = null;
  }
}
