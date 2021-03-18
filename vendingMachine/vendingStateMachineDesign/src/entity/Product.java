package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Product {

  Coke("Coke",25), Pepsi("Pepsi",35), Soda("Soda",45);
  private String name;
  private Integer cost;

  private static Map<String, Product> productMap;
  private static String validProductList;

  static {
    productMap = new HashMap<>();
    List<String> productList = new ArrayList<>();
    for(Product product : Product.values()){
      productList.add(product.getName());
      productMap.put(product.getName(), product);
    }
    validProductList = String.join(",", productList);
  }
  Product(String name, Integer cost) {
    this.name = name;
    this.cost = cost;
  }

  public String getName() {
    return name;
  }

  public Integer getCost() {
    return cost;
  }

  public static Product findByName(String name){
   return productMap.get(name);
  }

  public static String getValidProdcutList(){
    return validProductList;
  }

}
