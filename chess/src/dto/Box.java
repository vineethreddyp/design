package dto;

import models.Piece;

public class Box extends Position{

  public Box(int x, int y) {
   this.x = x;
   this.y = y;
  }

  private Piece piece;

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  public Piece getPiece() {
    return piece;
  }

  public Box(Box b) {
    this.x = b.x;
    this.y = b.y;
    this.piece = b.piece;
  }
}
