package impl;

import entity.InventoryManagement;
import entity.Product;
import interfaces.ProductManagment;
import java.util.ArrayList;
import java.util.List;

public class ProductManagementImpl implements ProductManagment {

  private InventoryManagement<Product> productInventoryManagement;

  public ProductManagementImpl(){
    productInventoryManagement = new InventoryManagement<>();
  }

  @Override
  public void displayQuantityOfItems(){
    List<String> productStringList = new ArrayList<>();
    System.out.println("Product list");
    for(Product product : productInventoryManagement.getItemQuantityMap().keySet()){
      productStringList.add(product.toString() + ": each Rs: " + product.getCost() + " Quantity avaialble: " + productInventoryManagement.getItemQuantityMap().get(product));
    }
    System.out.println(String.join("\n",productStringList));
  }

  @Override
  public void addQuantity(Product product, Integer quantity) {
    productInventoryManagement.addQuantity(product,quantity);
  }

  @Override
  public void decrementAQuantity(Product product) {
    productInventoryManagement.decrementAQuantity(product);
  }

  @Override
  public void getQuantityMap() {

  }

}
