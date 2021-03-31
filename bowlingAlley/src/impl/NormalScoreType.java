package impl;

import interfaces.ScoreType;

public class NormalScoreType implements ScoreType {

  @Override
  public Integer getScore(Integer pinsHit) {
    return pinsHit;
  }
}
