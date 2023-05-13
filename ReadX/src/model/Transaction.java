package model;

import java.util.Calendar;

public class Transaction {

    private User user;
    private BibliographicProduct bibliographicProduct;
    private Calendar transactionDate;
    private double amountPaid;

    public Transaction(User user, BibliographicProduct bibliographicProduct, double amountPaid){

        this.user = user;
        this.bibliographicProduct = bibliographicProduct;
        this.transactionDate = Calendar.getInstance();
        this.amountPaid = amountPaid;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BibliographicProduct getBibliographicProduct() {
        return bibliographicProduct;
    }

    public void setBibliographicProduct(BibliographicProduct bibliographicProduct) {
        this.bibliographicProduct = bibliographicProduct;
    }
    public Calendar getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Calendar transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
}