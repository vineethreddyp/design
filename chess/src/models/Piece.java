package models;

import dto.Box;
import enums.Color;

public abstract class Piece {
  private Color color;
  private boolean isKilled;
  private String code;

  public Piece(Color color, String code){
    isKilled = false;
    this.color = color;
    this.code = code;
  }

  public void setKilled() {
    isKilled = true;
  }

  public Color getColor() {
    return color;
  }

  public boolean isKilled() {
    return isKilled;
  }

  public String getCode() {
    return code;
  }

  public abstract boolean isMovePossible(Box sourcePosition, Box destPosition);
}
