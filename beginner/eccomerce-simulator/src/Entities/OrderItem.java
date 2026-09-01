package Entities;

public class OrderItem {
    private Product product;
    private int quantity;
    private double price;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice();
    }

    public double subtotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return product + ", Quantity: " + quantity + ", Subtotal: " + String.format("%.2f", subtotal());
    }
}
