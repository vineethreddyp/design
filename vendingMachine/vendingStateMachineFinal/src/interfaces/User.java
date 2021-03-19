package interfaces;

import entity.Product;

public interface User {
  void selectProduct(VendingMachine vendingMachine, Product product);
  void insertCoinForPayment(VendingMachine vendingMachine, Integer integer);
}
