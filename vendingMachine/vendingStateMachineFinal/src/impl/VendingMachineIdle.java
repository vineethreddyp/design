package impl;

import entity.Product;
import interfaces.VendingMachine;

public class VendingMachineIdle implements VendingMachine {

  private VendingMachine vendingMachine;

  public VendingMachineIdle(VendingMachine vendingMachine){
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void selectProduct(Product product) {
    vendingMachine.selectProduct(product);
  }


  @Override
  public void insertCoinForPayment(Integer integer) {
    System.out.println("Invalid call. Coin cannot be inserted now.");
  }
}
