package states;

import impl.Lane;
import interfaces.Player;
import interfaces.State;

public class LaneIdle implements State {

  private Lane lane;

  public LaneIdle(Lane lane){
    this.lane = lane;
  }

  @Override
  public void addPlayer(Player player) {
    lane.getPlayerList().add(player);
  }

  @Override
  public void bowl() {
    System.out.println("Invalid operation");
  }


  @Override
  public void startGame() {
    lane.setCurrentState(lane.getOnGoingState());
  }

  @Override
  public void reset() {
    System.out.println("Already Idle");
  }
}
