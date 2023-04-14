package org.example.entities;

//import org.apache.commons.math3.stat.descriptive.summary.Product;

import org.example.product.Product;

import java.util.ArrayList;

public class CustomerInterface implements org.example.services.CustomerInterface {

    private String name;
    private double walletBalance;
    private final int CustomerId;
    private final ArrayList<Product> cart;


    public CustomerInterface(String name, double walletBalance, int CustomerId) {
        this.name = name;
        this.walletBalance = walletBalance;
        this.CustomerId = CustomerId;
        this.cart = new ArrayList<>();
    }

    public String getName() {

        return name;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    @Override
    public void makePayment(double amount) {
        this.walletBalance -= amount;
        System.out.println("You have been debited!" + "$" + amount);
        System.out.println("Balance:" + "$" + walletBalance);

    }

    @Override
    public double getWalletBalance() {
        System.out.println("Balance" + "$" + walletBalance);
        return walletBalance;
    }

    @Override
    public void addToCart(Product product, int quantity) {
        Product selectedProduct = new Product(product.getName(), product.getPrice(), quantity);
        cart.add(selectedProduct);
        String s = String.format("%s added %d %s to their cart\n", this.getName(), quantity, product.getName());
        System.out.println(s);
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }

    public Order checkout() {
        return new Order(this);

    }
}


