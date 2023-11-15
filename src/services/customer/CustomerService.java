package services.customer;

import models.Customer;

public interface CustomerService {
  void registerCustomer(Customer customer);

  void showAllCustomer();

  void showCustomerById(Integer id);

  Customer getCustomerById(Integer id);
}
