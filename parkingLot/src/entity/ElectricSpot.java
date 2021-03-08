package entity;

import enums.ParkingSpotType;
import java.time.LocalDateTime;

public class ElectricSpot extends ParkingSpot {

  private Payment payment;
  private LocalDateTime chargingStartTime;
  private LocalDateTime chargingEndTime;

  public ElectricSpot(){
    super(ParkingSpotType.Electric);
  }

  public void plugCharging(Double amount){
    chargingStartTime = LocalDateTime.now();
    chargingEndTime = LocalDateTime.now().plusHours(1);
    // charging start time and end time will be used by system to power the charging cable
    payment = new Payment(amount);
    System.out.println("Started Charging vehicle "+ this.getVehicle().getVehicleNumber() + ". Vehicle will be charged for : 1 hour" ) ;
  }

}
