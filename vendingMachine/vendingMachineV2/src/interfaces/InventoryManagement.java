package interfaces;

public interface InventoryManagement<T> {
  void addQuantity( T item, Integer quantity);
  void decrementAQuantity(T item);
  void displayQuantityOfItems();

}
