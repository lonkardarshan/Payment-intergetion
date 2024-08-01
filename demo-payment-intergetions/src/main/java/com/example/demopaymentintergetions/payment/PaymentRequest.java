package com.example.demopaymentintergetions.payment;

public class PaymentRequest {
    private String email;
    private double amount;

    // Getter and setter methods
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            // Set a default email address or throw an exception
            this.email = "default@example.com";
        } else {
            this.email = email;
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
