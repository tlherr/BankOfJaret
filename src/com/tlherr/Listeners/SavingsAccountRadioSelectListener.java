package com.tlherr.Listeners;

import com.tlherr.User;
import com.tlherr.UserManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavingsAccountRadioSelectListener implements ActionListener {

    private UserManager userManager;

    public SavingsAccountRadioSelectListener(UserManager manager)
    {
        userManager = manager;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        User user = userManager.getCurrentUser();
        user.setActiveAccount(user.getSavingsAccount());
    }
}
