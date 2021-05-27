package enums;

public enum  CellType {
  SNAKE('-'), FOOD('*'), EMPTY('.');
  private char symbol;

   CellType(char symbol){
    this.symbol = symbol;
  }

  public char getSymbol() {
    return symbol;
  }
}
