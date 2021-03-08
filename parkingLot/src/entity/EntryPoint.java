package entity;

public class EntryPoint {

  private String name;

  public EntryPoint(String name){
    this.name = name;
  }
  // print ticket func

  public ParkingTicket printTicket(Vehicle vehicle){
    ParkingTicket parkingTicket = new ParkingTicket();
    System.out.println("New parking ticket printed : " + parkingTicket.getTicketNumber());
    vehicle.setParkingTicket(parkingTicket);
    System.out.println("Parking ticket :" + parkingTicket.getTicketNumber() + " assigned to vehicle " +  vehicle.getVehicleNumber());
    return parkingTicket;
  }

}
