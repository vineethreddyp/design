package interfaces;


import entity.Product;

public interface AdminVendingMachine {
  void addQuantityForAProduct(Product product, Integer quantity);
  void printCoinsInMachine();
  CoinManagement getCoinInventoryManagement();
}
