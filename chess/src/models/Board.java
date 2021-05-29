package models;

import dto.Box;
import enums.Color;

public class Board {

  private Box[][] boardBoxes;

  public Box[][] getBoardBoxes() {
    return boardBoxes;
  }

  public Board(){
    boardBoxes = initialiseBoxes();
    resetBoard();
  }

  private Box[][] initialiseBoxes() {
    Box[][] boxes = new Box[8][8];
    for(int i=0;i<8;i++)
      for(int j=0;j<8;j++)
        boxes[i][j] = new Box(i,j);
    return boxes;
  }

  public Box getBox(int x, int y){
    return boardBoxes[x][y];
  }

  public void resetBoard(){
    King whiteKing = new King(Color.WHITE);
    King blackKing = new King(Color.BLACK);
    boardBoxes[0][4].setPiece(whiteKing);
    boardBoxes[7][4].setPiece(blackKing);

    boardBoxes[0][0].setPiece( new Rook(Color.WHITE));
    boardBoxes[0][7].setPiece( new Rook(Color.WHITE));

    boardBoxes[7][0].setPiece( new Rook(Color.BLACK));
    boardBoxes[7][7].setPiece( new Rook(Color.BLACK));

    // setting Pawns
    for(int i=0;i<8;i++){
      boardBoxes[1][i].setPiece(new Pawn(Color.WHITE));
      boardBoxes[6][i].setPiece(new Pawn(Color.BLACK));
    }


  }
}

