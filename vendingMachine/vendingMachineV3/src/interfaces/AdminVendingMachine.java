package interfaces;

import entity.Coin;
import entity.InventoryManagement;
import entity.Product;

public interface AdminVendingMachine {
  void addQuantityForAProduct(Product product, Integer quantity);
  void printCoinsInMachine();
  InventoryManagement<Coin> getCoinInventoryManagement();
}
