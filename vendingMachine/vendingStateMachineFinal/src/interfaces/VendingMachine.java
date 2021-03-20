package interfaces;

import entity.Product;

public interface VendingMachine {
  void selectProduct(Product product);
  void insertCoinForPayment(Integer integer);
  void action(); // after moving to next state, an action is performed by machine
}
