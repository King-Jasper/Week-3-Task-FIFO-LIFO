package org.example.services;

import org.example.product.Product;

public interface CashierInterface {


     void updateProductQuantity(Product product, int quantity);



    //Updating the customer's cart, the quantity of item picked and the customer payment.
    void attendToHighestCartSize();

    void attendFirstComeFirstServe();
}
