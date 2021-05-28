package models;

import dto.Box;

public class Board {

  private Box[][] boardBoxes;

  public Box[][] getBoardBoxes() {
    return boardBoxes;
  }

  public Board(){
    boardBoxes = new Box[8][8];
    resetBoard();
  }
  public Box getBox(int x, int y){
    return boardBoxes[x][y];
  }

  public void resetBoard(){

  }
}

