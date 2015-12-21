package com.tlherr;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tom on 2015-12-21.
 */
public class MainForm extends JFrame {

    private JPanel panel;

    public MainForm() {
        panel.setPreferredSize(new Dimension(400, 300));
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

}
