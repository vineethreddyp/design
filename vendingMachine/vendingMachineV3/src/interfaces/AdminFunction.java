package interfaces;


import entity.Coin;
import entity.Product;

public interface AdminFunction {
  void addQuantityForAProduct(Product product, Integer quantity);
  void printCoinsInMachine();
  void addChangeInsideMachine(Coin coin, Integer quantity);
}
