package interfaces;

import entity.Product;

public interface VendingMachine {
  void selectProduct(Product product);
  void setDisplay();
  void processAmount();
  void handle();
  void insertCoinForPayment(Integer integer);
}
