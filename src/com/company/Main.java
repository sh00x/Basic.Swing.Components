package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa main programu
 */

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BasicComponentsOne();
                frame.setPreferredSize(new Dimension(500, 650));
                frame.setTitle("Basic Swing Components: Part I");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}