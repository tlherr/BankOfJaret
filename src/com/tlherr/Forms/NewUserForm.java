package com.tlherr.Forms;

import javax.swing.*;

/**
 * Created by tom on 2015-12-21.
 */
public class NewUserForm {
    private JPanel newUserPanel;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Create A New User");
        frame.setContentPane(new NewUserForm().newUserPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
