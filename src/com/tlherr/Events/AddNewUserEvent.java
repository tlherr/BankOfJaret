package com.tlherr.Events;

import com.tlherr.Forms.NewUserForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddNewUserEvent extends AbstractAction {
    JFrame baseFrame;

    public AddNewUserEvent(String name, Integer mnemonic) {
        super(name);
        putValue(MNEMONIC_KEY, mnemonic);
        this.baseFrame = baseFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed");

        NewUserForm form = new NewUserForm();


        //This function needs to initialize a new user class and tell the Main form to update the UI
    }
}
