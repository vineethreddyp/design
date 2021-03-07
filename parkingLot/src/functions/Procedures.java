package functions;

import entity.EntryPoint;
import entity.ExitPoint;
import entity.ParkingLot;
import entity.ParkingSpot;
import entity.ParkingTicket;
import entity.Vehicle;
import java.util.List;

public class Procedures {

  public static void sendAVehicleIntoParkingLot(ParkingLot parkingLot, Vehicle vehicle) {
    EntryPoint oneEntryPoint = parkingLot.getEntryPoints().get(0); // assume one entryPoint
    ParkingTicket myParkingTicket = oneEntryPoint.printTicket(vehicle);
    List<ParkingSpot> parkingSpotList = parkingLot.getParkingFloorList().get(0).getParkingSpotList();
    ParkingSpot freeParkingSpot  = getFreeOne(parkingSpotList);
    freeParkingSpot.assignVehicle(vehicle);
    // stayed there for an hour then try to exit
    ExitPoint exitPoint = parkingLot.getExitPoints().get(0);
    Double amountToBePaid =  exitPoint.scanTicket(myParkingTicket);
    exitPoint.processPayment(myParkingTicket,amountToBePaid);
    // vehicle exited outside
  }

  private static ParkingSpot getFreeOne(List<ParkingSpot> parkingSpotList) {
    for(ParkingSpot parkingSpot : parkingSpotList){
      if(parkingSpot.isFree())
        return parkingSpot;
    }
    return null;
  }
}
