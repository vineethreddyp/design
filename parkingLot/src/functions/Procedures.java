package functions;

import entity.CustomerInfoPortal;
import entity.ElectricSpot;
import entity.EntryPoint;
import entity.ExitPoint;
import entity.ParkingFloor;
import entity.ParkingLot;
import entity.ParkingSpot;
import entity.Vehicle;
import enums.ParkingSpotType;
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
    if(vehicle.getVehicleType().equals(ParkingSpotType.Electric)){
      // charge vehicle if electric
      ElectricSpot electricSpot = (ElectricSpot) parkedVehicleList.get(vehicle.getVehicleNumber());
      electricSpot.plugCharging(50.0);
    }
    System.out.println("Parking Lot display board : " + parkingLot.getDisplayBoard().getDisplayMessage());
  }

  private static void assignVehicleASpot(ParkingLot parkingLot, Vehicle vehicle) {
    ParkingFloor parkingFloor = parkingLot.getParkingFloorList().get(0);
    List<ParkingSpot> parkingSpotList = parkingFloor.getParkingSpotList();
    ParkingSpot freeParkingSpot  = getFreeOne(parkingSpotList, vehicle.getVehicleType());
    freeParkingSpot.assignVehicle(freeParkingSpot.getParkingSpotType(),vehicle);
    parkingFloor.getDisplayBoard().decrementParkingSpot(freeParkingSpot.getParkingSpotType());
    parkingLot.getDisplayBoard().decrementParkingSpot(freeParkingSpot.getParkingSpotType());
    parkedVehicleList.put(vehicle.getVehicleNumber(), freeParkingSpot);
  }

  private static void updateParkedVehicleMap(ParkingLot parkingLot, Vehicle vehicle) {
    // assuming floor is give already
    parkingLot.getDisplayBoard().incrementParkingSpot(parkedVehicleList.get(vehicle.getVehicleNumber()).getParkingSpotType());
    parkedVehicleList.get(vehicle.getVehicleNumber()).removeVehicle();
  }

  private static ParkingSpot getFreeOne(List<ParkingSpot> parkingSpotList, ParkingSpotType parkingSpotType) {
    for(ParkingSpot parkingSpot : parkingSpotList){
      if(parkingSpot.isFree() && parkingSpot.getParkingSpotType().equals(parkingSpotType))
        return parkingSpot;
    }
    return null;
  }

  public static void sendAVehicleOutOfParkingLot(ParkingLot parkingLot, Vehicle vehicle) {
    // stayed there for an hour then try to exit
    ExitPoint exitPoint = parkingLot.getExitPoints().get(0);
    Double amountToBePaid =  exitPoint.scanTicket(vehicle.getParkingTicket());
    exitPoint.processPayment(vehicle.getParkingTicket(),amountToBePaid);
    updateParkedVehicleMap(parkingLot,vehicle);
    System.out.println("vehicle : " + vehicle.getVehicleNumber() + " moved out of parking lot");
    System.out.println("Parking Lot display board : " + parkingLot.getDisplayBoard().getDisplayMessage());
    // vehicle exited outside
  }

  public static void sendAVehicleOutOfParkingLotUsingCustomerPotal(ParkingLot parkingLot, Vehicle vehicle) {
    CustomerInfoPortal customerInfoPortal = parkingLot.getParkingFloorList().get(0).getCustomerInfoPortalList().get(0);
    customerInfoPortal.processPayment(vehicle.getParkingTicket(),100.0);
    ExitPoint exitPoint = parkingLot.getExitPoints().get(0);
    Double amountToBePaid =  exitPoint.scanTicket(vehicle.getParkingTicket());
    exitPoint.processPayment(vehicle.getParkingTicket(),amountToBePaid);
    updateParkedVehicleMap(parkingLot,vehicle);
    System.out.println("vehicle : " + vehicle.getVehicleNumber() + " moved out of parking lot");
    System.out.println("Parking Lot display board : " + parkingLot.getDisplayBoard().getDisplayMessage());

  }
}
