package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Coin {

  One(1),
  Five(5),
  Ten(10),
  TwentyFive(25);

  private static Map<Integer, Coin> coinMap;
  private static String validCoinList;
  static {
    coinMap = new HashMap<>();
    List<String> coinList  = new ArrayList<>();
    for(Coin coin : Coin.values()){
      coinList.add(coin.getValue().toString());
      coinMap.put(coin.getValue(), coin);
    }
    validCoinList = String.join(",", coinList);

  }

  public static Coin findByValue(Integer value){
    return coinMap.get(value);
  }

  private Integer value;
  Coin(Integer val){
    this.value = val;
  }

  public Integer getValue() {
    return value;
  }

  public static String getValidCoins(){
   return validCoinList;
  }

}
