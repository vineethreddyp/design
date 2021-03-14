package impl;


import entity.Coin;
import entity.Product;
import interfaces.AdminFunction;
import interfaces.CoinManagement;
import interfaces.ProductManagment;

public class AdminImpl implements AdminFunction {

  private ProductManagment productManagment;
  private CoinManagement coinManagement;
  private String name;

  public AdminImpl(String name, ProductManagment productManagment, CoinManagement coinManagement) {
    this.name = name;
    this.productManagment = productManagment;
    this.coinManagement = coinManagement;
  }

  @Override
  public void addQuantityForAProduct(Product product, Integer quantity) {
    productManagment.addQuantity(product,quantity);
  }

  @Override
  public void printCoinsInMachine() {
    coinManagement.displayQuantityOfItems();
  }

  @Override
  public void addChangeInsideMachine(Coin coin, Integer quantity) {
    coinManagement.addQuantity(coin,quantity);
  }


}
