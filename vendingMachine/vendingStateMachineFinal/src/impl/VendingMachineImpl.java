package impl;

import entity.Coin;
import entity.Product;
import interfaces.CoinManagement;
import interfaces.DisplayPanel;
import interfaces.ProductManagment;
import interfaces.VendingMachine;
import java.util.Objects;

public class VendingMachineImpl implements VendingMachine {

  private String name;
  private ProductManagment productInventoryManagement;
  private CoinManagement coinInventoryManagement;
  private DisplayPanel displayPanel;
  private Integer amountToBePaid;
  private Product selectedProduct;
  private Integer valueInserted;


  public VendingMachineImpl(String name, ProductManagment productInventoryManagement,
       CoinManagement coinInventoryManagement, DisplayPanel displayPanel){
    this.name = name;
    this.productInventoryManagement = productInventoryManagement;
    this.coinInventoryManagement = coinInventoryManagement;
    this.displayPanel = displayPanel;
    setDisplay();
  }


  public String getName() {
    return name;
  }


  public void insertCoinForPayment(Integer integer) {
    this.valueInserted = integer;
    System.out.println("Inserted amount : " + integer);
    processAmount();
  }

  @Override
  public void selectProduct(Product product) {
//    displayPanel.setDisplayString("Select product");
//    Scanner sc= new Scanner(System.in);
//    String productString =  sc.next();
//    Product product = Product.findByName(productString);
//    if(Objects.isNull(product)){
//      displayPanel.setDisplayString("Invalid Product name. Valid are " + Product.getValidProdcutList());
//      return;
//    }
    this.selectedProduct  = product;
    this.amountToBePaid = product.getCost();
    displayAmountToBePaid();
    System.out.println("Product selected : " + product);

  }

  private void setDisplay() {
    this.displayPanel.setDisplayString(productInventoryManagement.displayQuantityOfItems());
  }

  private void  displayAmountToBePaid(){
    displayPanel.setDisplayString("Amount to be paid : "  + amountToBePaid);
  }

  private void processAmount() {

      Integer valueEntered = valueInserted;
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
        displayAmountToBePaid();

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
      displayPanel.display();
      coinInventoryManagement.disperseChange(finalVal + selectedProduct.getCost());
      clearState();
    }
  }

  private void disperseProduct() {
    displayPanel.setDisplayString("Product : " +  this.selectedProduct.getName() +  " Dispersed");
    displayPanel.display();
    productInventoryManagement.decrementAQuantity(this.selectedProduct);
    clearState();

  }

  private void clearState() {
    this.amountToBePaid = 0;
    this.selectedProduct = null;
    setDisplay();
  }




}
