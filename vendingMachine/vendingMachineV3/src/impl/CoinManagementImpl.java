package impl;

import entity.Coin;
import entity.InventoryManagement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinManagementImpl extends InventoryManagement<Coin> {

  @Override
  public void displayQuantityOfItems() {
    Map<Coin,Integer> coinIntegerMap = this.getItemQuantityMap();
    List<String> coinStringList = new ArrayList<>();
    for(Coin coin : coinIntegerMap.keySet()){
      coinStringList.add(coinIntegerMap.get(coin) + " " + coin.toString() + "coins");
    }
    System.out.println( "Coins inside machine :" + String.join(",", coinStringList));
  }

  public boolean disperseChange(int val) {
    Map<Coin, Integer> temporaryMap = initialiseCoinMap();
    Integer remainingValue = val;
    boolean isValid = true;
    while(remainingValue > 0 && isValid){
      isValid = false;

      if(remainingValue >= Coin.TwentyFive.getValue() && (this.getItemQuantityMap().get(Coin.TwentyFive) - temporaryMap.get(Coin.TwentyFive)) > 0){
        remainingValue = remainingValue - Coin.TwentyFive.getValue();
        temporaryMap.put(Coin.TwentyFive, temporaryMap.get(Coin.TwentyFive) +1);
        isValid = true;
        continue;
      }

      if(remainingValue >= Coin.Ten.getValue() && (this.getItemQuantityMap().get(Coin.Ten) - temporaryMap.get(Coin.Ten)) > 0){
        remainingValue = remainingValue - Coin.Ten.getValue();
        temporaryMap.put(Coin.Ten, temporaryMap.get(Coin.Ten) +1);
        isValid = true;
        continue;
      }

      if(remainingValue >= Coin.Five.getValue() && (this.getItemQuantityMap().get(Coin.Five) - temporaryMap.get(Coin.Five)  )> 0){
        remainingValue = remainingValue - Coin.Five.getValue();
        temporaryMap.put(Coin.Five, temporaryMap.get(Coin.Five) +1);
        isValid = true;
        continue;
      }

      if(remainingValue >= Coin.One.getValue() && (this.getItemQuantityMap().get(Coin.One) - temporaryMap.get(Coin.One)) > 0 ){
        remainingValue = remainingValue - Coin.One.getValue();
        temporaryMap.put(Coin.One, temporaryMap.get(Coin.One) +1);
        isValid = true;
        continue;
      }

    }

    if(isValid) {
      printDispersedChange(temporaryMap);
      removeCoinsFromMachine(temporaryMap);
    }
    return isValid;
  }

  private Map<Coin, Integer> initialiseCoinMap() {
    Map<Coin, Integer> temporaryMap = new HashMap<>();
    for(Coin coin : Coin.values()){
      temporaryMap.put(coin,0);
    }
    return temporaryMap;
  }

  private void removeCoinsFromMachine(Map<Coin, Integer> temporaryMap) {
    for(Coin coin : Coin.values()){
      this.getItemQuantityMap().put(coin, this.getItemQuantityMap().get(coin)- temporaryMap.get(coin));
    }
  }

  private void printDispersedChange(Map<Coin, Integer> coinIntegerMap) {
    List<String> coinStringList = new ArrayList<>();
    System.out.println("Change dispersed as follows");
    for(Coin coin : coinIntegerMap.keySet()){
      coinStringList.add(coinIntegerMap.get(coin) + " " + coin.toString() + "coins");
    }
    System.out.println(String.join("\n", coinStringList));
  }


}
