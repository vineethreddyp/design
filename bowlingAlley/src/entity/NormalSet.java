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
  private int maxPins;

  public NormalSet(int maxPins){
    this.isComplete = false;
    this.trailList = new ArrayList<>();
    this.maxPins = maxPins;
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

    int trailCount = trailList.size();
    switch (trailCount){
      case 0:
        if(pinsHit.equals(maxPins)){
          trailList.add(new Trail(pinsHit, new StrikeScoreType()));
          isComplete = true;
        }
        else {
          trailList.add(new Trail(pinsHit, new NormalScoreType()));
        }
        break;

      case 1:
        int alreadyHitPins = trailList.get(0).getPinsHit();
        if(alreadyHitPins + pinsHit == maxPins){
          trailList.add(new Trail(pinsHit, new SpareScoreType()));
        }
        else {
          trailList.add(new Trail(pinsHit, new NormalScoreType()));
        }
        isComplete = true;
        break;

      default:
        System.out.println("Exception here");
    }

  }


}
