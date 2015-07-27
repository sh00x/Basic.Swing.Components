package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Created by sh00x on 2015-07-21.
 */
public class BasicComponentsFour extends javax.swing.JFrame {
    private JButton sendButton;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton attachmentButton;
    private JButton deleteAttachmentButton;
    private JButton deleteAllAttachmentsButton;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JLabel topicLabel;
    private JPasswordField jPasswordField1;
    private JScrollPane messageScrollPane;
    private JScrollPane attachmentScrollPane;
    private JTextArea messageTextArea;
    private JTextArea attachmentTextArea;
    private JTextField loginTextField;
    private JTextField topicTextField;


    public BasicComponentsFour() {
        initComponents();
    }

    private void initComponents() {

        loginLabel = new JLabel();
        passwordLabel = new JLabel();
        loginTextField = new JTextField();
        jPasswordField1 = new JPasswordField();
        messageScrollPane = new JScrollPane();
        messageTextArea = new JTextArea();
        sendButton = new JButton();
        saveButton = new JButton();
        cancelButton = new JButton();
        topicLabel = new JLabel();
        topicTextField = new JTextField();
        attachmentScrollPane = new JScrollPane();
        attachmentTextArea = new JTextArea();
        attachmentButton = new JButton();
        deleteAttachmentButton = new JButton();
        deleteAllAttachmentsButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setText("Login");

        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setText("Hasło");

        jPasswordField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        messageTextArea.setColumns(20);
        messageTextArea.setFont(new Font("Arial", 0, 12));
        messageTextArea.setLineWrap(true);
        messageTextArea.setRows(5);
        messageTextArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Treść wiadomości"));
        messageScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        messageScrollPane.setViewportView(messageTextArea);

        sendButton.setText("Wyślij");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sendMessage(evt);
            }
        });

        saveButton.setText("Zapisz");

        cancelButton.setText("Anuluj");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancelSending(evt);
            }
        });

        topicLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topicLabel.setText("Temat");

        topicTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                topicActionPerformed(evt);
            }
        });

        attachmentTextArea.setEditable(false);
        attachmentTextArea.setColumns(15);
        attachmentTextArea.setFont(new Font("Arial", 2, 12));
        attachmentTextArea.setRows(2);
        attachmentTextArea.setAutoscrolls(false);
        attachmentScrollPane.setViewportView(attachmentTextArea);

        attachmentButton.setText("Dodaj załącznik");
        attachmentButton.setPreferredSize(new Dimension(110, 20));
        attachmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addAttachment(evt);
            }
        });

        deleteAttachmentButton.setText("Usuń załącznik");
        deleteAttachmentButton.setPreferredSize(new Dimension(110, 20));
        deleteAttachmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deleteAttachment(evt);
            }
        });

        deleteAllAttachmentsButton.setText("Usuń wszystkie");
        deleteAllAttachmentsButton.setPreferredSize(new Dimension(110, 20));
        deleteAllAttachmentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteAllAtachments(evt);
            }
        });

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

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[]{jPasswordField1, loginTextField, topicTextField});

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[]{sendButton, saveButton, cancelButton});


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
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new FileChooser();
                frame.setVisible(true);
            }
        });
    }

    public void deleteAttachment(ActionEvent evt) {
        //Uzupełnij jeśli chcesz
    }
}