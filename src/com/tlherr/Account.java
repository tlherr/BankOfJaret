package com.tlherr;

import java.util.ArrayList;

public abstract class Account {

    /**
     * Instance Variables
     */
    protected double interestRate;
    protected double annualInterest;
    protected double minimumBalance;
    protected double maximumBalance;
    protected double accountBalance;
    protected boolean overdraftProtection;
    protected boolean isFrozen;
    protected double transactionFee;
    protected double creditLimit;
    protected User owner;
    protected ArrayList<Transaction> transactions = new ArrayList<>();
    protected int deposits = 0;
    protected int withdrawls = 0;

    /**
     * Class constructor
     *
     * @param owner
     * @param balance
     * @param interestRate
     * @param creditLimit
     * @param transactionFee
     */
    public Account(User owner, double balance, double interestRate, double creditLimit, double transactionFee)
    {
        this.owner = owner;
        this.accountBalance = balance;
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
        this.transactionFee = transactionFee;
    }

    /**
     * Perform a deposit action, return a Transaction object that describes the actions performed
     *
     * @param amount
     * @return Transaction
     */
    abstract public Transaction deposit(double amount);

    /**
     * Perform a withdraw action, return a Transaction object that describes the actions performed
     *
     * @param amount
     * @return Transaction
     */
    abstract public Transaction withdraw(double amount);

    /**
     * Calculate Interest based on the account balance
     *
     * @param amount
     * @return double
     */
    abstract public double calculateInterest(double amount);

    /**
     * Calculate a fee for a given transaction
     *
     * @param transaction
     * @return double
     */
    abstract public double calculateFee(Transaction transaction);

    /**
     * Add a transaction to the storage array
     *
     * @param transaction
     */
    final public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    /**
     * Get an ArrayList of all transactions this account has processed
     *
     * @return ArrayList
     */
    public ArrayList getTransactions() {
        return transactions;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    public boolean isOverdraftProtection() {
        return overdraftProtection;
    }

    public void setOverdraftProtection(boolean overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }


    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(double annualInterest) {
        this.annualInterest = annualInterest;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public double getMaximumBalance() {
        return maximumBalance;
    }

    public void setMaximumBalance(double maximumBalance) {
        this.maximumBalance = maximumBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getDeposits() {
        return deposits;
    }

    public int getWithdrawls() {
        return withdrawls;
    }







}
