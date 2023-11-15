package services.order;

import models.Order;

public interface OrderService {
  void registerOrder(Order order);

  void showAllOrder();

  void showOrderById(Integer id);
}
