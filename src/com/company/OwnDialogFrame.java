package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ensies on 2015-07-27.
 */
public class OwnDialogFrame extends JDialog {

    public OwnDialogFrame(JFrame owner) {
        super(owner, "Test okna O programie", true);
        add(new JLabel("<html><h1><center><i>Informacje o programie</i></center></h1>", JLabel.CENTER), BorderLayout.NORTH);
        add(new JLabel("That code smells. But window is modal ^_^", JLabel.CENTER), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(okButton);
        add(panel, BorderLayout.SOUTH);

        setSize(350, 150);
    }
}
