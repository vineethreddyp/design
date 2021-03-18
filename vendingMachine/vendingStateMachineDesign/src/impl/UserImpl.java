package impl;


import interfaces.User;
import interfaces.VendingMachine;

public class UserImpl implements User {

  private VendingMachine vendingMachine;

  public UserImpl(VendingMachine vendingMachine){
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void selectProduct(){
    vendingMachine.selectProduct();
  }

//  @Override
//  public void insertCoinForPayment(){
//    vendingMachine.insertCoinForPayment();
//  }
}
