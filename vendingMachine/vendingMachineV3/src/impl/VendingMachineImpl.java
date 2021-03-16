package impl;

import entity.Coin;
import entity.Product;
import entity.State;
import interfaces.CoinManagement;
import interfaces.DisplayPanel;
import interfaces.ProductManagment;
import interfaces.VendingMachine;
import java.util.Objects;
import java.util.Scanner;

public class VendingMachineImpl implements VendingMachine {

  private String name;
  private ProductManagment productInventoryManagement;
  private CoinManagement coinInventoryManagement;
  private DisplayPanel displayPanel;
  private State state;
  private Integer amountToBePaid;
  private Product selectedProduct;


  public VendingMachineImpl(String name, ProductManagment productInventoryManagement,
       CoinManagement coinInventoryManagement, DisplayPanel displayPanel){
    this.name = name;
    this.productInventoryManagement = productInventoryManagement;
    this.coinInventoryManagement = coinInventoryManagement;
    state = State.Idle;
    this.displayPanel = displayPanel;
  }


  public String getName() {
    return name;
  }

  @Override
  public void insertCoinForPayment() {
    while (state.equals(State.Process)){
      displayPanel.setDisplayString(displayAmountToBePaid()); // In actual implementation displayPanel. display is called
      processAmount();
    }
  }


  @Override
  public void startMachine(){
    switch (state){
      case Idle:
        displayPanel.setDisplayString(productInventoryManagement.displayQuantityOfItems());
        break;
      case Process:
        displayPanel.setDisplayString(displayAmountToBePaid());
    }
  }

  @Override
  public void selectProduct() {
    System.out.println("Select product");
    Scanner sc= new Scanner(System.in);
    String productString =  sc.next();
    Product product = Product.findByName(productString);
    if(Objects.isNull(product)){
      displayPanel.setDisplayString("Invalid Product name. Valid are " + Product.getValidProdcutList());
      return;
    }
    this.selectedProduct  = product;
    this.amountToBePaid = product.getCost();
    this.state = State.Process;
  }



  private String displayAmountToBePaid(){
    return "Amount to be paid : "  + amountToBePaid;
  }

  private void processAmount() {
    displayPanel.setDisplayString("Enter amount for payment");
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
      displayPanel.setDisplayString("Not accepted coin. Valid are " + Coin.getValidCoins());
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
      displayPanel.setDisplayString("Change dispersion failed. Product not dispersed. Dispersing paid amount");
      coinInventoryManagement.disperseChange(finalVal + selectedProduct.getCost());
      clearState();
    }
  }

  private void disperseProduct() {
    displayPanel.setDisplayString("Product : " +  this.selectedProduct.getName() +  " Dispersed");
    productInventoryManagement.decrementAQuantity(this.selectedProduct);
    clearState();

  }

  private void clearState() {
    this.state = State.Idle;
    this.amountToBePaid = 0;
    this.selectedProduct = null;
  }




}
