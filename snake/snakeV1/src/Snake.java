import enums.CellType;
import enums.Direction;
import enums.MoveType;
import java.util.Deque;
import java.util.LinkedList;

public class Snake {

  private Direction snakeDirection;
  private int snakeLength;
  private Environment environment;
  private Deque<Cell> snakeQueue;
  private int maxSnakeLength;

  public Snake(Environment environment) {
    this.snakeDirection = Direction.RIGHT;
    this.snakeLength = 1;
    this.environment = environment;
    snakeQueue = new LinkedList<>();
    maxSnakeLength = environment.getX()*environment.getY();
    setSnakeInCell();
  }

  private void setSnakeInCell() {
    int x = environment.getX()/2;
    int y =environment.getY()/2;
    environment.setSnake(x,y);
    environment.setFood(0,0);
    snakeQueue.addFirst(environment.getCells()[x][y]);
  }

  public MoveType move() {


    Cell nextCell = getNextCell(snakeQueue.getFirst());
    int nextX = nextCell.getX();
    int nextY = nextCell.getY();

    Cell gameCellValue = environment.getCells()[nextX][nextY];
    CellType gameCellType = gameCellValue.getCellType();

    MoveType moveType;
    if(gameCellType.equals(CellType.SNAKE)){
      return MoveType.INVALID;
    }

    if(gameCellType.equals(CellType.FOOD)){
      moveType =  MoveType.FOOD;
    }
    else{
      moveType = MoveType.VALID;
    }
    updateCellValues(nextX, nextY, moveType);
    return moveType;
  }

  public boolean isSnakeLengthMax(){
    return snakeLength==maxSnakeLength;
  }

  private void updateCellValues(int nextX, int nextY, MoveType moveType) {
    Cell nextCell = environment.getCells()[nextX][nextY];
    nextCell.setCellType(CellType.SNAKE);
    snakeQueue.addFirst(nextCell);
    if(moveType.equals(MoveType.VALID)){
      Cell lastSnakeCell = snakeQueue.pollLast();
      lastSnakeCell.setCellType(CellType.EMPTY);
    }
  }

  private Cell getNextCell(Cell currentSnakeCell) {
    // incomplete function
    int currentX = currentSnakeCell.getX();
    int currentY = currentSnakeCell.getY();
    int x = environment.getX();
    int y = environment.getY();

    switch (snakeDirection){

      case UP:
        currentX = (currentX - 1);
        break;
      case DOWN:
        currentX = (currentX + 1)%x;
        break;
      case LEFT:
        currentY = (currentY -1);
        break;
      case RIGHT:
        currentY = (currentY +1)%y;
    }
    if(currentX<0)
      currentX = currentX+x;

    if(currentY<0)
      currentY = currentY+y;

    return environment.getCells()[currentX][currentY];
  }

  public void reset() {
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
