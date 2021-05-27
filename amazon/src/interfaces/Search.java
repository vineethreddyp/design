package interfaces;

import enums.Category;
import java.util.List;
import models.Product;

public interface Search {

  List<Product> findProductsByCategory(Category productCategory);
  List<Product> findProductsByName(String productNames);

}
