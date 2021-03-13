package impl;

import entity.Coin;
import entity.Product;
import entity.State;
import interfaces.InventoryManagement;
import interfaces.VendingMachine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class VendingMachineImpl implements VendingMachine {

  private String name;
  private InventoryManagement<Product> productManagement;
  private Map<Coin,Integer> coinQuantityMap; // this can be also user in inventory management
  private State state;
  private Integer amountToBePaid;
  private Product selectedProduct;


  public VendingMachineImpl(String name, InventoryManagement<Product> productManagement){
    this.name = name;
    this.productManagement = productManagement;
    coinQuantityMap = new HashMap<>();
    state = State.Idle;
  }

  @Override
  public void addQuantityForAProduct( Product product, Integer quantity){
    productManagement.addQuantity(product,quantity);
  }


  @Override
  public void printCoinState(){
    Map<Coin,Integer> coinIntegerMap = coinQuantityMap;
    List<String> coinStringList = new ArrayList<>();
    for(Coin coin : coinIntegerMap.keySet()){
      coinStringList.add(coinIntegerMap.get(coin) + " " + coin.toString() + "coins");
    }
    System.out.println( "Coins inside machine :" + String.join(",", coinStringList));
  }

  @Override
  public void addChangeInsideMachine(Coin coin, Integer quantity) {
    if(coinQuantityMap.containsKey(coin)){
      Integer valPresent = coinQuantityMap.get(coin);
      coinQuantityMap.put(coin,valPresent + quantity);
    }
    else {
      coinQuantityMap.put(coin,quantity);
    }
  }


  public String getName() {
    return name;
  }

  @Override
  public void insertCoinForPayment() {
    while (state.equals(State.Process)){
      displayAmountToBePaid(); // In actual implementation displayPanel. display is called
      processAmount();
    }
  }


  @Override
  public void display(){
    switch (state){
      case Idle:
        productManagement.displayQuantityOfItems();
        break;
      case Process:
        displayAmountToBePaid();
    }
  }

  @Override
  public void selectProduct() {
    System.out.println("Select product");
    Scanner sc= new Scanner(System.in);
    String productString =  sc.next();
    Product product = Product.findByName(productString);
    if(Objects.isNull(product)){
      System.out.println("Invalid Product name. Valid are " + Product.getValidProdcutList());
      return;
    }
    this.selectedProduct  = product;
    this.amountToBePaid = product.getCost();
    this.state = State.Process;
  }



  private void displayAmountToBePaid(){
    System.out.println("Amount to be paid : "  + amountToBePaid);
  }

  private void processAmount() {
    System.out.println("Enter amount for payment");
    Scanner sc= new Scanner(System.in);
    Integer valueEntered = sc.nextInt();
    if(valueEntered == -1){
      // this is for abort in the middle
      disperseChange(selectedProduct.getCost()-amountToBePaid);
      clearState();
      return;
    }
    Coin paidCoin = Coin.findByValue(valueEntered);
    if(Objects.isNull(paidCoin)){
      System.out.println("Not accepted coin. Valid are " + Coin.getValidCoins());
      return;
    }
    Integer finalVal = amountToBePaid - paidCoin.getValue();
    coinQuantityMap.put(paidCoin, coinQuantityMap.get(paidCoin) + 1);
    if(finalVal == 0){
      amountToBePaid = 0;
      disperseProduct();
    }
    else if(finalVal > 0){
      amountToBePaid = finalVal;
    }
    else {
      if(disperseChange(-1 * finalVal)){
        disperseProduct();
      }
    }
  }

  private void disperseProduct() {
    System.out.println("Product : " +  this.selectedProduct.getName() +  " Dispersed");
    productManagement.decrementAQuantity(this.selectedProduct);
    clearState();

  }

  private void clearState() {
    this.state = State.Idle;
    this.amountToBePaid = 0;
  }


  private boolean disperseChange(Integer val) {

    Map<Coin, Integer> temporaryMap = initialiseCoinMap();
    Integer remainingValue = val;
    boolean isValid = true;
    while(remainingValue > 0 && isValid){
      isValid = false;

      if(remainingValue >= Coin.TwentyFive.getValue() && (coinQuantityMap.get(Coin.TwentyFive) - temporaryMap.get(Coin.TwentyFive)) > 0){
        remainingValue = remainingValue - Coin.TwentyFive.getValue();
        temporaryMap.put(Coin.TwentyFive, temporaryMap.get(Coin.TwentyFive) +1);
        isValid = true;
        continue;
      }

      if(remainingValue >= Coin.Ten.getValue() && (coinQuantityMap.get(Coin.Ten) - temporaryMap.get(Coin.Ten)) > 0){
        remainingValue = remainingValue - Coin.Ten.getValue();
        temporaryMap.put(Coin.Ten, temporaryMap.get(Coin.Ten) +1);
        isValid = true;
        continue;
      }

      if(remainingValue >= Coin.Five.getValue() && (coinQuantityMap.get(Coin.Five) - temporaryMap.get(Coin.Five)  )> 0){
        remainingValue = remainingValue - Coin.Five.getValue();
        temporaryMap.put(Coin.Five, temporaryMap.get(Coin.Five) +1);
        isValid = true;
        continue;
      }

      if(remainingValue >= Coin.One.getValue() && (coinQuantityMap.get(Coin.One) - temporaryMap.get(Coin.One)) > 0 ){
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
    else {
      System.out.println("Change dispersion failed. Returning paid amount");
      disperseChange(selectedProduct.getCost()+val); // return original amount
      clearState();
    }
    return isValid;
  }

  private void removeCoinsFromMachine(Map<Coin, Integer> temporaryMap) {
    for(Coin coin : Coin.values()){
      coinQuantityMap.put(coin, coinQuantityMap.get(coin)- temporaryMap.get(coin));
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

  private Map<Coin, Integer> initialiseCoinMap() {
    Map<Coin, Integer> temporaryMap = new HashMap<>();
    for(Coin coin : Coin.values()){
      temporaryMap.put(coin,0);
    }
    return temporaryMap;
  }



}
