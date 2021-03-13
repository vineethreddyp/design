package interfaces;

import entity.Coin;
import entity.Product;

public interface AdminVendingMachine {

  void addQuantityForAProduct(Product product, Integer quantity);
  void printCoinState();
  void addChangeInsideMachine( Coin coin, Integer quantity);
}
