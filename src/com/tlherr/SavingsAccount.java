package com.tlherr;

/**
 * Created by tom on 2015-12-21.
 */
public class SavingsAccount extends Account {

    public SavingsAccount(User owner, double balance, double interestRate, double creditLimit, double transactionFee) {
        super(owner, balance, interestRate, creditLimit, transactionFee);
    }

    /**
     * Perform a deposit action, return a Transaction object that describes the actions performed
     *
     * @param amount
     * @return Transaction
     */
    @Override
    public Transaction deposit(double amount) {
        return null;
    }

    /**
     * Perform a withdraw action, return a Transaction object that describes the actions performed
     *
     * @param amount
     * @return Transaction
     */
    @Override
    public Transaction withdraw(double amount) {
        return null;
    }

    /**
     * Calculate Interest based on the account balance
     *
     * @param amount
     * @return double
     */
    @Override
    public double calculateInterest(double amount) {
        return 0;
    }

    /**
     * Calculate a fee for a given transaction
     *
     * @param transaction
     * @return double
     */
    @Override
    public double calculateFee(Transaction transaction) {
        return 0;
    }


}
