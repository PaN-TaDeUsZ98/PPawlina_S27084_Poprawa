package org.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController {
    private final CustomerService customerService;

    public BankController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public void registerCustomer(@RequestParam int id, @RequestParam double balance) {
        customerService.registerCustomer(id, balance);
    }

    @PostMapping("/transfer")
    public TransactionResponse transfer(@RequestParam int customerId, @RequestParam double amount) {
        return customerService.transfer(customerId, amount);
    }

    @PostMapping("/deposit")
    public TransactionResponse deposit(@RequestParam int customerId, @RequestParam double amount) {
        return customerService.deposit(customerId, amount);
    }

    @GetMapping("/customer")
    public Customer getCustomer(@RequestParam int customerId) {
        return customerService.getCustomer(customerId);
    }
}
