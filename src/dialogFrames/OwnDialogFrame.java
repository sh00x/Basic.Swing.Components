package dialogFrames;

import javax.swing.*;
import java.awt.*;


public class OwnDialogFrame extends JDialog {

    public OwnDialogFrame(JFrame owner) {
        super(owner, "Test okna O programie", true);
        add(new JLabel("<html><h1><center><b><u>Informacje o programie</u></b></center></h1>", JLabel.CENTER), BorderLayout.NORTH);
        add(new JLabel("That code smells. But window is modal ^_^", JLabel.CENTER), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton okButton = new JButton("OK");

        okButton.addActionListener(e -> dispose());

        panel.add(okButton);
        add(panel, BorderLayout.SOUTH);

        setSize(350, 150);
        setResizable(false);
    }
}
