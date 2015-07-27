package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Łukasz on 2015-07-20.
 */
public class BasicComponentsThree extends JFrame {
    JMenuBar menuBar;
    JToolBar toolBar;

    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;

    JPopupMenu popupMenu;
    JPanel textPanel;
    JTextArea textArea;

    public BasicComponentsThree() {
        menuBar = new JMenuBar();

        textArea = new JTextArea(10, 70);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.add(scrollPane);

        fileMenu = new JMenu("Plik");
        editMenu = new JMenu("Edycja");
        helpMenu = new JMenu("Pomoc");
        popupMenu = new JPopupMenu();

        fileMenu.setMnemonic('P');
        editMenu.setMnemonic('E');
        helpMenu.setMnemonic('H');

        //Konfiguracja fileMenu
        JMenuItem newFile = new JMenuItem("Nowy", 'N');
        JMenuItem openFile = new JMenuItem("Otwórz", 'O');
        JMenuItem saveFile = new JMenuItem("Zapisz", 'Z');
        JMenuItem saveFileAs = new JMenuItem("Zapisz jako");
        JMenuItem exit = new JMenuItem("Zakończ");

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.addSeparator();
        fileMenu.add(saveFile);
        fileMenu.add(saveFileAs);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        //Konfiguracja editMenu
        JMenuItem cutItem = new JMenuItem("Wytnij", new ImageIcon("cut.gif"));
        JMenuItem copyItem = new JMenuItem("Kopiuj");
        JMenuItem pasteItem = new JMenuItem("Wklej");
        JMenu optionSubMenu = new JMenu("Opcje");

        ButtonGroup subMenuButtonGroup = new ButtonGroup();
        JRadioButton insertingButton = new JRadioButton("Wstawianie");
        JRadioButton overwritingButton = new JRadioButton("Nadpisywanie");

        insertingButton.setSelected(true);
        subMenuButtonGroup.add(insertingButton);
        subMenuButtonGroup.add(overwritingButton);

        JCheckBox readOnly = new JCheckBox("Tylko do odczytu");
        optionSubMenu.add(readOnly);
        optionSubMenu.addSeparator();
        optionSubMenu.add(insertingButton);
        optionSubMenu.add(overwritingButton);

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.addSeparator();
        editMenu.add(optionSubMenu);

        //Konfiguracja helpMenu
        JMenuItem index = new JMenuItem("Indeks");
        JMenuItem about = new JMenuItem("O programie");

        helpMenu.add(index);
        helpMenu.add(about);

        //Konfiguracja JPopupMenu
        cutItem = new JMenuItem("Wytnij");
        copyItem = new JMenuItem("Kopiuj");
        pasteItem = new JMenuItem("Wklej");

        popupMenu.add(cutItem);
        popupMenu.add(copyItem);
        popupMenu.add(pasteItem);

        textArea.setComponentPopupMenu(popupMenu);

        //Konfiguracja JToolBar
        toolBar = new JToolBar();
        toolBar.setBorderPainted(false);
        JButton boldButton = new JButton(" B ");
        JButton italicButton = new JButton("  I  ");
        JButton underlineButton = new JButton(" U ");

        boldButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        italicButton.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 12));
        underlineButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        toolBar.add(boldButton);
        toolBar.add(italicButton);
        toolBar.add(underlineButton);

        //Konfiguracja menuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        add(toolBar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        setJMenuBar(menuBar);
    }
}
