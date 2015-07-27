package dialogFrames;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ensies on 2015-07-27.
 */
public class DialogFrameTwo extends JFrame {
    private JTextArea pathArea;
    private JFileChooser fileChooser;
    private JButton chooseFileButton;

    public DialogFrameTwo() {
        pathArea = new JTextArea("Tutaj pojawi się ściżka pliku(ów)", 10, 10);
        pathArea.setFont(new Font("Arial", Font.ITALIC, 11));
        pathArea.setEditable(false);

        StringBuilder builder = new StringBuilder();

        chooseFileButton = new JButton("Wybierz plik");

        chooseFileButton.addActionListener(e -> {
            fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(getParent());
            fileChooser.setMultiSelectionEnabled(true);

            builder.append(fileChooser.getSelectedFile().getPath()).append("\n");

            pathArea.setText(builder.toString());
        });

        add(pathArea, BorderLayout.CENTER);
        add(chooseFileButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 200));
        setTitle("JFileChooser Test");
        setLocationByPlatform(true);
        pack();

        setVisible(true);
    }
}
