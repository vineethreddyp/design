package state;

import datastore.StateMachineStore;
import entity.Product;
import interfaces.VendingMachine;

public class VendingMachineIdle implements VendingMachine {

  private StateMachineStore stateMachineStore;

  public VendingMachineIdle(StateMachineStore stateMachineStore){
    this.stateMachineStore = stateMachineStore;
  }

  @Override
  public void selectProduct(Product product) {
    // check quantity first
    stateMachineStore.setSelectedProduct(product);
    stateMachineStore.setAmountToBePaid(product.getCost());
    stateMachineStore.getDisplayPanel().setDisplayString("Product selected : " + product + ". Amount to be paid : "  + stateMachineStore.getAmountToBePaid());
    stateMachineStore.setProcessState();
  }


  @Override
  public void insertCoinForPayment(Integer integer) {
    System.out.println("Invalid call. Coin cannot be inserted now. Select a product and try again");
  }

  @Override
  public void action() {
    System.out.println("State changed to Idle State");
    setDisplay();
    stateMachineStore.clear(); // initialise values
  }
  private void setDisplay() {
    stateMachineStore.getDisplayPanel().setDisplayString(stateMachineStore.getProductInventoryManagement().displayQuantityOfItems());
  }

}
