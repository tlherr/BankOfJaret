package com.tlherr.Forms;

import com.tlherr.Events.*;
import com.tlherr.UserManager;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

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

    public MainForm() {
        prepareUI();

        userModel = new DefaultListModel();
        userList.setModel(userModel);

        userManager = new UserManager();

        UserObserver observer = new UserObserver();
        userManager.addObserver(observer);

    }


    private class UserObserver implements Observer {
        /**
         * This method is called whenever the observed object is changed. An
         * application calls an <tt>Observable</tt> object's
         * <code>notifyObservers</code> method to have all the object's
         * observers notified of the change.
         *
         * @param o   the observable object.
         * @param arg an argument passed to the <code>notifyObservers</code>
         */
        @Override
        public void update(Observable o, Object arg) {
            userModel.addElement(arg.toString());
        }
    }

    /**
     * Create the UI this form needs
     */
    public void prepareUI()
    {
        mainFrame = new JFrame();
        panel.setPreferredSize(new Dimension(400, 300));
        mainFrame.setContentPane(panel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
    }

    public void showUI()
    {
        mainFrame.setVisible(true);

        //Add event handlers
        newUserButton.addActionListener(new AddUserButtonClickListener(userManager));
        loginUserButton.addActionListener(new LoginUserButtonClickListener(userManager, userList));
    }

    public void hideUI()
    {
        mainFrame.setVisible(false);

        //Remove event handlers
        for( ActionListener al : newUserButton.getActionListeners() ) {
            newUserButton.removeActionListener( al );
        }

        for( ListSelectionListener al : userList.getListSelectionListeners() ) {
            userList.removeListSelectionListener( al );
        }
    }
}
