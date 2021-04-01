package impl;

import interfaces.ScoreType;

public class StrikeScoreType implements ScoreType {

  @Override
  public Integer getScore(Integer pinsHit) {
    return pinsHit+10;
  }
}
