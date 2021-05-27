import enums.MoveType;
import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import enums.Direction;
import java.util.Random;
import thread.UserInput;

public class GameController {

  private Long frameTime;
  private GameStatus gameStatus;
  private String playerName;
  private UserInput userInput;
  private Environment environment;
  private Random random;


  private Snake snake;

  public GameController(Long frameTime, String playerName, Environment environment) {
    this.frameTime = frameTime;
    this.playerName = playerName;
    this.environment = environment;
    snake = new Snake(environment);
    gameStatus = GameStatus.TO_START;
    random = new SecureRandom();
  }

  public void start() throws InterruptedException {
    gameStatus = GameStatus.RUNNING;
    userInput = new UserInput();
    Thread thread = new Thread(userInput);
    thread.start();
    continuousFaction();
    // call a function that runs until game over/abort
  }

  private void continuousFaction() throws InterruptedException {

    while (gameStatus.equals(GameStatus.RUNNING) && !snake.isSnakeLengthMax() ){
      environment.display();
      Direction direction = userInput.getDirection();
      Thread.sleep(frameTime);
      if(Objects.nonNull(direction))
        updateSnakeDirection(direction);

      MoveType moveType = snake.move();
      // if invalid move => then game over

      if(moveType.equals(MoveType.INVALID))
        gameStatus = GameStatus.GAME_OVER;

      if(moveType.equals(MoveType.FOOD)){
        List<Cell> foodPossibleCells = environment.getEmptyCells();
        Cell randomCell = foodPossibleCells.get(random.nextInt(foodPossibleCells.size()));
        environment.setFood(randomCell.getX() ,randomCell.getY());
      }
    }
    if(gameStatus.equals(GameStatus.GAME_OVER))
      System.out.println("Game Over");
    else
      System.out.println("Game Complete.");
  }

  public void reset(){
    snake.reset();
  }

  private void updateSnakeDirection(Direction direction){
    snake.updateSnakeDirection(direction);
  }

}
