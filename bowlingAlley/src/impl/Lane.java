package impl;

import interfaces.Diplay;
import interfaces.Player;
import interfaces.LaneState;
import java.util.ArrayList;
import java.util.List;
import states.LaneCompleted;
import states.LaneIdle;
import states.LaneOnGoing;
import states.LaneSetting;

public class Lane {

  private List<Diplay> displayList;
  private String name;
  private LaneState idleState;
  private LaneState onGoingState;
  private LaneState currentState;
  private LaneState settingState;
  private LaneState completedState;
  private Integer pinsPresent;
  private Integer maxPins;
  private List<Player> playerList;
  private Integer playerActive;


  public Lane(String name,Integer maxPins){
    this.maxPins = maxPins;
    this.name = name;
    playerList = new ArrayList<>();
    idleState =  new LaneIdle(this);
    onGoingState = new LaneOnGoing(this);
    settingState = new LaneSetting(this);
    completedState = new LaneCompleted(this);
    pinsPresent = maxPins;
    displayList = new ArrayList<>();
    currentState = idleState;
    playerActive = 0;
  }

  public String getName() {
    return name;
  }

  public LaneState getIdleState() {
    return idleState;
  }

  public LaneState getOnGoingState() {
    return onGoingState;
  }

  public LaneState getSettingState() {
    return settingState;
  }

  public LaneState getCompletedState() {
    return completedState;
  }

  public void resetPins() {
    System.out.println("Resetting pins");
    pinsPresent = maxPins;
  }

  public Integer getMaxPins() {
    return maxPins;
  }

  public Integer getPinsPresent() {
    return pinsPresent;
  }

  public void setPins(Integer pins){
    pinsPresent = pins;
  }

  public void setCurrentState(LaneState currentState) {
    this.currentState = currentState;
    if(currentState.equals(settingState)){
      resetPins(); // hack here
      this.currentState = onGoingState;
    }
  }

  public void addPlayer(Player player) {
    currentState.addPlayer(player);
  }

  public Integer getPlayerActive() {
    return playerActive;
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
    currentState.reset();
  }

  public void resetPinsPlayers(){
    System.out.println("Lane " + name + " Reset Complete");
    pinsPresent = maxPins;
    playerList = new ArrayList<>();
    currentState = idleState;
  }

  public void nextPlayer() {
    playerActive = (playerActive + 1)%playerList.size();
  }
}
