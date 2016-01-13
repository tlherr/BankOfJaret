package com.tlherr;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class UserManager extends Observable {

    private ArrayList<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        System.out.println("Usermanager added user");
        this.users.add(user);
        setChanged();
        notifyObservers(user);
    }

    public List<User> getUsers() {
        return this.users;
    }

}
