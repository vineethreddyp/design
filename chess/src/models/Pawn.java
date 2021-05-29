package models;

import dto.Box;
import enums.Color;
import java.util.Objects;

public class Pawn extends Piece {

  public Pawn(Color color) {
    super(color, "P");
  }

  @Override
  public boolean isMovePossible(Box sourcePosition, Box destPosition) {
    if(!movedForwardByOneStep(sourcePosition, destPosition))
      return false;
    return !wrongCrossMove(sourcePosition,destPosition);
  }

  private boolean movedForwardByOneStep(Box sourcePosition, Box destPosition) {
    int absXDiff = Math.abs(sourcePosition.x-destPosition.x);
    if(absXDiff!=1)
      return false;
    if(getColor().equals(Color.WHITE))
      return (destPosition.x > sourcePosition.x);
    else
      return (destPosition.x < sourcePosition.x);
  }

  private boolean wrongCrossMove(Box sourcePosition, Box destPosition) {
    return (destPosition.y!= sourcePosition.y) && Objects.isNull(destPosition.getPiece());
  }
}
