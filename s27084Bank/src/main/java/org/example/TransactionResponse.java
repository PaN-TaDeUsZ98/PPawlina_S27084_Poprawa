package org.example;

public class TransactionResponse {
    private TransactionStatus status;
    private double newBalance;

    public TransactionResponse(TransactionStatus status, double newBalance) {
        this.status = status;
        this.newBalance = newBalance;
    }

    public double getNewBalance() {
        return newBalance;
    }
}
