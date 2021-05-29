package models;

import dto.Box;
import enums.Color;

public class Knight extends Piece {

  public Knight(Color color) {
    super(color, "N");
  }

  @Override
  public boolean isMovePossible(Box sourcePosition, Box destPosition) {
    return false;
  }
}
