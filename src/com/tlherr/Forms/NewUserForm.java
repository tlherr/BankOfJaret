package com.tlherr.Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUserForm {

    private JFrame frame;
    private JPanel newUserPanel;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;
    private JButton okButton;

    public NewUserForm() {
        System.out.println("NewUserForm Constructor");
        prepareUI();


        okButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Create a new user

                //Add this user to the UI via a manager

                //Close this dialog
            }
        });
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
