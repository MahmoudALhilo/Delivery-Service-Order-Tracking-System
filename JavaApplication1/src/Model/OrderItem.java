package Model;

public class OrderItem {

    private Item item;
    private int quantity;

    public OrderItem(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double subtotal() {
        return item.getPrice() * quantity;
    }
}