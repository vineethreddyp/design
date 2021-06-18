
import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import enums.Direction;
import java.util.Random;
import thread.UserInput;

public class Game {

  private Long frameTime;
  private GameStatus gameStatus;
  private String playerName;
  private UserInput userInput;
  private Environment environment;
  private Random random;
  private Snake snake;

  public Game(Long frameTime, String playerName, Environment environment) {
    this.frameTime = frameTime;
    this.playerName = playerName;
    this.environment = environment;
    gameStatus = GameStatus.TO_START;
    random = new SecureRandom();
    initialiseSnake();
  }

  private void initialiseSnake() {
    int x = environment.getX()/2;
    int y = environment.getY()/2;
    Cell firstSnakeCell = environment.getCells()[x][y];
    this.snake = new Snake(firstSnakeCell);
  }

  public void start() throws InterruptedException {
    gameStatus = GameStatus.RUNNING;
    environment.setFood(0,0);
    userInput = new UserInput();
    Thread thread = new Thread(userInput);
    thread.start();
    continuousFunction();
    // call a function that runs until game over/abort
  }

  private void continuousFunction() throws InterruptedException {

    while (gameStatus.equals(GameStatus.RUNNING) && !maxSnakeLengthReached() ){
      environment.display();
      Direction direction = userInput.getDirection();
      Thread.sleep(frameTime);
      if(Objects.nonNull(direction))
       snake.updateSnakeDirection(direction);

      Cell snakeNextCell = getNextCell(snake.getHead());
      if(environment.invalidMove(snakeNextCell)){
        gameStatus = GameStatus.GAME_OVER;
        break;
      }

      if(environment.foodEatenBySnake(snakeNextCell)){
        snake.grow(snakeNextCell);
        generateNewFood();
      }
      else {
        snake.move(snakeNextCell);
      }

    }

    if(gameStatus.equals(GameStatus.GAME_OVER))
      System.out.println("Game Over");
    else
      System.out.println("Game Complete.");
  }

  private boolean maxSnakeLengthReached() {
    int maxPossibleLength = environment.getX() * environment.getY();
    int snakeLength = snake.getSnakeLength();
    return snakeLength==maxPossibleLength;
  }

  private void generateNewFood() {
    List<Cell> foodPossibleCells = environment.getEmptyCells();
    Cell randomCell = foodPossibleCells.get(random.nextInt(foodPossibleCells.size()));
    environment.setFood(randomCell.getX() ,randomCell.getY());
  }


  private Cell getNextCell(Cell currentSnakeCell) {
    int currentX = currentSnakeCell.getX();
    int currentY = currentSnakeCell.getY();
    int x = environment.getX();
    int y = environment.getY();
    Direction snakeDirection = snake.getSnakeDirection();
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
}
