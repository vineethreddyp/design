package entity;


import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

  private String name;
  private String address;
  private List<ParkingFloor> parkingFloorList;
  private List<EntryPoint> entryPoints;
  private List<ExitPoint> exitPoints;
  private String displayBoard;

  public ParkingLot(String name, String address){
    this.name = name;
    this.address = address;
    this.parkingFloorList = new ArrayList<>();
    this.entryPoints = new ArrayList<>();
    this.exitPoints = new ArrayList<>();
  }

  public void updateDisplayBoard(){

    // TODO fix this procedure
    for(ParkingFloor parkingFloor : parkingFloorList){

      for(ParkingSpot parkingSpot : parkingFloor.getParkingSpotList()){

        if(parkingSpot.isFree()){

          if(parkingSpot instanceof ElectricSpot){

          }


        }

        if(parkingSpot.getClass().equals(ElectricSpot.class)){

        }

      }

    }
  }

  public List<ParkingFloor> getParkingFloorList() {
    return parkingFloorList;
  }

  public List<EntryPoint> getEntryPoints() {
    return entryPoints;
  }

  public List<ExitPoint> getExitPoints() {
    return exitPoints;
  }

  public String getDisplayBoard() {
    return displayBoard;
  }
}
