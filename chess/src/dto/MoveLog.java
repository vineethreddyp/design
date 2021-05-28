package dto;

import java.util.ArrayList;
import java.util.List;

public class MoveLog {

  List<Move> moveList;

  public MoveLog() {
    this.moveList = new ArrayList<>();
  }

  public void addMove(Move move){
    moveList.add(move);
  }

  public void displayMoves(){
    for(Move move : moveList){
      System.out.print(move);
    }
  }

}
