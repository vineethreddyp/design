package impl;


import entity.Product;
import interfaces.User;
import interfaces.VendingMachine;

public class UserImpl implements User {


  @Override
  public void selectProduct(VendingMachine vendingMachine, Product product){
    vendingMachine.selectProduct(product);
  }

  @Override
  public void insertCoinForPayment(VendingMachine vendingMachine, Integer integer){
    vendingMachine.insertCoinForPayment(integer);
  }
}
