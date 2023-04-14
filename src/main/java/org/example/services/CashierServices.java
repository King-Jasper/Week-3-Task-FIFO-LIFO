package org.example.services;

import org.example.Store;
import org.example.entities.CustomerInterface;
import org.example.entities.Order;
import org.example.product.Product;
import org.example.staffs.Cashier;

import java.util.ArrayList;

public class CashierServices implements  CashierInterface{
    private Cashier cashier;

    public CashierServices(Cashier cashier) {
        this.cashier = cashier;

    }
    @Override

    public void attendFirstComeFirstServe() {

        Order order = Store.getRegularQueue().poll();
        if (order ==null){
            System.out.println( "No customer orders available");
        }

        else {
            CustomerInterface customer = order.getCustomer();
            double total = 0.0;
            System.out.println("Attending to : ==> " + customer.getName());
            for (Product item : customer.getCart()) {
//              System.out.println("item picked: " + item.getName() + "Qty:" + item.getQuantity());
                total += item.getPrice() * item.getQuantity();
                updateProductQuantity(item, item.getQuantity());

            }
            System.out.println("Cart Total:" + total);
            // To check customers wallet balance and deduct his money after payment
            if (customer.getWalletBalance() >= total) {
                customer.makePayment(total);
                Store.setStoreBalance(Store.getStoreBalance() + total);
                signReceipt(customer, customer.getCart(), total);
            } else {
                System.out.println("Payment can not be Completed due to insufficient fund");
            }

        }
        //To check customers wallet balance and deduct his money after payment
    }
@Override
    public void updateProductQuantity(Product product, int quantity) {
        for (Product storeProduct : Store.getProductList()) {
            if (storeProduct.getName().equals(product.getName())) {
                storeProduct.setQuantity(storeProduct.getQuantity() - quantity);
                break;
            }
        }
    }

    //Updating the customer's cart, the quantity of item picked and the customer payment.
@Override
    public void attendToHighestCartSize() {

        Order order = Store.getVipQueue().poll();
        if (order ==null){
            System.out.println( "No customer orders available");
        }

        else {
            CustomerInterface customer = order.getCustomer();
            double total = 0.0;
            System.out.println("Attending to : ==> " + customer.getName());
            for (Product item : customer.getCart()) {
//              System.out.println("item picked: " + item.getName() + "Qty:" + item.getQuantity());
                total += item.getPrice() * item.getQuantity();
                updateProductQuantity(item, item.getQuantity());

            }
            System.out.println("Cart Total:" + total);
            // To check customers wallet balance and deduct his money after payment
            if (customer.getWalletBalance() >= total) {
                customer.makePayment(total);
                Store.setStoreBalance(Store.getStoreBalance() + total);
                signReceipt(customer, customer.getCart(), total);
            } else {
                System.out.println("Payment can not be Completed due to insufficient fund");
            }

        }
        //To check customers wallet balance and deduct his money after payment
    }
    private void signReceipt (CustomerInterface customer, ArrayList< Product > products, double total){

        System.out.println();
        System.out.println("Receipt");
        System.out.println("Name:" + customer.getName());
        for (Product item : products)
            System.out.println(item.toString());
        System.out.println("Total: " + total);
        customer.getCart().clear();
    }

    public void addCustomerToTheQueue(CustomerInterface customer) {
        try {
            cashier.getCustomersQueue().add(customer);
            String s = String.format("%s with ID: %d just joined the queue with %d items in their cart...\n", customer.getName(), customer.getCustomerId(), customer.getCart().size());
            System.out.println(s);
        } catch (NullPointerException | ClassCastException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}