import controller.OrderController;
import Model.OrderStatus;
import view.OrderView;

public class Main {

    public static void main(String[] args) {

        OrderController controller = new OrderController();
        OrderView view = new OrderView();

        // طلب رقم 1
        controller.createOrder(1001);
        controller.addItemToOrder(view.sampleBurger(), 2);
        controller.addItemToOrder(view.sampleFries(), 1);

        view.printOrderSummary(controller);

        System.out.println("Cancel order? " + controller.cancelOrder());
        view.printOrderSummary(controller);

        // طلب رقم 2 للتجربة
        controller.createOrder(1002);
        controller.addItemToOrder(view.sampleBurger(), 1);

        controller.changeStatus(OrderStatus.ACCEPTED);
        controller.changeStatus(OrderStatus.ON_THE_WAY);
        System.out.println("Deliver? " + controller.changeStatus(OrderStatus.DELIVERED));

        view.printOrderSummary(controller);
    }
}