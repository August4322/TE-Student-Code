package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    //Instance Variables
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    //Getters
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

//    public List<Accountable> getAccounts() {
//        return accounts;
//    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //Methods
    public Accountable[] getAccounts() {
        Accountable[] availableAccounts = new Accountable[accounts.size()];
        accounts.toArray(availableAccounts);
        return availableAccounts;
    }

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

    public boolean isVip() {
        int sumOfAccounts = 0;
        for (Accountable theAccounts : accounts) {
            sumOfAccounts += theAccounts.getBalance();
        }
        return sumOfAccounts >= 25000;
    }

}

