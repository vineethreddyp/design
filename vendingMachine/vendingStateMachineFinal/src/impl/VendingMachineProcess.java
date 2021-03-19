package impl;

import entity.Product;
import interfaces.VendingMachine;

public class VendingMachineProcess implements VendingMachine {

  private VendingMachine vendingMachine;

  public VendingMachineProcess(VendingMachine vendingMachine){
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void selectProduct(Product product) {
    System.out.println("Invalid call. Product cannot be selected now.");
  }


  @Override
  public void insertCoinForPayment(Integer integer) {
    vendingMachine.insertCoinForPayment(integer);
  }
}
