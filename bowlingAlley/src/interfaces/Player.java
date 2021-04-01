package interfaces;

import java.util.List;

public interface Player {
  void bowlRolled(Integer pinsHit);
  int getScore();
  boolean isTurnComplete();
  boolean allSetCompleted();
  List<Set> getSetList();
  String getName();
}
