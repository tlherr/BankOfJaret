package com.tlherr.Listeners;

import com.tlherr.Forms.TransactionForm;
import com.tlherr.UserManager;
import com.tlherr.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewTransactionButtonClickListener implements ActionListener {

    private UserManager userManager;
    private JTextField balanceTextField;

    public NewTransactionButtonClickListener(UserManager manager, JTextField textField) {
        userManager = manager;
        balanceTextField = textField;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Pop open a dialog for the user to enter transaction info into
        User currentUser = userManager.getCurrentUser();

        if(currentUser!=null) {
            if(currentUser.getActiveAccount()!=null) {
                TransactionForm dialog = new TransactionForm(currentUser, balanceTextField);
                dialog.pack();
                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please select an account type (Cheqings/Savings)");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please login before attempting to process a transaction");
        }
    }
}
