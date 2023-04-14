package org.example.services;

import org.example.Store;
import org.example.product.Product;
import org.example.staffs.Cashier;
import org.example.staffs.Manager;

import java.util.List;

public class ManagerServices implements ManagerInterface{
    private Manager manager;

    public ManagerServices(Manager manager){
        this.manager = manager;

    }
@Override
    public void hireCashier(Cashier cashier) {
        Store.getCashierList().add(cashier);
        System.out.println(cashier.getName() + "Is already hired by me");
        System.out.println();

    }
    @Override
    public void fireCashier(Cashier cashier) {
        List<Cashier> cashiers = Store.getCashierList();
        for (Cashier cashier1 : cashiers) {
            if (cashier1.getName().equals((cashier.getName()))) {
                cashiers.remove(cashier1);
                System.out.println("You are fired with immediate effect" + cashier.getName() + " " + "with Staff ID:");
            } else {
                System.out.println(cashier.getName() + "appointment has been terminated");
            }
        }
    }
    public void addProductToStore(Product product) {

        Store.getProductList().add(product);
    }


}
