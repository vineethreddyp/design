package entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
  private String name;
  private List<ParkingSpot> parkingSpotList;

  public ParkingFloor(String name){
    this.name = name;
    this.parkingSpotList = new ArrayList<>();
  }

  public void removeParkingSpot(String name){
    // remove by name after searching in list
  }

  public String getName() {
    return name;
  }

  public List<ParkingSpot> getParkingSpotList() {
    return parkingSpotList;
  }

  public String displayBoard(){
    // TODO write function here
    return "";
  }
}
