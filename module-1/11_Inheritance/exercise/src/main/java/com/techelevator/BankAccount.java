package com.techelevator;

public class BankAccount {

    //Instance Variables
    private String accountHolderName;
    private String accountNumber;
    private int balance = 0;

    //Constructors
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //Getters
    public String getAccountHolderName() {return accountHolderName;}
    public String getAccountNumber() {return accountNumber;}
    public int getBalance() {
        return balance;
    }

    //Methods
    public int deposit(int amountToDeposit) {
        this.balance += amountToDeposit;
        return this.balance;
    }

    public int withdraw(int amountToWithdraw) {
        this.balance -= amountToWithdraw;
        return this.balance;
    }


}
