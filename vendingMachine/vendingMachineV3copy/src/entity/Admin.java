package entity;


import interfaces.AdminVendingMachine;

public class Admin{

  private AdminVendingMachine vendingMachine;

  private String name;

  public Admin(AdminVendingMachine vendingMachine, String name) {
    this.vendingMachine = vendingMachine;
    this.name = name;
  }

  public AdminVendingMachine getVendingMachine() {
    return vendingMachine;
  }

  public void addQuantityForAProduct(Product product, Integer quantity) {
    vendingMachine.addQuantityForAProduct(product,quantity);
  }

  public void printCoinsInMachine() {
    vendingMachine.printCoinsInMachine();
  }

  public void addChangeInsideMachine(Coin coin, Integer quantity) {
    vendingMachine.getCoinInventoryManagement().addQuantity(coin,quantity);
  }


}
