package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private final int orderId;
    private final LocalDateTime orderDate;
    private OrderStatus status;
    private final List<OrderItem> items;
    

    public Order(int orderId) {
        this.orderId = orderId;
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.NEW;
        this.items = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(Item item, int quantity) {
        items.add(new OrderItem(item, quantity));
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem oi : items) {
            total += oi.subtotal();
        }
        return total;
    }

    public boolean cancel() {
        if (status == OrderStatus.NEW) {
            status = OrderStatus.CANCELLED;
            return true;
        }
        return false;
    }
    

    public boolean updateStatus(OrderStatus newStatus) {
        if (status == OrderStatus.CANCELLED) return false;

        if (newStatus == OrderStatus.DELIVERED && status != OrderStatus.ON_THE_WAY) {
            return false;
        }
        status = newStatus;
        return true;
    }
}