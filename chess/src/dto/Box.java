package dto;

import models.Piece;

public class Box extends Position{

  private Piece piece;

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  public Piece getPiece() {
    return piece;
  }
}
