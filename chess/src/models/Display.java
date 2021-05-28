package models;

import dto.Box;
import enums.Color;
import java.util.Objects;

public class Display {


  public void display(Board board, Color activePlayerColor){

    Box[][] boxes = board.getBoardBoxes();
    for(int i=0;i<8;i++){
      System.out.print(i +" ");
      for(int j=0;j<8;j++){
        displayPiece(boxes[i][j].getPiece());
      }
      System.out.println();
    }
    System.out.println("Active Player :" + activePlayerColor);
    System.out.println("Enter source and destination Sx Sy Dx Dy");
  }

  private void displayPiece(Piece piece) {
    if(Objects.isNull(piece) || piece.isKilled()){
      System.out.print("_");
    }
    else {
      System.out.print(piece.getColor().colorCode + piece.getCode());
    }

  }
}
