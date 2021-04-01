package states;

import impl.Lane;
import interfaces.Player;
import interfaces.LaneState;

public class LaneSetting implements LaneState {

  private Lane lane;

  public LaneSetting(Lane lane){
    this.lane = lane;
  }

  @Override
  public void addPlayer(Player player) {
    System.out.println("Invalid operation.");
  }

  @Override
  public void bowl() {
    System.out.println("Invalid operation.");
  }


  @Override
  public void startGame() {
    System.out.println("Invalid operation.");
  }

  @Override
  public void reset() {
    System.out.println("Invalid operation.");
  }
}
