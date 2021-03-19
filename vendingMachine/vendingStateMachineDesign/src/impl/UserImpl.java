package impl;


import entity.Product;
import interfaces.User;
import interfaces.VendingMachine;

public class UserImpl implements User {

  private VendingMachine vendingMachine;

  public UserImpl(VendingMachine vendingMachine){
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void selectProduct(Product product){
    vendingMachine.selectProduct(product);
  }

  @Override
  public void insertCoinForPayment(Integer integer){
    vendingMachine.insertCoinForPayment(integer);
  }
}
