package services.product;

import java.util.List;
import java.util.Objects;
import dao.ProductDao;
import models.Product;

public class ProductServiceImpl implements ProductService {
  ProductDao productDao;

  public ProductServiceImpl(ProductDao productDao) {
    this.productDao = productDao;
  }

  @Override
  public void registerProduct(Product product) {
    if (Objects.isNull(product)) {
      throw new RuntimeException("Product is required!");
    }

    productDao.save(product);
    System.out.println("Product created!");
  }

  @Override
  public void showAllProduct() {
    List<Product> products = productDao.findAll();

    for (int i = 0; i < products.size(); i++) {
      System.out.println((i + 1) + ". " + products.get(i));
    }
  }

  @Override
  public void showProductById(Integer id) {
    if (id < productDao.size()) {
      throw new RuntimeException("id is not found!");
    }

    Product product = productDao.findById(id);
    System.out.println(product);
  }

  @Override
  public Product getProductById(Integer id) {
    if (id < productDao.size()) {
      throw new RuntimeException("id is not found!");
    }

    Product product = productDao.findById(id);
    return product;
  }
}
