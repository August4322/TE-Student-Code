package com.techelevator;

public class SavingsAccount extends BankAccount{

    //Constructors
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //Methods
    @Override
    public int withdraw(int amountToWithdraw) {
        //TODO - implement all the logic from step two
        int balance = super.getBalance();

        if (getBalance() - amountToWithdraw < 150 && getBalance() - amountToWithdraw >= 2) {
            return super.withdraw((amountToWithdraw + 2));
        } else if (getBalance() - amountToWithdraw < 2) {
            return balance;
        }
        return super.withdraw(amountToWithdraw);
    }


}
