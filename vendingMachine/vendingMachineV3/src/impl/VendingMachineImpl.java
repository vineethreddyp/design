package impl;

import entity.Coin;
import entity.CoinManagement;
import entity.Product;
import entity.ProductManagement;
import entity.State;
import entity.InventoryManagement;
import interfaces.VendingMachine;
import java.util.Objects;
import java.util.Scanner;

public class VendingMachineImpl implements VendingMachine {

  private String name;
  private ProductManagement productInventoryManagement;
  private CoinManagement coinInventoryManagement;
  private State state;
  private Integer amountToBePaid;
  private Product selectedProduct;


  public VendingMachineImpl(String name, ProductManagement productInventoryManagement,
       CoinManagement coinInventoryManagement){
    this.name = name;
    this.productInventoryManagement = productInventoryManagement;
    this.coinInventoryManagement = coinInventoryManagement;
    state = State.Idle;
  }

  @Override
  public InventoryManagement<Coin> getCoinInventoryManagement() {
    return coinInventoryManagement;
  }

  @Override
  public void addQuantityForAProduct( Product product, Integer quantity){
    productInventoryManagement.addQuantity(product,quantity);
  }

  @Override
  public void printCoinsInMachine(){
   coinInventoryManagement.displayQuantityOfItems();
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
        productInventoryManagement.displayQuantityOfItems();
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
      coinInventoryManagement.disperseChange(selectedProduct.getCost()-amountToBePaid);
      clearState();
      return;
    }
    Coin paidCoin = Coin.findByValue(valueEntered);
    if(Objects.isNull(paidCoin)){
      System.out.println("Not accepted coin. Valid are " + Coin.getValidCoins());
      return;
    }
    Integer finalVal = amountToBePaid - paidCoin.getValue();
    coinInventoryManagement.addQuantity(paidCoin,1);
    if(finalVal == 0){
      amountToBePaid = 0;
      disperseProduct();
    }
    else if(finalVal > 0){
      amountToBePaid = finalVal;
    }
    else {
      disperseChange(finalVal * -1);
    }
  }

  private void disperseChange(Integer finalVal) {
    if(coinInventoryManagement.disperseChange( finalVal)){
      disperseProduct();
    }
    else {
      // change dispersion failed
      // total amount paid has to be returned
      System.out.println("Change dispersion failed. Product not dispersed. Dispersing paid amount");
      coinInventoryManagement.disperseChange(finalVal + selectedProduct.getCost());
      clearState();
    }
  }

  private void disperseProduct() {
    System.out.println("Product : " +  this.selectedProduct.getName() +  " Dispersed");
    productInventoryManagement.decrementAQuantity(this.selectedProduct);
    clearState();

  }

  private void clearState() {
    this.state = State.Idle;
    this.amountToBePaid = 0;
    this.selectedProduct = null;
  }




}
