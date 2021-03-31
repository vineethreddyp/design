package impl;

import interfaces.Diplay;
import interfaces.Player;
import interfaces.State;
import java.util.ArrayList;
import java.util.List;
import states.LaneIdle;
import states.LaneOnGoing;
import states.LaneSetting;

public class Lane {

  private List<Diplay> displayList;
  private State idleState;
  private State onGoingState;
  private State currentState;
  private State settingState;
  private Integer pinsPresent;
  private List<Player> playerList;

  public State getIdleState() {
    return idleState;
  }

  public State getOnGoingState() {
    return onGoingState;
  }

  public State getSettingState() {
    return settingState;
  }

  public void resetPins() {
    System.out.println("Resetting pins");
    pinsPresent = 10;
  }

  public Integer getPinsPresent() {
    return pinsPresent;
  }

  public void setPins(Integer pins){
    pinsPresent = pins;
  }

  public Lane(){
    playerList = new ArrayList<>();
    idleState =  new LaneIdle(this);
    onGoingState = new LaneOnGoing(this);
    settingState = new LaneSetting(this);
    pinsPresent = 10;
    displayList = new ArrayList<>();
    currentState = idleState;
  }

  public void setCurrentState(State currentState) {
    this.currentState = currentState;
    if(currentState.equals(settingState)){
      resetPins(); // hack here
      this.currentState = onGoingState;
    }
  }

  public void addPlayer(Player player) {
    currentState.addPlayer(player);
  }

  public void startGame(){
    currentState.startGame();
  }


  public void registerDisplay(Diplay diplay){
    displayList.add(diplay);
  }

  public List<Player> getPlayerList() {
    return playerList;
  }

  public void bowl() {
    currentState.bowl();
  }

  public boolean completed() {
    return (playerList.get(playerList.size()-1).allSetCompleted());
  }

  public void notifyObservers() {
    displayList.forEach(display -> display.update(this));
  }

  public void reset(){
    pinsPresent = 10;
    playerList = new ArrayList<>();
  }

}
