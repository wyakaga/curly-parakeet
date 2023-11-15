package models;

import java.util.Objects;

public class Order {
  private Transaction transaction;
  private Product product;
  private Integer quantity;
  private Double price;

  public Order() {}

  public Order(Transaction transaction, Product product, Integer quantity, Double price) {
    this.setTransaction(transaction);
    this.setProduct(product);
    this.setQuantity(quantity);
    this.setPrice(price);
  }

  public Transaction getTransaction() {
    return transaction;
  }

  public void setTransaction(Transaction transaction) {
    this.transaction = transaction;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    if (Objects.isNull(product)) {
      throw new RuntimeException("Product is required!");
    }

    this.product = product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    if (quantity < 0) {
      throw new RuntimeException("Quantity must be positive number!");
    }

    this.quantity = quantity;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    if (price < 0.) {
      throw new RuntimeException("Price must be positive number!");
    }

    this.price = price;
  }

  @Override
  public String toString() {
    return "Order [transaction=" + transaction + ", product=" + product + ", quantity=" + quantity
        + ", price=" + price + "]";
  }
}
