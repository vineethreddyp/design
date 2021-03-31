package impl;

import interfaces.ScoreType;

public class SpareScoreType implements ScoreType {

  @Override
  public Integer getScore(Integer pinsHit) {
    return pinsHit + 5;
  }
}
