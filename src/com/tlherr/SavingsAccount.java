package com.tlherr;

/**
 * Created by tom on 2015-12-21.
 */
public class SavingsAccount extends Account implements AccountInterface {

    public SavingsAccount(User owner, double balance, double interestRate, double creditLimit, double transactionFee) {
        super(owner, balance, interestRate, creditLimit, transactionFee);
    }

    @Override
    public double calculateInterest(double amount) {
        return this.getInterestRate() * amount;
    }

}
