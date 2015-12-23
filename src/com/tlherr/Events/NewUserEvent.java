package com.tlherr.Events;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewUserEvent extends AbstractAction {
    public NewUserEvent(String name, Integer mnemonic) {
        super(name);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed");

        //Pop open a new user form. It will be a GUI form that accepts a first name, last name and which type of account to open


        //This function needs to initialize a new user class and tell the Main form to update the UI
    }
}
