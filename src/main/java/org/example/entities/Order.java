package org.example.entities;

import org.example.Store;
import org.example.product.Product;

import java.util.Comparator;
import java.util.List;

public class Order  implements Comparator<Order> {

    private int orderId;

    private CustomerInterface customer;

    private int cartSize;

    private double totalAmount;

    public Order(CustomerInterface customer) {
        this.totalAmount = calculateTotalPriceOfGoods(customer.getCart());
        this.cartSize = customer.getCart().size();
        this.customer= customer;
        orderId = Store.getOrders().size() + 1;
        // add to a list to track all orders

        Store.getOrders().add(this);

        // add to a queue to process based on FIFO
        Store.getRegularQueue().add(this);

        // add to another to process based on Cart size
        Store.getVipQueue().add(this);
    }

    private double calculateTotalPriceOfGoods(List<Product> cart) {
        double amount = 0;
        for (Product product : cart){
            amount+= product.getPrice() * product.getQuantity();
        }
        return amount;
    }

    public CustomerInterface getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", cartSize=" + cartSize +
                ", totalAmount=" + totalAmount +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCartSize() {
        return cartSize;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public int compare(Order o1, Order o2) {
        return 0;
    }
}
