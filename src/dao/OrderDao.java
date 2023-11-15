package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Order;
import utils.BaseDao;

public class OrderDao implements BaseDao<Order, Integer> {
  List<Order> orders = new ArrayList<>(Arrays.asList(new Order()));

  @Override
  public void save(Order data) {
    this.orders.add(data);
  }

  @Override
  public List<Order> findAll() {
    return this.orders;
  }

  @Override
  public Order findById(Integer id) {
    return this.orders.get(id - 1);
  }

  @Override
  public void update(Integer id, Order data) {
    this.orders.set(id - 1, data);
  }

  @Override
  public void delete(Integer id) {
    this.orders.remove(id - 1);
  }

  @Override
  public Integer size() {
    return this.orders.size();
  }
}
