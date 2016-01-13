package com.tlherr.Forms;

import com.tlherr.UserManager;

import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JDialog {

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPasswordField userPasswordField;
    private JLabel userPasswordFieldLabel;

    public LoginForm(UserManager userManager, int selectedUserIndex) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(userManager, selectedUserIndex);
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

    private void onOK(UserManager userManager, int selectedUserIndex) {
// add your code here

        //Check the password entered vs the one that has been stored

        //If they match "login" the user - note this is plaintext hanging around in memory so very much so not secure
        if(userManager.authenticateUser(userPasswordField.getPassword(),selectedUserIndex)) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Password");
        }

    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }
}
