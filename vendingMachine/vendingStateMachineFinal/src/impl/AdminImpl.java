package impl;


import datastore.StateMachineStore;
import entity.Coin;
import entity.Product;
import interfaces.Admin;

public class AdminImpl implements Admin {

  private String name;
  private StateMachineStore stateMachineStore;

  public AdminImpl(String name, StateMachineStore stateMachineStore) {
    this.name = name;
    this.stateMachineStore = stateMachineStore;
  }

  @Override
  public void addQuantityForAProduct(Product product, Integer quantity) {
    stateMachineStore.getProductInventoryManagement().addQuantity(product,quantity);
  }

  @Override
  public void printCoinsInMachine() {
    stateMachineStore.getCoinInventoryManagement().displayQuantityOfItems();
  }

  @Override
  public void addChangeInsideMachine(Coin coin, Integer quantity) {
    stateMachineStore.getCoinInventoryManagement().addQuantity(coin,quantity);
  }

  @Override
  public void makeMachineAvailableForUsers() {
    stateMachineStore.setIdleState();
  }

  @Override
  public void setInAdminMode() {
    stateMachineStore.setAdminState();
  }


}
