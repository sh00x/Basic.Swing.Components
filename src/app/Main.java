package app;

import basicsComponents.BasicComponentsOne;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa app programu
 */

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            JFrame frame = new BasicComponentsOne();
            frame.setPreferredSize(new Dimension(500, 700));
            frame.setLocationByPlatform(true);
            frame.setTitle("Basic Swing Components: Part I");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}