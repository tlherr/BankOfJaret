package com.tlherr.Events;

import java.util.EventObject;
import com.tlherr.User;

public class AddNewUserEvent extends EventObject {

    private User user;

    public AddNewUserEvent(Object source, User user) {
        super(source);
    }

    public User getUser()
    {
        return this.user;
    }
}
