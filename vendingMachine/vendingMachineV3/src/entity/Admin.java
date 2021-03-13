package entity;


import interfaces.AdminVendingMachine;

public class Admin implements AdminVendingMachine{

  private AdminVendingMachine vendingMachine;

  private String name;

  public Admin(AdminVendingMachine vendingMachine, String name) {
    this.vendingMachine = vendingMachine;
    this.name = name;
  }

  public AdminVendingMachine getVendingMachine() {
    return vendingMachine;
  }

  @Override
  public void addQuantityForAProduct(Product product, Integer quantity) {
    vendingMachine.addQuantityForAProduct(product,quantity);
  }

  @Override
  public void printCoinsInMachine() {
    vendingMachine.printCoinsInMachine();
  }

  @Override
  public void addChangeInsideMachine(Coin coin, Integer quantity) {
    vendingMachine.addChangeInsideMachine(coin,quantity);
  }

}
