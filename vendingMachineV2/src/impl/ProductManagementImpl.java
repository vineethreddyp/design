package impl;

import entity.Product;
import interfaces.InventoryManagement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManagementImpl implements InventoryManagement<Product> {

  private Map<Product, Integer> productQuantityMap;

  public ProductManagementImpl(){
    productQuantityMap = new HashMap<>();
  }

  @Override
  public void addQuantity( Product product, Integer quantity){
    if(productQuantityMap.containsKey(product)){
      Integer valPresent = productQuantityMap.get(product);
      productQuantityMap.put(product, valPresent + quantity);
    }
    else {
      productQuantityMap.put(product, quantity);
    }
  }

  @Override
  public void decrementAQuantity(Product product){
    productQuantityMap.put(product, productQuantityMap.get(product) -1);
  }

  public Map<Product, Integer> getProductQuantityMap() {
    return productQuantityMap;
  }

  @Override
  public void displayQuantityOfItems(){
    List<String> productStringList = new ArrayList<>();
    System.out.println("Product list");
    for(Product product : this.getProductQuantityMap().keySet()){
      productStringList.add(product.toString() + ": each Rs: " + product.getCost() + " Quantity avaialble: " + productQuantityMap.get(product));
    }
    System.out.println(String.join("\n",productStringList));
  }


}
