package org.example.staffs;

//import org.apache.commons.math3.stat.descriptive.summary.Product;

import org.example.entities.CustomerInterface;
import org.example.entities.Person;
import org.example.utilities.CustomerCartSizeComparator;
import org.example.utilities.CustomerIdComparator;

import java.util.PriorityQueue;
import java.util.Queue;

public class Cashier extends Person  {
    private final String staffID;

    Queue<CustomerInterface> customersQueue;
    public Cashier(String name, String staffID, CustomerIdComparator idComparator) {
        super(name);
        this.staffID = staffID;
        this.customersQueue = new PriorityQueue<>(10, idComparator);
    }

    public Cashier(String name, String staffID, CustomerCartSizeComparator cartComparator) {
        super(name);
        this.staffID = staffID;
        this.customersQueue = new PriorityQueue<>(10, cartComparator);

    }

    public String getStaffID() {
        return staffID;
    }

    public Queue<CustomerInterface> getCustomersQueue() {
        return customersQueue;
    }
}



