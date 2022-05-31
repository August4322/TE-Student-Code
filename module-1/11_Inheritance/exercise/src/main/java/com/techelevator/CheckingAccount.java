package com.techelevator;

public class CheckingAccount extends BankAccount {

    //Instance Variables
    private int overDraftLimit = -100;

    //Constructor
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //Getter
    public int getOverDraftLimit() {
        return overDraftLimit;
    }

    //Setter
    public void setOverDraftLimit() {
        this.overDraftLimit = overDraftLimit;
    }

    //Methods
        @Override
        public int withdraw(int amountToWithdraw) {
            //TODO - implement all the logic from step two
            int balance = super.getBalance();

            if (getBalance() - amountToWithdraw <= overDraftLimit) {
                return balance;
            } else if (getBalance() - amountToWithdraw > overDraftLimit && getBalance() - amountToWithdraw < 0) {
                return super.withdraw(amountToWithdraw + 10);
            }
            return super.withdraw(amountToWithdraw);
        }

    }
