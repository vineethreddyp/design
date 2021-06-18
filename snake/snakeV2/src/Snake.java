import enums.CellType;
import enums.Direction;

import java.util.Deque;
import java.util.LinkedList;

public class Snake {

  private Direction snakeDirection;
  private Cell head;
  private Deque<Cell> snakeQueue;
  private int snakeLength;

  public Snake(Cell firstCell) {
    this.snakeDirection = Direction.RIGHT;
    snakeQueue = new LinkedList<>();
    initialiseSnake(firstCell);
  }

  public void initialiseSnake(Cell cell){
    cell.setCellType(CellType.SNAKE);
    snakeQueue.addFirst(cell);
    snakeLength = 1;
    this.head = cell;
  }

  public Direction getSnakeDirection() {
    return snakeDirection;
  }

  public Cell getHead() {
    return head;
  }

  public int getSnakeLength() {
    return snakeLength;
  }

  public void move(Cell snakeNextCell) {
      snakeNextCell.setCellType(CellType.SNAKE);
      head = snakeNextCell;
      snakeQueue.addFirst(snakeNextCell);
      Cell lastSnakeCell = snakeQueue.pollLast();
      lastSnakeCell.setCellType(CellType.EMPTY);
  }

  public void grow(Cell snakeNextCell) {
    snakeNextCell.setCellType(CellType.SNAKE);
    snakeQueue.addFirst(snakeNextCell);
    snakeLength++;
  }

  public void updateSnakeDirection(Direction newDirection) {
    Direction currentSnakeDirection = snakeDirection;
    switch (currentSnakeDirection){
      case LEFT:
        if(newDirection.equals(Direction.RIGHT))
          return;
        break;
      case DOWN:
        if(newDirection.equals(Direction.UP))
          return;
        break;
      case UP:
        if(newDirection.equals(Direction.DOWN))
          return;
        break;
      case RIGHT:
        if(newDirection.equals(Direction.LEFT))
          return;
    }
    // update direction when all constraints passed
    snakeDirection = newDirection;
  }
}
