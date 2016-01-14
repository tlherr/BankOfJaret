package com.tlherr;

import java.util.UUID;

/**
 * Class to handle transactions
 *
 * Simple record with a unique ID
 *
 * @return an array containing all information about the transaction
 */
public class Transaction {

    private String id;
    private String accountStatus;
    private String operation;
    private double input;
    private double result;
    private User user;

    public Transaction(User user, String operation, double input, double result, String accountStatus)
    {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.accountStatus = accountStatus;
        this.operation = operation;
        this.input = input;
        this.result = result;
    }

    public String toString() {
        return "Account Status: "+this.accountStatus+" Transaction ID: "+this.id+" Operation: "+this.operation+" Result (Balance):"+this.result+" User:"+this.user.toString();
    }

    public double getResult() {
        return this.result;
    }

}
