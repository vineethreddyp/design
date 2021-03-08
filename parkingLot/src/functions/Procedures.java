package functions;

import entity.CustomerInfoPortal;
import entity.EntryPoint;
import entity.ExitPoint;
import entity.ParkingLot;
import entity.ParkingSpot;
import entity.Vehicle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Procedures {


  private static  Map<String, ParkingSpot> parkedVehicleList;

  static {
    parkedVehicleList = new HashMap<>();
  }

  public static void sendAVehicleIntoParkingLot(ParkingLot parkingLot, Vehicle vehicle) {
    EntryPoint oneEntryPoint = parkingLot.getEntryPoints().get(0); // assume one entryPoint
    oneEntryPoint.printTicket(vehicle);
    //assign free spot to a vehicle
    assignVehicleASpot(parkingLot,vehicle);
  }

  private static void assignVehicleASpot(ParkingLot parkingLot, Vehicle vehicle) {
    List<ParkingSpot> parkingSpotList = parkingLot.getParkingFloorList().get(0).getParkingSpotList();
    ParkingSpot freeParkingSpot  = getFreeOne(parkingSpotList);
    freeParkingSpot.assignVehicle(vehicle);
    parkedVehicleList.put(vehicle.getVehicleNumber(), freeParkingSpot);
  }

  private static void updateParkedVehicleMap(Vehicle vehicle) {
    parkedVehicleList.get(vehicle.getVehicleNumber()).removeVehicle();
  }

  private static ParkingSpot getFreeOne(List<ParkingSpot> parkingSpotList) {
    for(ParkingSpot parkingSpot : parkingSpotList){
      if(parkingSpot.isFree())
        return parkingSpot;
    }
    return null;
  }

  public static void sendAVehicleOutOfParkingLot(ParkingLot parkingLot, Vehicle vehicle) {
    // stayed there for an hour then try to exit
    ExitPoint exitPoint = parkingLot.getExitPoints().get(0);
    Double amountToBePaid =  exitPoint.scanTicket(vehicle.getParkingTicket());
    exitPoint.processPayment(vehicle.getParkingTicket(),amountToBePaid);
    updateParkedVehicleMap(vehicle);
    System.out.println("vehicle : " + vehicle.getVehicleNumber() + " moved out of parking lot");
    // vehicle exited outside
  }

  public static void sendAVehicleOutOfParkingLotUsingCustomerPotal(ParkingLot parkingLot, Vehicle vehicle) {
    CustomerInfoPortal customerInfoPortal = parkingLot.getParkingFloorList().get(0).getCustomerInfoPortalList().get(0);
    customerInfoPortal.processPayment(vehicle.getParkingTicket(),100.0);
    ExitPoint exitPoint = parkingLot.getExitPoints().get(0);
    Double amountToBePaid =  exitPoint.scanTicket(vehicle.getParkingTicket());
    exitPoint.processPayment(vehicle.getParkingTicket(),amountToBePaid);
    updateParkedVehicleMap(vehicle);
    System.out.println("vehicle : " + vehicle.getVehicleNumber() + " moved out of parking lot");
  }
}
