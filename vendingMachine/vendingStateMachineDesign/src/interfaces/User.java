package interfaces;

import entity.Product;

public interface User {
  void selectProduct(Product product);
  void insertCoinForPayment(Integer integer);
}
