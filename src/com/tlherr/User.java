package com.tlherr;

import java.text.DateFormat;

/**
 * Created by tom on 2015-12-21.
 */
public class User {

    //Users own accounts
    //Users have names (first/last)

    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String email;
    //Change to cal style datefield
    private DateFormat age;

    private Account activeAccount;
    private ChequingAccount chequingAccount;
    private SavingsAccount savingsAccount;

    //Types of accounts

    public User(String firstName, String lastName, char[] password, String email) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPassword(String.valueOf(password));
        this.setEmail(email);

        this.chequingAccount = new ChequingAccount(this, 0.00, 0.02, 10000, 2.00);
        this.savingsAccount = new SavingsAccount(this, 0.00, 0.05, 5000, 5.00);
        this.activeAccount = null;
    }

    public Account getActiveAccount() {
        return activeAccount;
    }

    public void setActiveAccount(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    public ChequingAccount getChequingAccount() {
        return chequingAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DateFormat getAge() {
        return age;
    }

    public void setAge(DateFormat age) {
        this.age = age;
    }
}
