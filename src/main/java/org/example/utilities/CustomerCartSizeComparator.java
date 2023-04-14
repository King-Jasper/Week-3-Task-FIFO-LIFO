package org.example.utilities;

import org.example.entities.CustomerInterface;

import java.util.Comparator;

public class CustomerCartSizeComparator implements Comparator<CustomerInterface> {

    @Override
    public int compare(CustomerInterface o2, CustomerInterface o1) {
        return Integer.compare(o1.getCart().size(), o2.getCart().size());
    }
}
