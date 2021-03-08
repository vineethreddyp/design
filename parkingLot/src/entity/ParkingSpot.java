package entity;

import enums.ParkingSpotType;

public class ParkingSpot {
  private boolean isFree;
  private Vehicle vehicle;
  private ParkingSpotType parkingSpotType;

  public ParkingSpot(ParkingSpotType parkingSpotType){
    this.isFree = true;
    this.parkingSpotType = parkingSpotType;
  }

  public void assignVehicle(ParkingSpotType parkingSpotType, Vehicle vehicle){
    System.out.println("Parking spot " +  parkingSpotType + " assigned to vehicle " + vehicle.getVehicleNumber());
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

  public ParkingSpotType getParkingSpotType() {
    return parkingSpotType;
  }
}
