package models;

import dto.Box;
import enums.Color;

public class King extends Piece{

  public King(Color color) {
    super(color, "K");
  }

  @Override
  public boolean isMovePossible(Box sourcePosition, Box destPosition) {
    int absXDiff = Math.abs(sourcePosition.x-destPosition.x);
    int absYDiff = Math.abs(sourcePosition.y-destPosition.y);
    return (absXDiff<=1 && absYDiff<=1);
  }
}
