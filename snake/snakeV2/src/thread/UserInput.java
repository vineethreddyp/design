package thread;

import enums.Direction;
import java.util.Scanner;

public class UserInput implements Runnable {

  private Direction direction;

  private boolean gameRunning;

  @Override
  public void run() {
    gameRunning = true;
    Scanner scanner = new Scanner(System.in);
    while (gameRunning){
      String directionString = scanner.next();
      Direction inputDirection = Direction.findByString(directionString);
      if(inputDirection!=null){
        direction = inputDirection;
      }
    }
  }

  public void setGameRunning(boolean gameRunning) {
    this.gameRunning = gameRunning;
  }

  public Direction getDirection() {
    return direction;
  }
}
