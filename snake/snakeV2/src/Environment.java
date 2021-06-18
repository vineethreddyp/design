import enums.CellType;
import java.util.ArrayList;
import java.util.List;

public class Environment {

  private int x;
  private int y;
  private Cell[][] cells;

  public Environment(int x, int y) {
    this.x = x;
    this.y = y;
    cells = new Cell[x][y];
    for(int i=0;i<x;i++)
      for(int j=0;j<y;j++)
        cells[i][j] = new Cell(i,j);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Cell[][] getCells() {
    return cells;
  }

  public void display(){
    System.out.println("\n");
    for(int i=0;i<x;i++){
      for(int j=0;j<y;j++){
        System.out.print(cells[i][j].getCellType().getSymbol());
      }
      System.out.println();
    }
  }

  public List<Cell> getEmptyCells(){
    List<Cell> emptyCells = new ArrayList<>();
    for(int i=0;i<x;i++){
      for(int j=0;j<y;j++){
        if(cells[i][j].getCellType().equals(CellType.EMPTY))
          emptyCells.add(cells[i][j]);
      }
    }
    return emptyCells;
  }


  public void setFood(int x, int y) {
    cells[x][y].setCellType(CellType.FOOD);
  }

  public void setSnake(int x, int y) {
    cells[x][y].setCellType(CellType.SNAKE);
  }

  public boolean invalidMove(Cell snakeNextCell) {
    return snakeNextCell.getCellType().equals(CellType.SNAKE);
  }

  public boolean foodEatenBySnake(Cell snakeNextCell) {
    return snakeNextCell.getCellType().equals(CellType.FOOD);
  }
}
