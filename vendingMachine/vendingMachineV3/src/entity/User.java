package entity;


import interfaces.UserVendingMachine;

public class User {

  private UserVendingMachine vendingMachine;

  public User(UserVendingMachine vendingMachine){
    this.vendingMachine = vendingMachine;
  }

  public void selectProduct(){
    vendingMachine.selectProduct();
  }
  public void insertCoinForPayment(){
    vendingMachine.insertCoinForPayment();
  }
}
