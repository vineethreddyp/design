package states;

import impl.Lane;
import interfaces.Player;
import interfaces.State;
import java.security.SecureRandom;
import java.util.Random;

public class LaneOnGoing implements State {

  private Lane lane;
  private Random random;
  private Integer playerActive;

  public LaneOnGoing(Lane lane){
    this.lane = lane;
    random = new SecureRandom();
    playerActive = 0;

  }

  @Override
  public void addPlayer(Player player) {
    System.out.println("Invalid operation");
  }

  @Override
  public void bowl() {
    Player activePlayer = lane.getPlayerList().get(playerActive);
    Integer pinsHit = random.nextInt(lane.getPinsPresent() +1);
    activePlayer.bowlRolled(pinsHit);
    lane.setPins(lane.getPinsPresent()-pinsHit);
    lane.notifyObservers();
    if(activePlayer.isTurnComplete()){
      playerActive = (playerActive + 1)%lane.getPlayerList().size();
      lane.setCurrentState(lane.getSettingState());
    }
    else if(lane.getPinsPresent() == 0){
      lane.setCurrentState(lane.getSettingState());
    }
  }

  @Override
  public void startGame() {
    System.out.println("Game is ongoing already. Cannot start now");
  }

  @Override
  public void reset() {
    lane.reset();
    lane.setCurrentState(lane.getIdleState());
  }

}
