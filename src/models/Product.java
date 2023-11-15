package models;

import java.util.Objects;

public class Product {
  private String name, description;
  private Double price;
  private Integer quantity;

  public Product() {}

  public Product(String name, Double price, Integer quantity) {
    this.setName(name);
    this.setPrice(price);
    this.setQuantity(quantity);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == "" || Objects.isNull(name)) {
      throw new RuntimeException("Product name is required!");
    }

    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    if (Objects.isNull(price)) {
      throw new RuntimeException("Price item is required!");
    }

    if (price < 0) {
      this.price = 0.;
    } else {
      this.price = price;
    }
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    if (Objects.isNull(quantity)) {
      throw new RuntimeException("Quantity item is required!");
    }

    if (quantity < 0) {
      this.quantity = 0;
    } else {
      this.quantity = quantity;
    }
  }

  @Override
  public String toString() {
    return "Product [name=" + name + ", description=" + description + ", price=" + price
        + ", quantity=" + quantity + "]";
  }
}
