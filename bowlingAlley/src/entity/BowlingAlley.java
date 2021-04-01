package entity;

import impl.Lane;
import java.util.ArrayList;
import java.util.List;

public class BowlingAlley {

  List<Lane> laneList;

  public BowlingAlley(){
    laneList = new ArrayList<>();
  }

  public List<Lane> getLaneList() {
    return laneList;
  }

  public void addLane(Lane lane){
    laneList.add(lane);
  }
}
