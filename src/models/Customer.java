package models;

import java.util.Objects;

/**
 * Customer
 */
public class Customer {
  private String firstName, lastName, email;

  public Customer() {}

  public Customer(String email) {
    this.setEmail(email);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    if (email == "" || Objects.isNull(email)) {
      throw new RuntimeException("Email is required!");
    }

    this.email = email;
  }

  @Override
  public String toString() {
    return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
  }
}
