package entity;

import impl.NormalScoreType;
import impl.SpareScoreType;
import impl.StrikeScoreType;
import interfaces.Set;
import java.util.ArrayList;
import java.util.List;

public class FinalSet implements Set {

  private boolean isComplete;
  private List<Trail> trailList;

  public FinalSet(){
    this.isComplete = false;
    this.trailList = new ArrayList<>();
  }

  @Override
  public boolean isComplete() {
    return isComplete;
  }

  @Override
  public void bowled(Integer pinsHit) {
    int maxBalls = 10;
    int trailCount = trailList.size();
    switch (trailCount){
      case 0:
        if(pinsHit.equals(maxBalls)){
          trailList.add(new Trail(pinsHit, new StrikeScoreType()));
          return;
        }
        else {
          trailList.add(new Trail(pinsHit, new NormalScoreType()));
        }
      case 1:
        int alreadyHitPins = trailList.get(0).getPinsHit();
        if(alreadyHitPins == maxBalls){
          if(pinsHit.equals(maxBalls)){
            trailList.add(new Trail(pinsHit, new StrikeScoreType()));
            return;
          }
        }
        else {

          if(alreadyHitPins + pinsHit == maxBalls){
            trailList.add(new Trail(pinsHit, new SpareScoreType()));
          }
          else {
            trailList.add(new Trail(pinsHit, new NormalScoreType()));
            isComplete = true;
          }
        }
        return;

      case 2:
        if(pinsHit.equals(maxBalls)){
          trailList.add(new Trail(pinsHit, new StrikeScoreType()));
          return;
        }
        else {
          trailList.add(new Trail(pinsHit, new StrikeScoreType()));
        }
        isComplete = true;
    }


  }

  @Override
  public Integer getScore() {
    int finalScore = 0;
    for(Trail trail : trailList){
      finalScore = finalScore  + trail.getScore();
    }
    return finalScore;
  }

  @Override
  public List<Trail> getTrailList() {
    return trailList;
  }


}
