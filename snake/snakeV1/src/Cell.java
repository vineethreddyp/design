import enums.CellType;

public class Cell {

  private int x;
  private int y;
  private CellType cellType;

  public CellType getCellType() {
    return cellType;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Cell(int x, int y){
    this.x = x;
    this.y = y;
    cellType = CellType.EMPTY;
  }

  public void setCellType(CellType cellType) {
    this.cellType = cellType;
  }

}
