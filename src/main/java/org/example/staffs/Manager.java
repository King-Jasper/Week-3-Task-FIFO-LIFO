package org.example.staffs;

import org.example.Store;
import org.example.product.Product;

public class Manager extends Staff {


    public Manager(String name, String staffID) {
        super(name, staffID);
    }


    public void addProductToStore(Product product) {

        Store.getProductList().add(product);
    }


}


