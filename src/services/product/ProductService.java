package services.product;

import models.Product;

public interface ProductService {
  void registerProduct(Product product);

  void showAllProduct();

  void showProductById(Integer id);

  Product getProductById(Integer id);
}
