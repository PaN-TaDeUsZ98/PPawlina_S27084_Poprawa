package org.example;

public class CustomerService {
    private final CustomerStorage customerStorage;

    public CustomerService(CustomerStorage customerStorage) {
        this.customerStorage = customerStorage;
    }

    public void registerCustomer(int id, double initialBalance) {
        Customer newCustomer = new Customer();
        newCustomer.setId(id);
        newCustomer.setBalance(initialBalance);
        customerStorage.addCustomer(newCustomer);
    }

    public TransactionResponse transfer(int customerId, double amount) {
        Customer customer = customerStorage.getCustomerById(customerId);
        if (customer == null || customer.getBalance() < amount) {
            return new TransactionResponse(TransactionStatus.DECLINED, 0);
        }
        customer.setBalance(customer.getBalance() - amount);
        return new TransactionResponse(TransactionStatus.ACCEPTED, customer.getBalance());
    }

    public TransactionResponse deposit(int customerId, double amount) {
        Customer customer = customerStorage.getCustomerById(customerId);
        if (customer == null) {
            return new TransactionResponse(TransactionStatus.DECLINED, 0);
        }
        customer.setBalance(customer.getBalance() + amount);
        return new TransactionResponse(TransactionStatus.ACCEPTED, customer.getBalance());
    }

    public Customer getCustomer(int customerId) {
        return customerStorage.getCustomerById(customerId);
    }
}
