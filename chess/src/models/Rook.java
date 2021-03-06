package models;

import dto.Box;
import enums.Color;

public class Rook extends Piece {

  public Rook(Color color) {
    super(color, "R");
  }

  @Override
  public boolean isMovePossible(Box sourcePosition, Box destPosition) {
    return false;
  }
}
