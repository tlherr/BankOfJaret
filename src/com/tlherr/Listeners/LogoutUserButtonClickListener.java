package com.tlherr.Listeners;

import com.tlherr.Forms.LoginForm;
import com.tlherr.User;
import com.tlherr.UserManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutUserButtonClickListener implements ActionListener {

    private UserManager userManager;

    public LogoutUserButtonClickListener(UserManager manager) {
        userManager = manager;
    }

    public void actionPerformed(ActionEvent e) {
        //Logout button action

        //have to make sure that a user is actually logged in

        User user = userManager.getCurrentUser();

        if(user!=null) {
            userManager.removeCurrentUser();
        }

    }
}