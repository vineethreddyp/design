package states;

import impl.Lane;
import interfaces.Player;
import interfaces.LaneState;
import java.security.SecureRandom;
import java.util.Random;

public class LaneOnGoing implements LaneState {

  private Lane lane;
  private Random random;

  public LaneOnGoing(Lane lane){
    this.lane = lane;
    random = new SecureRandom();
  }

  @Override
  public void addPlayer(Player player) {
    System.out.println("Invalid operation");
  }

  @Override
  public void bowl() {
    Integer playerActive = lane.getPlayerActive();
    Player activePlayer = lane.getPlayerList().get(playerActive);
    Integer pinsHit = random.nextInt(lane.getPinsPresent() +1);
    activePlayer.bowlRolled(pinsHit);
    lane.setPins(lane.getPinsPresent()-pinsHit);
    lane.notifyObservers();
    if(activePlayer.isTurnComplete()){
      lane.nextPlayer();
      lane.setCurrentState(lane.getSettingState());
    }
    else if(lane.getPinsPresent() == 0){
      lane.setCurrentState(lane.getSettingState());
    }

    if(lane.completed()){
      lane.setCurrentState(lane.getCompletedState());
    }
  }

  @Override
  public void startGame() {
    System.out.println("Game is ongoing already. Cannot start now");
  }

  @Override
  public void reset() {
    lane.resetPinsPlayers();
  }

}
