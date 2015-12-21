package com.tlherr;

import java.util.ArrayList;

/**
 * Created by tom on 2015-12-21.
 */
public abstract class Account {

    //Who has permission to edit, add, remove funds etc

    //Monthly fee
    //Array of transactions
    private double interestRate;
    private double annualInterest;
    private double minimumBalance;
    private double maximumBalance;
    private double accountBalance;
    private boolean overdraftProtection;
    private boolean isFrozen;
    private double transactionFee;

    private double creditLimit;

    private User owner;

    private ArrayList<Object> transactions = new ArrayList<Object>();
    private int deposits = 0;
    private int withdrawls = 0;


    public Account(User owner, double balance, double interestRate, double creditLimit, double transactionFee)
    {
        this.owner = owner;
        this.accountBalance = balance;
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
        this.transactionFee = transactionFee;
    }

    final public Transaction deposit(double amount)
    {
        this.accountBalance += this.calculateInterest(amount);

        //To make things simple interest is just calculated per transaction vs a compound period
        this.deposits++;
        this.accountBalance+=amount;

        return new Transaction(this.owner, "deposit", amount, this.accountBalance, "OK");
    }

    final public Transaction withdraw(double amount)
    {

        //Check if the account is frozen, it not proceed
        if(!this.isFrozen) {
            double remaining = this.accountBalance - amount;

            //If a user is attempting to withdraw more money then they have
            if(remaining <= 0)
            {
                if(this.overdraftProtection && !(remaining < -this.creditLimit)) {
                    //If they have overdraft protection, allow the account to go negative as long as it does not surpass
                    //the credit limit
                    //Freeze the account until a deposit had been made that pays back the credit
                    this.setFrozen(true);
                    this.processFee();
                    this.accountBalance = remaining;
                    this.withdrawls++;

                    return new Transaction(this.owner, "withdrawl", amount, this.accountBalance, "Warning: Overdraft Protection Active");
                } else {
                    return new Transaction(this.owner, "withdrawl", amount, this.accountBalance, "Warning: Insufficient Funds/Credit");
                }
            } else {
                if(this.processFee()) {
                    this.accountBalance = remaining;
                    this.withdrawls++;
                    return new Transaction(this.owner, "withdrawl", amount, this.accountBalance, "OK");
                } else {
                    return new Transaction(this.owner, "withdrawl", amount, this.accountBalance, "Unable to process fee (Account Frozen)");
                }
            }
        } else {
            return new Transaction(this.owner, "withdrawl", amount, this.accountBalance, "Error: Account Frozen");
        }
    }

    //Allow subclasses to determine how interest is calculated
    abstract public double calculateInterest(double amount);

    //Take a fee each transaction
    final public boolean processFee()
    {
        double remaining = this.accountBalance - this.transactionFee;
        if(remaining > 0) {
            //Process the fee and return true
            this.accountBalance = remaining;
            return true;
        } else {
            //User did not have enough money and cant actually afford the fee

            //If the user has overdraft protection process the transaction anyways
            if(this.isOverdraftProtection()) {
                this.accountBalance = remaining;
                return true;
            } else {
                //Freeze the account so no other transactions can happen
                this.setFrozen(true);
                return false;
            }
        }

    }

    final public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction.getRecord());
    }

    public Object getTransactions() {
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
