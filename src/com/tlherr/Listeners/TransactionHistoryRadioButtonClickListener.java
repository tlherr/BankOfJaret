package com.tlherr.Listeners;

import com.tlherr.Forms.TransactionHistoryForm;
import com.tlherr.User;
import com.tlherr.UserManager;
import com.tlherr.Account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tom on 2016-01-18.
 */
public class TransactionHistoryRadioButtonClickListener implements ActionListener {

    private UserManager userManager;

    public TransactionHistoryRadioButtonClickListener(UserManager manager)
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
        Account activeAccount = user.getActiveAccount();

        //Create a new Transaction Form
        if(activeAccount!=null) {
            TransactionHistoryForm form = new TransactionHistoryForm(activeAccount);
            form.pack();
            form.setVisible(true);
        }

    }
}
