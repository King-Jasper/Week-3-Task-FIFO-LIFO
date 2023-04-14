package org.example.utilities;

import org.example.entities.CustomerInterface;

import java.util.Comparator;

public class CustomerIdComparator implements Comparator<CustomerInterface> {
    @Override
    public int compare(CustomerInterface o1, CustomerInterface o2) {
        return Integer.compare(o1.getCustomerId(), o2.getCustomerId());
    }
}
