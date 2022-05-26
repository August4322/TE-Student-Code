package com.techelevator.example;

public class BankAccount {

    private String accountNumber;

    private double credits = 100;
    private double debits = 25;

    public BankAccount() {

    }

    public BankAccount(double credits, double debits) {
        this.credits = credits;
        this.debits = debits;
    }

    //The getter enables us to manipulate the data we return so that we could mask our accountnumber
    public String getAccountNumber() {
        return "**********" + accountNumber.substring(accountNumber.length()-4);
    }

    // when we calculate or create the property this is known as a derived property
    public double getTotalBalance(){
        return credits - debits;
    }
}
