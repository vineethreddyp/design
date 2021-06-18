package enums;

import java.util.HashMap;
import java.util.Map;

public enum  Direction {

  LEFT("L"), RIGHT("R"), UP("U"), DOWN("D");
  String symbol;

  private static Map<String, Direction> symbolMap;

  static {
    symbolMap = new HashMap<>();
    for(Direction direction : Direction.values()){
      symbolMap.put(direction.symbol, direction);
    }
  }

  Direction(String symbol){
    this.symbol = symbol;
  }

  public static Direction findByString(String symbol){
    return symbolMap.get(symbol);
  }
}
