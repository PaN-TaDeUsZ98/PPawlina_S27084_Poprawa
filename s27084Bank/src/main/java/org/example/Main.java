package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        CustomerService customerService = context.getBean(CustomerService.class);

        int customerId = 3;
        double initialBalance = 27084;
        customerService.registerCustomer(customerId, initialBalance);
        System.out.println("Klient zarejestrowany.");

        double depositAmount = 2916;
        TransactionResponse depositResponse = customerService.deposit(customerId, depositAmount);
        System.out.println("Nowe saldo: " + depositResponse.getNewBalance());

        Customer customer = customerService.getCustomer(customerId);
        if (customer != null) {
            System.out.println("Dane klienta: ID - " + customerId + ", Saldo - " + customer.getBalance());
        } else {
            System.out.println("Klient nie został znaleziony.");
        }
    }
}
