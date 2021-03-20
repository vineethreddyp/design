package state;

import datastore.StateMachineStore;
import entity.Product;
import exception.InvalidOperationException;
import interfaces.VendingMachine;

public class VendingMachineProductDisperse implements VendingMachine {

  private StateMachineStore stateMachineStore;

  public VendingMachineProductDisperse(StateMachineStore stateMachineStore) {
    this.stateMachineStore = stateMachineStore;
  }

  @Override
  public void selectProduct(Product product) {
    throw new InvalidOperationException("Product cannot be selected while dispersion");
  }

  @Override
  public void insertCoinForPayment(Integer integer) {
    throw new InvalidOperationException("Coin cannot be inserted while product dispersion");
  }

  @Override
  public void action() {
    System.out.println("State changed to Disperse State");
    disperseProduct();
    stateMachineStore.clear();
  }


  private void disperseProduct() {
    Product selectedProduct = stateMachineStore.getSelectedProduct();
    stateMachineStore.getDisplayPanel().setDisplayString("Product : " +  selectedProduct.getName() +  " Dispersed");
    stateMachineStore.getProductInventoryManagement().decrementAQuantity(selectedProduct);
    clearState();

  }

  private void clearState() {
    stateMachineStore.setAmountToBePaid(0);
    stateMachineStore.setSelectedProduct(null);
    stateMachineStore.setIdleState();
  }


}
