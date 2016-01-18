package com.tlherr.Forms;

import com.tlherr.Events.EventConsumer;
import com.tlherr.Events.EventDispatcher;
import com.tlherr.Listeners.*;
import com.tlherr.UserManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;

public class MainForm {

    private JFrame mainFrame;
    public UserManager userManager;

    private JPanel panel;
    private JList userList;
    private DefaultListModel userModel;

    private JButton newUserButton;
    private JButton deleteUserButton;
    private JButton loginUserButton;
    private JLabel loggedInLabel;
    private JLabel accountTypeLabel;
    private JRadioButton chequingAccountRadioButton;
    private JRadioButton savingsAccountRadioButton;
    private JTextField balanceTextField;
    private JLabel balanceLabel;
    private JButton newTransactionButton;
    private JButton transactionHistoryButton;
    private JButton logoutButton;

    private class UserObserver implements EventConsumer {

        /**
         * This method is called whenever the observed object is changed. An
         * application calls an <tt>Observable</tt> object's
         * <code>notifyObservers</code> method to have all the object's
         * observers notified of the change.
         *
         * @param o     the observable object.
         * @param event
         * @param arg   an argument passed to the <code>notifyObservers</code>
         */
        @Override
        public void update(EventDispatcher o, String event, Object arg) {

            switch (event) {
                case "NEW_USER":
                    userModel.addElement(arg.toString());
                    break;

                case "SET_CURRENT_USER":
                    loggedInLabel.setText("Logged In As: " + arg.toString());
                    //Enable form controls
                    chequingAccountRadioButton.setEnabled(true);
                    savingsAccountRadioButton.setEnabled(true);
                    newTransactionButton.setEnabled(true);
                    break;

                case "DELETED_USER":

                    break;

                case "REMOVED_CURRENT_USER":
                    chequingAccountRadioButton.setEnabled(false);
                    savingsAccountRadioButton.setEnabled(false);
                    newTransactionButton.setEnabled(false);
                    break;
            }
        }
    }

    public MainForm() {
        prepareUI();

        userModel = new DefaultListModel();
        userList.setModel(userModel);

        userManager = new UserManager();

        UserObserver observer = new UserObserver();
        userManager.addObserver(observer);

    }

    /**
     * Create the UI this form needs
     */
    public void prepareUI() {
        mainFrame = new JFrame();
        panel.setPreferredSize(new Dimension(500, 400));
        mainFrame.setContentPane(panel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
    }

    public void showUI() {
        mainFrame.setVisible(true);

        //Add event handlers
        newUserButton.addActionListener(new AddUserButtonClickListener(userManager));
        loginUserButton.addActionListener(new LoginUserButtonClickListener(userManager, userList));
        deleteUserButton.addActionListener(new DeleteUserButtonClickListener(userManager, userList));

        chequingAccountRadioButton.addActionListener(new ChequingAccountRadioSelectListener(userManager, savingsAccountRadioButton));
        savingsAccountRadioButton.addActionListener(new SavingsAccountRadioSelectListener(userManager, chequingAccountRadioButton));
        newTransactionButton.addActionListener(new NewTransactionButtonClickListener(userManager, balanceTextField));
        transactionHistoryButton.addActionListener(new TransactionHistoryRadioButtonClickListener(userManager));
    }

    public void hideUI() {
        mainFrame.setVisible(false);

        //Remove event handlers
        for (ActionListener al : newUserButton.getActionListeners()) {
            newUserButton.removeActionListener(al);
        }

        for (ListSelectionListener al : userList.getListSelectionListeners()) {
            userList.removeListSelectionListener(al);
        }
    }
}
