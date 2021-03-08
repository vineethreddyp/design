package entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
  private String name;
  private List<ParkingSpot> parkingSpotList;
  private List<CustomerInfoPortal> customerInfoPortalList;
  private DisplayBoard displayBoard;

  public ParkingFloor(String name){
    this.name = name;
    this.parkingSpotList = new ArrayList<>();
    this.customerInfoPortalList = new ArrayList<>();
    this.displayBoard = new DisplayBoard();
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

  public DisplayBoard getDisplayBoard() {
    return displayBoard;
  }

  public List<CustomerInfoPortal> getCustomerInfoPortalList() {
    return customerInfoPortalList;
  }

}
