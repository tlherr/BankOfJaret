package com.tlherr;

/**
 * Created by tom on 2015-12-21.
 */
public class User {

    //Users own accounts
    //Users have names (first/last)

    private String firstName;
    private String lastName;
    private int age;

    //Types of accounts

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
