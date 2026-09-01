package Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date date;
    private Client client;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<OrderItem>();
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order(Client client, Date date, OrderStatus status) {
        this.date = date;
        this.client = client;
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public Client getClient() {
        return client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }
    public void removeItem(OrderItem item) {
        items.remove(item);
    }
    public double total() {
        double totalprice =0;
        for (OrderItem item : items) {
            totalprice += item.subtotal();
        }
        return totalprice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:\n");
        sb.append("Order moment: " + sdf.format(date) + "\n");
        sb.append("Order status: " + status + "\n");
        sb.append("Client: " + client + "\n");
        sb.append("Order items: ");
        for (OrderItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: " + String.format("%.2f", total()));
        return sb.toString();
    }
}
