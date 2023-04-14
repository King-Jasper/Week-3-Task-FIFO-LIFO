package org.example.services;

import org.example.product.Product;

public interface CustomerInterface {

    void makePayment(double amount);



     double getWalletBalance();



     void addToCart(Product product, int quantity);


}
