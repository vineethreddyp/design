package entity;

import java.util.HashMap;
import java.util.Map;

public class InventoryManagement<T> {

  private Map<T, Integer> itemQuantityMap;

  public InventoryManagement() {
    this.itemQuantityMap = new HashMap<>();
  }

  public void addQuantity( T item, Integer quantity){
    if(itemQuantityMap.containsKey(item)){
      Integer valPresent = itemQuantityMap.get(item);
      itemQuantityMap.put(item, valPresent + quantity);
    }
    else {
      itemQuantityMap.put(item, quantity);
      }
  }

  public void decrementAQuantity(T item){
      itemQuantityMap.put(item, itemQuantityMap.get(item) -1);
  }

  public Map<T, Integer> getItemQuantityMap() {
    return itemQuantityMap;
  }

}
