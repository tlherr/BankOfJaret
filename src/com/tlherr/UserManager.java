package com.tlherr;

import com.tlherr.Events.EventDispatcher;

import java.util.ArrayList;
import java.util.List;

public class UserManager extends EventDispatcher {

    private ArrayList<User> users;
    private User currentUser;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        System.out.println("Usermanager added user");
        this.users.add(user);
        setChanged();
        notifyObservers("NEW_USER",user);
    }

    public void removeUser(User user) {
        System.out.println("Usermanager added user");
        this.users.remove(user);
        setChanged();
        notifyObservers("DELETED_USER", user);
    }

    public User getUserById(int index) {
        try {
            User user = this.users.get(index);
            return user;
        } catch(IndexOutOfBoundsException ex) {
            return null;
        }
    }

    public List<User> getUsers() {
        return this.users;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean authenticateUser(char[] password, int index) {
        User user = this.users.get(index);

        String enteredPassword = String.valueOf(password);
        String userPassword = user.getPassword();

        if(userPassword.equals(enteredPassword)) {
            this.setCurrentUser(user);
            setChanged();
            notifyObservers("SET_CURRENT_USER",user);
            return true;
        } else {
            return false;
        }
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
