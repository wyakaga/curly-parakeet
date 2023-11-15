package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Customer;
import utils.BaseDao;

public class CustomerDao implements BaseDao<Customer, Integer> {
  List<Customer> customers = new ArrayList<>(Arrays.asList(new Customer("john@doe.com")));

  @Override
  public void save(Customer data) {
    this.customers.add(data);
  }

  @Override
  public List<Customer> findAll() {
    return this.customers;
  }

  @Override
  public Customer findById(Integer id) {
    return this.customers.get(id - 1);
  }

  @Override
  public void update(Integer id, Customer data) {
    this.customers.set(id - 1, data);
  }

  @Override
  public void delete(Integer id) {
    this.customers.remove(id - 1);
  }

  @Override
  public Integer size() {
    return this.customers.size();
  }
}
