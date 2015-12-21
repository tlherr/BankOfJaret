package com.tlherr;

/**
 * Created by tom on 2015-12-21.
 */
public class ChequingAccount extends Account implements AccountInterface {


    public ChequingAccount(User owner, double balance, double interestRate, double creditLimit, double transactionFee) {
        super(owner, balance, interestRate, creditLimit, transactionFee);
    }

    @Override
    public double calculateInterest(double amount) {
        return this.getInterestRate() * amount;
    }

    //Chequing accounts allow you to write cheques which savings accounts do not allow
    public void writeCheque(double amount)
    {
        //A cheque is basically the same as a transaction
        this.withdraw(amount);
    }

}
