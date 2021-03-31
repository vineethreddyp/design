package interfaces;


import entity.Trail;
import java.util.List;

public interface Set {
  boolean isComplete();
  void bowled(Integer pinsHit);
  Integer getScore();
  List<Trail> getTrailList();
}
