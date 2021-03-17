package entity;

import java.util.ArrayList;
import java.util.List;

public class ProductManagement extends InventoryManagement<Product> {

  @Override
  public void displayQuantityOfItems(){
    List<String> productStringList = new ArrayList<>();
    System.out.println("Product list");
    for(Product product : this.getItemQuantityMap().keySet()){
      productStringList.add(product.toString() + ": each Rs: " + product.getCost() + " Quantity avaialble: " + this.getItemQuantityMap().get(product));
    }
    System.out.println(String.join("\n",productStringList));
  }

}
