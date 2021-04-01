package states;

import impl.Lane;
import interfaces.LaneState;
import interfaces.Player;

public class LaneCompleted implements LaneState {

  private Lane lane;

  public LaneCompleted(Lane lane){
    this.lane = lane;
  }

  @Override
  public void addPlayer(Player player) {
    System.out.println("Invalid operation. Player cannot be added.");
  }

  @Override
  public void bowl() {
    System.out.println("Invalid operation.");
  }

  @Override
  public void startGame() {
    // use to start game again.
    System.out.println("Invalid operation. Reset the game.");
  }

  @Override
  public void reset() {
    lane.reset();
    lane.setCurrentState(lane.getIdleState());
  }
}
