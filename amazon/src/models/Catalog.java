package models;

import enums.Category;
import interfaces.Search;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Catalog implements Search {

  private List<Item> itemList;
  private Map<Category, List<Product>> categoryListMap; // indexing here


  public List<Product> findProductsByCategory(Category productCategory){
    return new ArrayList<>();
  }

  public List<Product> findProductsByName(String productNames){
    return new ArrayList<>();
  }

}
