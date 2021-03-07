package entity;

public class Vehicle {
  private String vehicleNumber;
  private ParkingTicket parkingTicket;

  public Vehicle(String vehicleNumber){
    this.vehicleNumber = vehicleNumber;
  }

  public void setParkingTicket(ParkingTicket parkingTicket) {
    this.parkingTicket = parkingTicket;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }
}
