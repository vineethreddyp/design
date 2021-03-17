package impl;

import entity.Coin;
import entity.InventoryManagement;
import interfaces.CoinManagement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinManagementImpl implements CoinManagement {

  private InventoryManagement<Coin> coinInventoryManagement;

  public CoinManagementImpl(){
    coinInventoryManagement = new InventoryManagement<>();
  }

  @Override
  public void displayQuantityOfItems() {
    Map<Coin,Integer> coinIntegerMap = coinInventoryManagement.getItemQuantityMap();
    List<String> coinStringList = new ArrayList<>();
    for(Coin coin : coinIntegerMap.keySet()){
      coinStringList.add(coinIntegerMap.get(coin) + " " + coin.toString() + "coins");
    }
    System.out.println( "Coins inside machine :" + String.join(",", coinStringList));
  }

  @Override
  public void addQuantity(Coin coin, Integer quantity) {
    coinInventoryManagement.addQuantity(coin,quantity);
  }


  @Override
  public boolean disperseChange(Integer val) {
    Map<Coin, Integer> temporaryMap = initialiseCoinMap();
    Integer remainingValue = val;
    boolean isValid = true;
    while(remainingValue > 0 && isValid){
      isValid = false;

      if(remainingValue >= Coin.TwentyFive.getValue() && (coinInventoryManagement.getItemQuantityMap().get(Coin.TwentyFive) - temporaryMap.get(Coin.TwentyFive)) > 0){
        remainingValue = remainingValue - Coin.TwentyFive.getValue();
        temporaryMap.put(Coin.TwentyFive, temporaryMap.get(Coin.TwentyFive) +1);
        isValid = true;
        continue;
      }

      if(remainingValue >= Coin.Ten.getValue() && (coinInventoryManagement.getItemQuantityMap().get(Coin.Ten) - temporaryMap.get(Coin.Ten)) > 0){
        remainingValue = remainingValue - Coin.Ten.getValue();
        temporaryMap.put(Coin.Ten, temporaryMap.get(Coin.Ten) +1);
        isValid = true;
        continue;
      }

      if(remainingValue >= Coin.Five.getValue() && (coinInventoryManagement.getItemQuantityMap().get(Coin.Five) - temporaryMap.get(Coin.Five)  )> 0){
        remainingValue = remainingValue - Coin.Five.getValue();
        temporaryMap.put(Coin.Five, temporaryMap.get(Coin.Five) +1);
        isValid = true;
        continue;
      }

      if(remainingValue >= Coin.One.getValue() && (coinInventoryManagement.getItemQuantityMap().get(Coin.One) - temporaryMap.get(Coin.One)) > 0 ){
        remainingValue = remainingValue - Coin.One.getValue();
        temporaryMap.put(Coin.One, temporaryMap.get(Coin.One) +1);
        isValid = true;
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
      coinInventoryManagement.getItemQuantityMap().put(coin, coinInventoryManagement.getItemQuantityMap().get(coin)- temporaryMap.get(coin));
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
