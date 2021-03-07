package entity;

public class Admin extends User {

  // more method functions in admin
  // add parking floor

  public void addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor){
    parkingLot.getParkingFloorList().add(parkingFloor);
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

  public void addParkingSpot(ParkingFloor parkingFloor, ParkingSpot parkingSpot){
    parkingFloor.getParkingSpotList().add(parkingSpot);
  }
}