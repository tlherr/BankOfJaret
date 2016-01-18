package com.tlherr;

/**
 * Created by tom on 2015-12-21.
 */
public class ChequingAccount extends Account {


    //Chequing accounts should have overdraft protection
    public ChequingAccount(User owner, double balance, double interestRate, double creditLimit, double transactionFee) {
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
        this.deposits++;
        this.accountBalance+=amount;
        Transaction transaction = new Transaction(this.owner, "deposit", amount, this.accountBalance, "OK");

        this.addTransaction(transaction);

        return transaction;
    }

    /**
     * Perform a withdraw action, return a Transaction object that describes the actions performed
     *
     * @param amount
     * @return Transaction
     */
    @Override
    public Transaction withdraw(double amount) {
        if(!this.isFrozen) {
            double remaining = this.accountBalance - amount;

            if(remaining <= 0.00) {
                //The user is attempting to withdraw more then they have
                if(this.overdraftProtection) {

                    //Check to see if the new balance exceeds the established credit limit
                    if(remaining < -this.creditLimit) {
                        //User is exceeding overdraft protections, do not process the transaction
                        Transaction transaction = new Transaction(this.owner, "withdrawl", amount, this.accountBalance, "Warning: Insufficient Funds/Credit");
                        this.addTransaction(transaction);

                        return transaction;
                    } else {
                        this.setFrozen(true);
                        this.accountBalance = remaining;
                        this.withdrawls++;
                        Transaction transaction = new Transaction(this.owner, "withdrawl", amount, this.accountBalance, "Warning: Overdraft Protection Active");
                        this.addTransaction(transaction);

                        return transaction;
                    }
                } else {
                    //No overdraft protection means no withdraw
                    Transaction transaction = new Transaction(this.owner, "withdrawl", amount, this.accountBalance, "Warning: Insufficient Funds/Credit");
                    this.addTransaction(transaction);

                    return transaction;
                }
            } else {
                //The user is withdrawing an acceptable amount
                this.accountBalance = remaining;
                this.withdrawls++;
                Transaction transaction = new Transaction(this.owner, "withdrawl", amount, this.accountBalance, "OK");
                this.addTransaction(transaction);

                return transaction;
            }

        } else {
            Transaction transaction = new Transaction(this.owner, "withdrawl", amount, this.accountBalance, "Error: Account Frozen");
            this.addTransaction(transaction);

            return transaction;
        }
    }

    /**
     * Calculate Interest based on the account balance
     *
     * @param amount
     * @return double
     */
    @Override
    public double calculateInterest(double amount) {
        //Get the interest rate, apply it to amount given and return the result
        if(amount>0.00) {
            double interestRate = this.getInterestRate();

            return (interestRate * amount);
        } else {
            return 0.00;
        }
    }

    /**
     * Calculate a fee for a given transaction
     *
     * @param transaction
     * @return double
     */
    @Override
    public double calculateFee(Transaction transaction) {
        //Get the fee rate

        return transaction.getResult()*this.getInterestRate();
    }


}

