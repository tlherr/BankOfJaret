package com.tlherr.Forms;

import com.tlherr.UserManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import com.tlherr.User;

public class NewUserForm {

    private JFrame frame;
    private JPanel newUserPanel;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;
    private JButton okButton;


    public NewUserForm(UserManager userManager) {
        System.out.println("NewUserForm Constructor");
        prepareUI();

        okButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Have some error checking to make sure fields are not blank

                //Create a new user
                User user = new User(firstNameTextField.getText(), lastNameTextField.getText());

                //Add this user to the UI via a manager
                userManager.addUser(user);

                //Close this dialog
                frame.setVisible(false);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }


    public void prepareUI()
    {
        System.out.println("Preparing UI for NewUserForm");
        this.frame = new JFrame("Create A New User");
        this.frame.setContentPane(this.newUserPanel);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
