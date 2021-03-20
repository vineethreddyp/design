package impl;

import datastore.StateMachineStore;
import entity.Product;
import exception.InvalidOperationException;
import interfaces.VendingMachine;

public class VendingMachineImpl implements VendingMachine {

  private String name;
  private StateMachineStore stateMachineStore;


  public VendingMachineImpl(String name, StateMachineStore stateMachineStore){
    this.name = name;
    this.stateMachineStore = stateMachineStore;
  }

  public String getName() {
    return name;
  }


  public void insertCoinForPayment(Integer integer) {

    try {
      stateMachineStore.getCurrentVendingMachineState().insertCoinForPayment(integer);
    }
    catch (InvalidOperationException ex){
      stateMachineStore.getDisplayPanel().setDisplayString(ex.getMessage());
    }
  }

  @Override
  public void action() {

  }

  @Override
  public void selectProduct(Product product) {
    try {
      stateMachineStore.getCurrentVendingMachineState().selectProduct(product);
    }
    catch (InvalidOperationException ex){
      stateMachineStore.getDisplayPanel().setDisplayString(ex.getMessage());
    }

  }

}
