package models;

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

  void startGame(){
    gameStatus = GameStatus.ON_GOING;
    continuousFunction();
  }


  private void continuousFunction(){
    while(gameStatus.equals(GameStatus.ON_GOING)){
      displayPanel.display(board, activePlayerColor);
      Move moveMade = getInputFromUser();
      boolean moveValid = makeMove(moveMade);
      if(moveValid)
        switchPlayer();
    }
  }

  private void switchPlayer() {
    if(activePlayerColor.equals(Color.WHITE)){
      activePlayerColor = Color.BLACK;
    }
    else activePlayerColor = Color.WHITE;
  }

  private Move getInputFromUser() {
    Scanner scanner = new Scanner(System.in);
    Position sourcePosition = new Position();
    Position destPosition = new Position();
    sourcePosition.x = scanner.nextInt();
    sourcePosition.y = scanner.nextInt();
    destPosition.x = scanner.nextInt();
    destPosition.y = scanner.nextInt();
    Move move = new Move();
    move.source = sourcePosition;
    move.destination = destPosition;
    return move;
  }

  private boolean makeMove(Move moveMade) {
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
      Move move = new Move(killMove);
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
