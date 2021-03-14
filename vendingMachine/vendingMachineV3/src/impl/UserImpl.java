package impl;


import interfaces.UserFunction;
import interfaces.VendingMachine;

public class UserImpl implements UserFunction {

  private VendingMachine vendingMachine;

  public UserImpl(VendingMachine vendingMachine){
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void selectProduct(){
    vendingMachine.selectProduct();
  }

  @Override
  public void display() {
    vendingMachine.display();
  }

  @Override
  public void insertCoinForPayment(){
    vendingMachine.insertCoinForPayment();
  }
}
