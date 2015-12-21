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

    public Object getRecord() {
        Object[] arr = new Object[6];
        arr[0] = this.id;
        arr[1] = this.user.getFullName();
        arr[2] = this.accountStatus;
        arr[3] = this.operation;
        arr[4] = this.input;
        arr[5] = this.result;

        return arr;
    }

}
