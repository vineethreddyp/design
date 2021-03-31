package entity;

import impl.NormalScoreType;
import impl.SpareScoreType;
import impl.StrikeScoreType;
import interfaces.Score;
import interfaces.Set;
import java.util.ArrayList;
import java.util.List;

public class NormalSet implements Score, Set {

  private boolean isComplete;
  private List<Trail> trailList;

  public NormalSet(){
    this.isComplete = false;
    this.trailList = new ArrayList<>();
  }

  @Override
  public Integer getScore() {
    Integer score = 0;
    for(Trail trail : trailList){
      score = score + trail.getScore();
    }
    return score;
  }

  @Override
  public List<Trail> getTrailList() {
    return trailList;
  }

  @Override
  public boolean isComplete() {
    return isComplete;
  }

  @Override
  public void bowled(Integer pinsHit) {
    Integer maxBalls = 10;
    if(pinsHit.equals(maxBalls)){
      trailList.add(new Trail(pinsHit, new StrikeScoreType()));
      isComplete = true;
      return;
    }

    Integer totalHits = 0;
    for(Trail trail : trailList){
      totalHits = totalHits  + trail.getScore();
    }

    if(totalHits + pinsHit == maxBalls){
      trailList.add(new Trail(pinsHit, new SpareScoreType()));
      isComplete = true;
    }
    else {
      trailList.add(new Trail(pinsHit, new NormalScoreType()));
    }

    if(trailList.size() == 2){
      isComplete = true;
    }



  }
}
