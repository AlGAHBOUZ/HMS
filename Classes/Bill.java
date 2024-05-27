package model;

import java.util.Date;

public class Bill {
    private float amount;
    private String category;
    private String classification;
    private String paymentMethod;
    private Date dueDate;
    private FinanceManager financeManager;

    public Bill(float amount, String category, String classification, String paymentMethod, Date dueDate, FinanceManager financeManager) {
        this.amount = amount;
        this.category = category;
        this.classification = classification;
        this.paymentMethod = paymentMethod;
        this.dueDate = dueDate;
        this.financeManager = financeManager;
    }

    // Getters and Setters
}
