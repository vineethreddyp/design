package models;

import dto.Action;
import dto.Box;
import dto.Move;
import dto.MoveLog;
import dto.Position;
import enums.Color;
import enums.GameStatus;
import java.util.Objects;
import java.util.Scanner;

public class Game {

  private GameStatus gameStatus;
  private Color activePlayerColor;
  private Player playerWon;
  private Player whitePlayer;
  private Player blackPlayer;
  private Display displayPanel;
  private Board board;
  private MoveLog moveLog;


  public Game(Player whitePlayer, Player blackPlayer, Display displayPanel){
    this.whitePlayer = whitePlayer;
    this.blackPlayer = blackPlayer;
    activePlayerColor = Color.WHITE;
    gameStatus = GameStatus.TO_START;
    this.displayPanel = displayPanel;
    board = new Board();
    moveLog = new MoveLog();
  }

  public void startGame(){
    gameStatus = GameStatus.ON_GOING;
    continuousFunction();
  }


  private void continuousFunction(){
    while(gameStatus.equals(GameStatus.ON_GOING)){
      displayPanel.display(board, activePlayerColor);
      Action actionMade = getInputFromUser();
      boolean moveValid = makeMove(actionMade);
      if(moveValid)
        switchPlayer();
      else
        System.out.println("Invalid move. Try again.....");
    }
  }

  private void switchPlayer() {
    if(activePlayerColor.equals(Color.WHITE)){
      activePlayerColor = Color.BLACK;
    }
    else activePlayerColor = Color.WHITE;
  }

  private Action getInputFromUser() {
    Scanner scanner = new Scanner(System.in);
    Position sourcePosition = new Position();
    Position destPosition = new Position();
    String input = scanner.nextLine();
    String[] numbers = input.split(" ");
    sourcePosition.x = Integer.parseInt(numbers[0]);
    sourcePosition.y = Integer.parseInt(numbers[1]);
    destPosition.x = Integer.parseInt(numbers[2]);
    destPosition.y = Integer.parseInt(numbers[3]);
    Action action = new Action();
    action.source = sourcePosition;
    action.destination = destPosition;
    return action;
  }

  private boolean makeMove(Action moveMade) {
    Box sourceBox = board.getBox(moveMade.source.x, moveMade.source.y);
    Box destBox = board.getBox(moveMade.destination.x, moveMade.destination.y);
    Piece sourcePiece = sourceBox.getPiece();
    if(Objects.isNull(sourcePiece))
      return false;
    if(!sourcePiece.getColor().equals(activePlayerColor))
      return false;

    Piece destinationPiece = destBox.getPiece();
    if(Objects.nonNull(destinationPiece) && destinationPiece.getColor().equals(activePlayerColor))
      return false;
    boolean isMovePossible = sourcePiece.isMovePossible(sourceBox, destBox);
    if(isMovePossible){
      boolean killMove = Objects.nonNull(destinationPiece);
      Move move = new Move(new Box(sourceBox), new Box(destBox),killMove);
      moveLog.addMove(move);
      sourceBox.setPiece(null);
      destBox.setPiece(sourcePiece);
      if(destinationPiece!=null){
        // add this in move Log
        destinationPiece.setKilled();
      }

    }
    return isMovePossible;


  }


}
