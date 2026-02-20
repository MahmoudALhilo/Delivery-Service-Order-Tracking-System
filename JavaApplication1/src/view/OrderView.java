package view;

import controller.OrderController;
import Model.Item;
import Model.OrderItem;

public class OrderView {

    public void printOrderSummary(OrderController controller) {

        Model.Order order = controller.getOrder();

        System.out.println("========== ORDER SUMMARY ==========");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Date: " + order.getOrderDate());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Items:");

        for (OrderItem oi : order.getItems()) {
            System.out.println("- " + oi.getItem().getName()
                    + " x" + oi.getQuantity()
                    + " = " + oi.subtotal());
        }

        System.out.println("Total: " + controller.getTotal());
        System.out.println("==================================");
    }

    // عناصر تجريبية
    public Item sampleBurger() {
        return new Item(1, "Burger", 20.0);
    }

    public Item sampleFries() {
        return new Item(2, "Fries", 10.0);
    }
}