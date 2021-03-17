package interfaces;


import entity.Coin;
import entity.Product;

public interface Admin {
  void addQuantityForAProduct(Product product, Integer quantity);
  void printCoinsInMachine();
  void addChangeInsideMachine(Coin coin, Integer quantity);
}
