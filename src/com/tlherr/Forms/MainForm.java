package com.tlherr.Forms;

import com.tlherr.Events.*;
import com.tlherr.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainForm {

    private JFrame mainFrame;
    private DefaultListModel<Object> users = new DefaultListModel<Object>();

    private JPanel panel;
    private JList userList;

    private JButton newUserButton;
    private JButton deleteUserButton;

    public MainForm() {
        prepareUI();
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
        newUserButton.addActionListener(new AddUserButtonClickListener());
    }

    public void hideUI()
    {
        mainFrame.setVisible(false);

        //Remove event handlers
        for( ActionListener al : newUserButton.getActionListeners() ) {
            newUserButton.removeActionListener( al );
        }
    }


    private class AddUserButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            NewUserForm newUserForm = new NewUserForm();

            newUserForm.showUI();
        }
    }


}
