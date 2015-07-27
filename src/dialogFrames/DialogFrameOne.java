package dialogFrames;

import basicsComponents.BasicComponentsOne;

import javax.swing.*;
import java.awt.*;


public class DialogFrameOne extends JDialog {
    private final int FIELD_LENGTH = 10;

    public DialogFrameOne(JFrame owner) {
        super(owner, "Wprowadź dane", true);

        setPreferredSize(new Dimension(250, 105));
        setLocationRelativeTo(getParent());

        JPanel mainPanel = new JPanel();
        JPanel dataPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        JButton confrimButton = new JButton("Wprowadź");
        JButton cancelButton = new JButton("Anuluj");

        dataPanel.setLayout(new GridLayout(2, 2));
        buttonPanel.setLayout(new FlowLayout());

        JTextField nickField = new JTextField("Nickname: ", FIELD_LENGTH);
        nickField.setEditable(false);
        nickField.setHorizontalAlignment(JTextField.CENTER);

        JTextField passwordField = new JTextField("Password: ", FIELD_LENGTH);
        passwordField.setEditable(false);
        passwordField.setHorizontalAlignment(JTextField.CENTER);

        JTextField nick = new JTextField("", FIELD_LENGTH);
        JPasswordField pwd = new JPasswordField("", FIELD_LENGTH);

        nick.setHorizontalAlignment(JTextField.CENTER);
        pwd.setHorizontalAlignment(JTextField.CENTER);
        nick.setEditable(true);
        pwd.setEditable(true);

        confrimButton.addActionListener(e -> {
            BasicComponentsOne.setNick(nick.getText());

            char[] passwordArray = pwd.getPassword();
            String s = "";

            for (char c : passwordArray)
                s += c;

            BasicComponentsOne.setPwd(s);
            dispose();
        });

        cancelButton.addActionListener(e -> dispose());

        dataPanel.add(nickField);
        dataPanel.add(nick);
        dataPanel.add(passwordField);
        dataPanel.add(pwd);

        buttonPanel.add(confrimButton);
        buttonPanel.add(cancelButton);

        mainPanel.add(dataPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
    }
}
