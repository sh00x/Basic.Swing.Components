package dialogFrames;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ensies on 2015-07-27.
 */
public class DialogFrameThree extends JFrame {
    private JButton colorChooserButton;
    private JPanel panel;
    private Color selectedColor;

    public DialogFrameThree() {
        panel = new JPanel();
        panel.setBackground(Color.BLUE);

        colorChooserButton = new JButton("Wybierz kolor tła");
        colorChooserButton.addActionListener(e -> {
            selectedColor = JColorChooser.showDialog(getParent(), "Wybierz kolor", null);
            panel.setBackground(selectedColor);
        });

        add(panel, BorderLayout.CENTER);
        add(colorChooserButton, BorderLayout.SOUTH);

        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(200, 200));
        setTitle("Test koloru");
        pack();

        setVisible(true);
    }
}
