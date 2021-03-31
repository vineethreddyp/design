package impl;

import interfaces.Player;
import interfaces.Set;
import java.util.List;

public class PlayerImpl implements Player {

  private List<Set> setList;
  private Integer activeSetNumber;
  private boolean isTurnComplete;
  private String name;

  public PlayerImpl(String name, List<Set> setList){
    this.setList = setList;
    activeSetNumber = 0;
    this.name = name;
  }

  @Override
  public void bowlRolled(Integer pinsHit) {
    Set activeSet = setList.get(this.activeSetNumber);
    activeSet.bowled(pinsHit);
    isTurnComplete = activeSet.isComplete();
    if(isTurnComplete)
      activeSetNumber++;
  }

  @Override
  public int getScore() {
    int finalScore = 0;
    for (Set set : setList){
      finalScore = finalScore + set.getScore();
    }
    return finalScore;
  }

  @Override
  public boolean isTurnComplete() {
    return isTurnComplete;
  }

  @Override
  public boolean allSetCompleted() {
    return setList.get(setList.size()-1).isComplete();
  }

  @Override
  public List<Set> getSetList() {
    return setList;
  }

  @Override
  public String getName() {
    return name;
  }
}
