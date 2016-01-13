package com.tlherr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements ActionListener {

    private ArrayList<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {

        //User manager should trigger event that a user has been added

        System.out.println("Usermanager added user");
        this.users.add(user);
    }

    public List<User> getUsers() {
        return this.users;
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //What action has occured?
        


    }
}
