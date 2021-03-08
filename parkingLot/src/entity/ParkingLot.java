package entity;


import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

  private String name;
  private String address;
  private List<ParkingFloor> parkingFloorList;
  private List<EntryPoint> entryPoints;
  private List<ExitPoint> exitPoints;
  private DisplayBoard displayBoard;

  public ParkingLot(String name, String address){
    this.name = name;
    this.address = address;
    this.parkingFloorList = new ArrayList<>();
    this.entryPoints = new ArrayList<>();
    this.exitPoints = new ArrayList<>();
    this.displayBoard = new DisplayBoard();
  }

  public DisplayBoard getDisplayBoard() {
    return displayBoard;
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
}
