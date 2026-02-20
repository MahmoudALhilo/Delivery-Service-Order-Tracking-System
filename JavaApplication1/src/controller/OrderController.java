package controller;

import Model.Item;
import Model.Order;
import Model.OrderStatus;

public class OrderController {

    private Order order;

    public void createOrder(int orderId) {
        order = new Order(orderId);
    }

    public Order getOrder() {
        return order;
    }

    public void addItemToOrder(Item item, int qty) {
        order.addItem(item, qty);
    }

    public double getTotal() {
        return order.calculateTotal();
    }

    public boolean cancelOrder() {
        return order.cancel();
    }

    public boolean changeStatus(OrderStatus status) {
        return order.updateStatus(status);
    }
}