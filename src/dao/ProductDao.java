package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Product;
import utils.BaseDao;

public class ProductDao implements BaseDao<Product, Integer> {
  List<Product> products = new ArrayList<>(Arrays.asList(new Product("AK-47", 110.0, 1000)));

  @Override
  public void save(Product data) {
    this.products.add(data);
  }

  @Override
  public List<Product> findAll() {
    return this.products;
  }

  @Override
  public Product findById(Integer id) {
    return this.products.get(id - 1);
  }

  @Override
  public void update(Integer id, Product data) {
    this.products.set(id - 1, data);
  }

  @Override
  public void delete(Integer id) {
    this.products.remove(id - 1);
  }

  @Override
  public Integer size() {
    return this.products.size();
  }
}
