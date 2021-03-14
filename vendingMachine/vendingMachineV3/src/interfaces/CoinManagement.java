package interfaces;

import entity.Coin;

public interface CoinManagement {
  void displayQuantityOfItems();
  void addQuantity(Coin coin ,Integer quantity);
  boolean disperseChange(Integer val);
}
