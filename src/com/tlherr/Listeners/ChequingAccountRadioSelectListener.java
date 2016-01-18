package com.tlherr.Listeners;

import com.tlherr.User;
import com.tlherr.UserManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChequingAccountRadioSelectListener implements ActionListener {

    private UserManager userManager;
    private JRadioButton savingsRadioButton;

    public ChequingAccountRadioSelectListener(UserManager manager, JRadioButton radioButton)
    {
        userManager = manager;
        savingsRadioButton = radioButton;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Disable the other radio button
        savingsRadioButton.setSelected(false);

        User user = userManager.getCurrentUser();
        user.setActiveAccount(user.getChequingAccount());
    }
}
