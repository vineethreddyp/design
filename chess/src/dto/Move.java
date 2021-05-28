package dto;

public class Move {

  public Position source;
  public Position destination;
  public boolean isKillMove;

  public Move(boolean isKillMove) {
    this.isKillMove = isKillMove;
  }

  public Move() {
  }
}
