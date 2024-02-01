package org.example;

import java.util.ArrayList;
import java.util.List;

public class CustomerStorage {
    private List<Customer> customers = new ArrayList<>();

    private static CustomerStorage customerStorage;
    private CustomerStorage() {
    }

    public static CustomerStorage getInstance() {
        if (customerStorage == null) {
            customerStorage = new CustomerStorage();
        }
        return customerStorage;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}