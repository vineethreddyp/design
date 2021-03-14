package interfaces;

import entity.Product;

public interface ProductManagment {
  void displayQuantityOfItems();
  void addQuantity(Product product, Integer quantity);
  void decrementAQuantity(Product product);
}
