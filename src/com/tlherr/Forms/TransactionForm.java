package com.tlherr.Forms;

import com.tlherr.Account;
import com.tlherr.Transaction;
import com.tlherr.User;
import com.tlherr.UserManager;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class TransactionForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton depositRadioButton;
    private JRadioButton withdrawlRadioButton;
    private JLabel amountLabel;
    private JTextField amountTextField;

    public TransactionForm(User currentUser, JTextField balanceTextField) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(currentUser,balanceTextField);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


    }

    private void onOK(User currentUser, JTextField balanceTextField) {
// add your code here

        Account activeAccount = currentUser.getActiveAccount();

        if(activeAccount==null) {
            return;
        }

        String amount = amountTextField.getText();

        //This is not a safe input because JFormattedTextFields are a lie and do nothing...

        //So try and convert this to a double, if it fails inform the user
        try {
            double transactionAmount = Double.parseDouble(amount);

            //Also have to make sure this amount is not below zero etc

            //Check to see if one of the radio buttons was selected
            if (depositRadioButton.isSelected()) {
                Transaction transaction = activeAccount.deposit(transactionAmount);
                JOptionPane.showMessageDialog(null, transaction.toString());

                balanceTextField.setText(String.valueOf(activeAccount.getAccountBalance()));
                dispose();
            } else if (withdrawlRadioButton.isSelected()) {
                Transaction transaction = activeAccount.withdraw(transactionAmount);
                JOptionPane.showMessageDialog(null, transaction.toString());

                balanceTextField.setText(String.valueOf(activeAccount.getAccountBalance()));
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Select either withdrawl or deposit.");
            }

        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Incorrect Formatting of transaction amount. Only numbers and a decimal are allowed.");
        }

    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
        decimalFormat.setGroupingUsed(false);
        amountTextField = new JFormattedTextField(decimalFormat);
        amountTextField.setColumns(15); //whatever size you wish to set

    }

}
