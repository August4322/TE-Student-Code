package com.techelevator;

public class CheckingAccount extends BankAccount{

    //Methods

    @Override
    public int withdraw(int amountToWithdraw) {
        //TODO - implement all the logic from step two
        int balance = super.getBalance();
        return super.withdraw(amountToWithdraw);
    }




}
