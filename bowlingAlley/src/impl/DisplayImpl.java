package impl;

import interfaces.Diplay;
import interfaces.Player;
import interfaces.Set;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayImpl implements Diplay {

  @Override
  public void update(Lane lane) {
  System.out.print("\nDisplay Board : \n");
  List<Player> playerList = lane.getPlayerList();
  for(Integer i=0; i<playerList.size();i++){
    printForEachPlayer(playerList.get(i), i.equals(lane.getPlayerActive()));
  }

  }

  private void printForEachPlayer(Player player, boolean active){
    if(active){
      System.out.print(player.getName() + "* : ");
    }
    else {
      System.out.print(player.getName() + " : ");
    }
    for(Set set : player.getSetList()){
        System.out.print(set.getTrailList().stream().map(trail -> trail.getPinsHit().toString()).collect(
            Collectors.joining(",")));
        System.out.print(  " = " + set.getScore() + " ; ");
    }
    System.out.println("cumulative score: " +  player.getScore());
  }

}
