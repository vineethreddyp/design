package states;

import impl.Lane;
import interfaces.Player;
import interfaces.LaneState;

public class LaneIdle implements LaneState {

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
    System.out.println("Invalid operation. Please start the game");
  }


  @Override
  public void startGame() {
    lane.setCurrentState(lane.getOnGoingState());
    System.out.println("Started Game in Lane: " + lane.getName());
  }

  @Override
  public void reset() {
    lane.resetPinsPlayers();
  }
}
