package com.tlherr.Listeners;

import com.tlherr.User;
import com.tlherr.UserManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DeleteUserButtonClickListener implements ActionListener {

    private UserManager userManager;
    private JList userList;

    public DeleteUserButtonClickListener(UserManager manager, JList list)
    {
        userManager = manager;
        userList = list;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //User needs to be removed and make sure the the current active user is no longer set

        if(!userList.isSelectionEmpty()) {
            //get the selected index from the list
            int index = userList.getSelectedIndex();

            User user = userManager.getUserById(index);

            if(user!=null) {
                userManager.removeUser(user);
                ((DefaultListModel) userList.getModel()).remove(index);
            }
        }
    }
}
