package com.tlherr.Listeners;

import com.tlherr.User;
import com.tlherr.UserManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavingsAccountRadioSelectListener implements ActionListener {

    private UserManager userManager;
    private JRadioButton chequingRadioButton;

    public SavingsAccountRadioSelectListener(UserManager manager, JRadioButton radioButton)
    {
        userManager = manager;
        chequingRadioButton = radioButton;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        chequingRadioButton.setSelected(false);

        User user = userManager.getCurrentUser();
        user.setActiveAccount(user.getSavingsAccount());
    }
}
