package models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
  private LocalDateTime date = LocalDateTime.now();
  private Double totalAmount;
  private String status;
  private Customer customer;

  public Transaction() {}

  public Transaction(Double totalAmount, Customer customer) {
    this.setTotalAmount(totalAmount);
    this.setCustomer(customer);
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate() {
    this.date = LocalDateTime.now();
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    if (totalAmount < 0) {
      throw new RuntimeException("Total amount must be positive number");
    }

    this.totalAmount = totalAmount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    if (Objects.isNull(customer)) {
      throw new RuntimeException("Customer is required!");
    }

    this.customer = customer;
  }

  @Override
  public String toString() {
    return "Transaction [date=" + date + ", totalAmount=" + totalAmount + ", status=" + status
        + ", customer=" + customer + "]";
  }
}
