package basicsComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * Created by sh00x on 2015-07-21.
 */
public class BasicComponentsFour extends JFrame {

    public BasicComponentsFour() {
        initComponents();
    }

    private void initComponents() {

        JLabel loginLabel = new JLabel();
        JLabel passwordLabel = new JLabel();
        JTextField loginTextField = new JTextField();
        JPasswordField jPasswordField1 = new JPasswordField();
        JScrollPane messageScrollPane = new JScrollPane();
        JTextArea messageTextArea = new JTextArea();
        JButton sendButton = new JButton();
        JButton saveButton = new JButton();
        JButton cancelButton = new JButton();
        JLabel topicLabel = new JLabel();
        JTextField topicTextField = new JTextField();
        JScrollPane attachmentScrollPane = new JScrollPane();
        JTextArea attachmentTextArea = new JTextArea();
        JButton attachmentButton = new JButton();
        JButton deleteAttachmentButton = new JButton();
        JButton deleteAllAttachmentsButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setText("Login");

        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setText("Hasło");

        jPasswordField1.addActionListener(this::jPasswordField1ActionPerformed);

        messageTextArea.setColumns(20);
        messageTextArea.setFont(new Font("Arial", 0, 12));
        messageTextArea.setLineWrap(true);
        messageTextArea.setRows(5);
        messageTextArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Treść wiadomości"));
        messageScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        messageScrollPane.setViewportView(messageTextArea);

        sendButton.setText("Wyślij");
        sendButton.addActionListener(this::sendMessage);

        saveButton.setText("Zapisz");

        cancelButton.setText("Anuluj");
        cancelButton.addActionListener(this::cancelSending);

        topicLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topicLabel.setText("Temat");

        topicTextField.addActionListener(this::topicActionPerformed);

        attachmentTextArea.setEditable(false);
        attachmentTextArea.setColumns(15);
        attachmentTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        attachmentTextArea.setRows(2);
        attachmentTextArea.setAutoscrolls(false);
        attachmentScrollPane.setViewportView(attachmentTextArea);

        attachmentButton.setText("Dodaj załącznik");
        attachmentButton.setPreferredSize(new Dimension(110, 20));
        attachmentButton.addActionListener(this::addAttachment);

        deleteAttachmentButton.setText("Usuń załącznik");
        deleteAttachmentButton.setPreferredSize(new Dimension(110, 20));
        deleteAttachmentButton.addActionListener(this::deleteAttachment);

        deleteAllAttachmentsButton.setText("Usuń wszystkie");
        deleteAllAttachmentsButton.setPreferredSize(new Dimension(110, 20));
        deleteAllAttachmentsButton.addActionListener(this::deleteAllAtachments);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(messageScrollPane)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(cancelButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(saveButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(sendButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(passwordLabel, GroupLayout.Alignment.LEADING,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(loginLabel, GroupLayout.Alignment.LEADING,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(topicLabel, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(loginTextField, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                        .addComponent(jPasswordField1)
                                                        .addComponent(topicTextField))
                                                .addGap(18, 18, 18)
                                                .addComponent(attachmentScrollPane, GroupLayout.PREFERRED_SIZE, 170,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(attachmentButton, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(deleteAttachmentButton, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(deleteAllAttachmentsButton, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );

        layout.linkSize(SwingConstants.HORIZONTAL, jPasswordField1, loginTextField, topicTextField);

        layout.linkSize(SwingConstants.HORIZONTAL, sendButton, saveButton, cancelButton);


        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(attachmentButton, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(deleteAttachmentButton, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(deleteAllAttachmentsButton, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(attachmentScrollPane, GroupLayout.Alignment.TRAILING,
                                                                GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(loginLabel)
                                                                        .addComponent(loginTextField, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(passwordLabel)
                                                                        .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(topicLabel)
                                                                        .addComponent(topicTextField, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(20, 20, 20)
                                                .addComponent(messageScrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sendButton)
                                                        .addComponent(saveButton)
                                                        .addComponent(cancelButton))))
                                .addGap(10, 10, 10))
        );

        pack();
    }

    private void jPasswordField1ActionPerformed(ActionEvent evt) {
        //Uzupełnij jeśli chcesz
    }

    private void sendMessage(ActionEvent evt) {
        //Uzupełnij jeśli chcesz
    }

    private void cancelSending(ActionEvent evt) {
        //Uzupełnij jeśli chcesz
    }

    private void topicActionPerformed(ActionEvent evt) {
        //Uzupełnij jeśli chcesz
    }

    private void deleteAllAtachments(ActionEvent evt) {
        //Uzupełnij jeśli chcesz
    }

    public void addAttachment(ActionEvent evt) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new FileChooser();
            frame.setVisible(true);
        });
    }

    public void deleteAttachment(ActionEvent evt) {
        //Uzupełnij jeśli chcesz
    }
}