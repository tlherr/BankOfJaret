package com.tlherr.Forms;

import com.tlherr.Events.*;
import com.tlherr.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by tom on 2015-12-21.
 */
public class MainForm extends JFrame {

    private DefaultListModel<Object> users = new DefaultListModel<Object>();

    private JPanel panel;
    private JList userList;
    private JButton newUserButton;
    private JButton deleteUserButton;

    public MainForm() {
        JFrame frame = this;
        panel.setPreferredSize(new Dimension(400, 300));
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        //Setup Event Handlers

        newUserButton.addActionListener(new NewUserEvent("Click", MouseEvent.BUTTON1));
    }

    public void addUser(User user) {
        this.users.addElement(user);
    }


    public JPanel getPanel() {
        return panel;
    }

}
