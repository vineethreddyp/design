package entity;

import enums.ParkingSpotType;

public class Vehicle {
  private String vehicleNumber;
  private ParkingTicket parkingTicket;
  private ParkingSpotType vehicleType;

  public Vehicle(String vehicleNumber, ParkingSpotType vehicleType){
    this.vehicleNumber = vehicleNumber;
    this.vehicleType = vehicleType;
  }

  public void setParkingTicket(ParkingTicket parkingTicket) {
    this.parkingTicket = parkingTicket;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }

  public ParkingTicket getParkingTicket() {
    return parkingTicket;
  }

  public ParkingSpotType getVehicleType() {
    return vehicleType;
  }
}
