package impl;

import interfaces.Diplay;
import interfaces.Player;
import interfaces.Set;
import java.util.stream.Collectors;

public class DisplayImpl implements Diplay {

  @Override
  public void update(Lane lane) {
  System.out.print("\nDisplay Board : \n");
  lane.getPlayerList().forEach(this::printForEachPlayer);
  }

  private void printForEachPlayer(Player player){
    System.out.print(player.getName() + ": ");
    for(Set set : player.getSetList()){
        System.out.print(set.getTrailList().stream().map(trail -> trail.getPinsHit().toString()).collect(
            Collectors.joining(",")));
        System.out.print(  " = " + set.getScore() + " ; ");
    }
    System.out.println( "cumulative score: " +  player.getScore());
  }

}
