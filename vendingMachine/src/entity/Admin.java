package entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Admin {

  public void addQuantityForAProduct(VendingMachine vendingMachine, Product product, Integer quantity){
    if(vendingMachine.getProductQuantityMap().containsKey(product)){
      Integer valPresent = vendingMachine.getProductQuantityMap().get(product);
      vendingMachine.getProductQuantityMap().put(product, valPresent + quantity);
    }
    else {
      vendingMachine.getProductQuantityMap().put(product, quantity);
    }
  }

  public void addChangeInsideMachine(VendingMachine vendingMachine, Coin coin, Integer quantity){
    if(vendingMachine.getCoinQuantityMap().containsKey(coin)){
      Integer valPresent = vendingMachine.getCoinQuantityMap().get(coin);
      vendingMachine.getCoinQuantityMap().put(coin,valPresent + quantity);
    }
    else {
      vendingMachine.getCoinQuantityMap().put(coin,quantity);
    }
  }

  public void printCoinState(VendingMachine vendingMachine){
    Map<Coin,Integer> coinIntegerMap = vendingMachine.getCoinQuantityMap();
    List<String> coinStringList = new ArrayList<>();
    for(Coin coin : coinIntegerMap.keySet()){
      coinStringList.add(coinIntegerMap.get(coin) + " " + coin.toString() + "coins");
    }
    System.out.println( "Coins inside machine :" + String.join(",", coinStringList));
  }


}
