package entity;

import enums.ParkingSpotType;
import java.util.List;
import java.util.Map;

public class Admin extends User {

  // more method functions in admin
  // add parking floor

  public void addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor){
    parkingLot.getParkingFloorList().add(parkingFloor);
    List<ParkingSpot> parkingSpotList = parkingFloor.getParkingSpotList();
    for(ParkingSpot parkingSpot : parkingSpotList){
     incrementDisplayBoardSpot(parkingLot.getDisplayBoard(),parkingSpot);
    }
  }

  public void addEntryPoint(ParkingLot parkingLot, EntryPoint entryPoint){
    parkingLot.getEntryPoints().add(entryPoint);
  }

  public void addExitPoint(ParkingLot parkingLot, ExitPoint exitPoint){
    parkingLot.getExitPoints().add(exitPoint);
  }

  public void removeEntryPoint(String name){

  }

  public void removeExitPoint(String name){

  }

  public void addParkingSpot(ParkingFloor parkingFloor, ParkingSpot parkingSpot) {
    parkingFloor.getParkingSpotList().add(parkingSpot);
    incrementDisplayBoardSpot(parkingFloor.getDisplayBoard(),parkingSpot);
  }
  private void incrementDisplayBoardSpot(DisplayBoard displayBoard, ParkingSpot parkingSpot){
    Map<ParkingSpotType, Integer> freeParkingSpot = displayBoard.getFreeParkingSpot();
    Integer val = freeParkingSpot.get(parkingSpot.getParkingSpotType());
    freeParkingSpot.put(parkingSpot.getParkingSpotType(), val+1);
  }

  public void addCustomerPotal(ParkingFloor parkingFloor, CustomerInfoPortal customerInfoPortal) {
    parkingFloor.getCustomerInfoPortalList().add(customerInfoPortal);
  }

}
