package com.tlherr.Listeners;

import com.tlherr.Forms.NewUserForm;
import com.tlherr.UserManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserButtonClickListener implements ActionListener {

    private UserManager userManager;

    public AddUserButtonClickListener(UserManager manager) {
        userManager = manager;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        NewUserForm newUserForm = new NewUserForm(userManager);

        newUserForm.showUI();

    }
}