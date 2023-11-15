package services.customer;

import java.util.List;
import java.util.Objects;
import dao.CustomerDao;
import models.Customer;

public class CustomerServiceImpl implements CustomerService {
  CustomerDao customerDao;

  public CustomerServiceImpl(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void registerCustomer(Customer customer) {
    if (Objects.isNull(customer)) {
      throw new RuntimeException("Customer is required!");
    }

    customerDao.save(customer);
    System.out.println("Customer registered!");
  }

  @Override
  public void showAllCustomer() {
    List<Customer> customers = customerDao.findAll();

    for (int i = 0; i < customers.size(); i++) {
      System.out.println((i + 1) + ". " + customers.get(i));
    }
  }

  @Override
  public void showCustomerById(Integer id) {
    if (id < customerDao.size()) {
      throw new RuntimeException("id is not found!");
    }

    Customer customer = customerDao.findById(id);
    System.out.println(customer);
  }

  @Override
  public Customer getCustomerById(Integer id) {
    if (id < customerDao.size()) {
      throw new RuntimeException("id is not found!");
    }

    Customer customer = customerDao.findById(id);
    return customer;
  }
}
