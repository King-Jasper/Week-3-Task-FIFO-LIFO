package org.example;

import org.example.entities.Order;
import org.example.product.Product;
import org.example.staffs.Cashier;

import java.util.*;

public class Store {
    private static   List<Product> productList = new ArrayList<>();
    private static  List<Cashier> cashierList = new ArrayList<>();

    private static  List<Order> orders = new ArrayList<>();
    private static  Queue<Order> regularQueue = new LinkedList<>();


    private static  Queue<Order> vipQueue = new PriorityQueue<>(new Comparator<Order>() {
        @Override
        public int compare(Order o2, Order o1) {
            return Integer.compare(o1.getCartSize(), o2.getCartSize());
        }
    });

    private static double storeBalance;

    public static List<Product> getProductList() {
        return productList;
    }

    public static List<Cashier> getCashierList() {
        return cashierList;
    }

    public static Queue<Order> getRegularQueue() {
        return regularQueue;
    }

    public static List<Order> getOrders() {
        return orders;
    }

    public static Queue<Order> getVipQueue() {
        return vipQueue;
    }

    public static double getStoreBalance() {
        return storeBalance;
    }

    public static void setStoreBalance(double storeBalance) {
        Store.storeBalance = storeBalance;
    }

}
