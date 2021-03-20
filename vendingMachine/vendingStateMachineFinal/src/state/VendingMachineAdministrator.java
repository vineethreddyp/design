package state;

import datastore.StateMachineStore;
import entity.Product;
import exception.InvalidOperationException;
import interfaces.VendingMachine;

public class VendingMachineAdministrator implements VendingMachine {

  private StateMachineStore stateMachineStore;

  public VendingMachineAdministrator(StateMachineStore stateMachineStore){
    this.stateMachineStore = stateMachineStore;
  }

  @Override
  public void selectProduct(Product product) {
    throw new InvalidOperationException("Product cannot be selected in admin mode");
  }

  @Override
  public void insertCoinForPayment(Integer integer) {
    throw new InvalidOperationException("Coin cannot be inserted for a product in admin mode");
  }

  @Override
  public void action() {
    System.out.println("State changed to Admin State");
  }
}
