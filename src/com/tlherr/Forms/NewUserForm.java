package com.tlherr.Forms;

import javax.swing.*;

public class NewUserForm {

    private JFrame frame;
    private JPanel newUserPanel;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;

    public NewUserForm() {
        System.out.println("NewUserForm Constructor");
        prepareUI();
    }

    public void prepareUI()
    {
        System.out.println("Preparing UI for NewUserForm");
        this.frame = new JFrame("Create A New User");
        this.frame.setContentPane(this.newUserPanel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
    }

    public void showUI()
    {
        System.out.println("Showing NewUserForm UI");
        this.frame.setVisible(true);
    }

    public void hideUI()
    {
        System.out.println("Hiding NewUserForm UI");
        this.frame.setVisible(false);
    }


}
