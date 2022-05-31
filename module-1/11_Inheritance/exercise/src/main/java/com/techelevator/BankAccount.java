package com.techelevator;

public class BankAccount {

    private String accountHolderName;
    private String accountNumber;
    private int balance = 0;

    //Constructors
    public BankAccount(String accountHolderName, String accountNumber) {

    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {

    }


    //Getters
    public int getBalance() {
        return balance;
    }


    //Setters



    //Methods
    public int withdraw(int amountToWithdraw) {
        this.balance -= amountToWithdraw;
        return this.balance;
    }


}
