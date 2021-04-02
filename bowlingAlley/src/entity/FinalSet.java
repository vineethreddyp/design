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
  private int maxPins;

  public FinalSet(int maxPins){
    this.isComplete = false;
    this.trailList = new ArrayList<>();
    this.maxPins = maxPins;
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
        }
        else {
          trailList.add(new Trail(pinsHit, new NormalScoreType()));
        }
        break;

      case 1:
        int alreadyHitPins = trailList.get(0).getPinsHit();
        if(alreadyHitPins == maxPins){
          if(pinsHit.equals(maxPins)){
            trailList.add(new Trail(pinsHit, new StrikeScoreType()));
            return;
          }
        }
        else {

          if(alreadyHitPins + pinsHit == maxPins){
            trailList.add(new Trail(pinsHit, new SpareScoreType()));
          }
          else {
            trailList.add(new Trail(pinsHit, new NormalScoreType()));
            isComplete = true;
          }
        }
        break;

      case 2:
        if(pinsHit.equals(maxPins)){
          trailList.add(new Trail(pinsHit, new StrikeScoreType()));
        }
        else {
          trailList.add(new Trail(pinsHit, new NormalScoreType()));
        }
        isComplete = true;
      break;
      default:
        System.out.println("Some exception here");
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
