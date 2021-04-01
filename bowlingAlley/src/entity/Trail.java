package entity;

import interfaces.Score;
import interfaces.ScoreType;

public class Trail implements Score {

  private Integer pinsHit;
  private ScoreType scoreType;

  @Override
  public Integer getScore() {
    return scoreType.getScore(pinsHit);
  }

  public Integer getPinsHit() {
    return pinsHit;
  }

  public Trail(Integer pinsHit, ScoreType scoreType) {
    this.pinsHit = pinsHit;
    this.scoreType = scoreType;
  }
}
