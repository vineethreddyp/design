package dto;

public class Move {

  private Box source;
  private Box destination;
  private boolean isKillMove;

  public Move(Box source, Box destination, boolean isKillMove) {
    this.source = source;
    this.destination = destination;
    this.isKillMove = isKillMove;
  }

  public Box getSource() {
    return source;
  }

  public Box getDestination() {
    return destination;
  }

  public boolean isKillMove() {
    return isKillMove;
  }
}
