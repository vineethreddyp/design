package states;

import impl.Lane;
import interfaces.Player;
import interfaces.State;

public class LaneSetting implements State {

  private Lane lane;

  public LaneSetting(Lane lane){
    this.lane = lane;
  }

  @Override
  public void addPlayer(Player player) {

  }

  @Override
  public void bowl() {

  }


  @Override
  public void startGame() {

  }

  @Override
  public void reset() {

  }
}
