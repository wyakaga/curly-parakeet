package services.order;

import java.util.List;
import java.util.Objects;
import dao.OrderDao;
import models.Order;

public class OrderServiceImpl implements OrderService {
  OrderDao orderDao;

  public OrderServiceImpl(OrderDao orderDao) {
    this.orderDao = orderDao;
  }

  @Override
  public void registerOrder(Order order) {
    if (Objects.isNull(order)) {
      throw new RuntimeException("Order is required!");
    }

    orderDao.save(order);
    System.out.println("Order record saved!");
  }

  @Override
  public void showAllOrder() {
    List<Order> orders = orderDao.findAll();

    for (int i = 0; i < orders.size(); i++) {
      System.out.println((i + 1) + ". " + orders.get(i));
    }
  }

  @Override
  public void showOrderById(Integer id) {
    if (id < orderDao.size()) {
      throw new RuntimeException("id is not found!");
    }

    Order order = orderDao.findById(id);
    System.out.println(order);
  }
}
