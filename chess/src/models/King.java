package models;

import dto.Box;
import enums.Color;

public class King extends Piece{

  public King(Color color) {
    super(color, "K");
  }

  @Override
  public boolean isMovePossible(Box sourcePosition, Box destPosition) {
    return false;
  }
}
