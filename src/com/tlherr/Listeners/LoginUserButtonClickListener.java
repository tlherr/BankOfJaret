package com.tlherr.Listeners;

import com.tlherr.Forms.LoginForm;
import com.tlherr.UserManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUserButtonClickListener implements ActionListener {

    private UserManager userManager;
    private JList userList;
    private JButton logoutButton;

    public LoginUserButtonClickListener(UserManager manager, JList list, JButton button) {
        userManager = manager;
        userList = list;
        logoutButton = button;
    }

    public void actionPerformed(ActionEvent e) {
        //Need to create a new dialog, and pass it the user manager.
        //If the user enters the correct password they will be set as the logged in user in the manager

        //Check to see if there is a user selected

        if(userList.getSelectedIndex()!=-1) {
            LoginForm dialog = new LoginForm(userManager, userList.getSelectedIndex());
            dialog.pack();
            dialog.setVisible(true);
        }
    }
}