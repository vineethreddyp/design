package entity;

import enums.ParkingSpotType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DisplayBoard {
  private Map<ParkingSpotType, Integer> freeParkingSpot;

  public DisplayBoard(){
    freeParkingSpot = new HashMap<>();
    ParkingSpotType parkingSpotTypeValues[] = ParkingSpotType.values();
    for(ParkingSpotType parkingSpotType : parkingSpotTypeValues){
      freeParkingSpot.put(parkingSpotType,0);
    }
  }

  public Map<ParkingSpotType, Integer> getFreeParkingSpot() {
    return freeParkingSpot;
  }

  public void decrementParkingSpot(ParkingSpotType parkingSpotType){
    Integer val = this.freeParkingSpot.get(parkingSpotType);
    freeParkingSpot.put(parkingSpotType, val-1);
  }

  public void incrementParkingSpot(ParkingSpotType parkingSpotType){
    Integer val = this.freeParkingSpot.get(parkingSpotType);
    freeParkingSpot.put(parkingSpotType, val+1);
  }


  public String getDisplayMessage() {
    Set<ParkingSpotType> spotTypeSet = freeParkingSpot.keySet();
    String displayMessage = "";
    for(ParkingSpotType parkingSpotType : spotTypeSet){
      displayMessage = displayMessage.concat( parkingSpotType + " free spots: " + freeParkingSpot.get(parkingSpotType) + " \n");
    }
    return displayMessage;
  }
}
