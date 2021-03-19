package interfaces;

import entity.Product;

public interface VendingMachine {
  void selectProduct(Product product);
//  void processAmount();
  void insertCoinForPayment(Integer integer);
}
