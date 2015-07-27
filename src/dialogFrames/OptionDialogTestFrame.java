package dialogFrames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

/**
 * Created by sh00x on 2015-07-27.
 */
public class OptionDialogTestFrame extends JFrame {

    private ButtonPanel typePanel;
    private ButtonPanel messagePanel;
    private ButtonPanel messageTypePanel;
    private ButtonPanel optionTypePanel;
    private ButtonPanel optionsPanel;
    private ButtonPanel inputPanel;

    private String messageString = "Komunikat";
    private Icon messageIcon = new ImageIcon("blue-ball.gif");
    private Object messageObject = new Date();
    private Component messageComponent = new SampleComponent();


    public OptionDialogTestFrame() {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 3));

        typePanel = new ButtonPanel("Typ", "Komunikat", "Potwierdzenie", "Opcja", "Dane wejściowe");
        messageTypePanel = new ButtonPanel("Typ komunikatu", "ERROR_MESSAGE", "INFORMATION_MESSAGE","WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE");
        messagePanel = new ButtonPanel("Komunikat", "Łańcuch", "Ikona", "Komponent", "Inny", "Object[]");
        optionTypePanel = new ButtonPanel("Potwierdzenie", "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION");
        optionsPanel = new ButtonPanel("Opcja", "String[]", "Icon[]", "Object[]");
        inputPanel = new ButtonPanel("Dane wejściowe", "Pole tekstowe", "Pole kombi");

        gridPanel.add(typePanel);
        gridPanel.add(messageTypePanel);
        gridPanel.add(messagePanel);
        gridPanel.add(optionTypePanel);
        gridPanel.add(optionsPanel);
        gridPanel.add(inputPanel);

        //Dodanie panelu z przyciskiem Pokaż

        JPanel showPanel = new JPanel();
        JButton showButton = new JButton("Pokaż");
        showButton.addActionListener(new ShowAction());
        showPanel.add(showButton);

        add(gridPanel, BorderLayout.CENTER);
        add(showPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Pobiera aktualnie wybrany komunikat
     * @return łańcuch, ikona, komponent lub tablica obiektów, w zależności od wyboru w panelu Komunikat
     */
    public Object getMessage() {
        String s = messagePanel.getSelection();

        if(s.equals("Łańcuch")) return messageString;
        else if(s.equals("Ikona")) return messageIcon;
        else if(s.equals("Komponent")) return messageComponent;
        else if(s.equals("Object[]")) return new Object[] {messageString, messageIcon, messageComponent, messageObject};
        else if(s.equals("Inny")) return messageObject;
        else return null;
    }

    /**Pobiera aktualnie wybrane opcje,
     * @return tablica łańcuchów, ikon lub obiektów, w zależności od wyboru w panelu Opcja
     */
    public Object[] getOptions() {
        String s = optionsPanel.getSelection();
        if (s.equals("String[]")) return new String[] { "Zółty", "Niebieski", "Czerwony" };
        else if (s.equals("Icon[]")) return new Icon[] { new ImageIcon("yellow-ball.gif"), new ImageIcon("blue-ball.gif"), new ImageIcon("red_ball.gif") };
        else if (s.equals("Object[]")) return new Object[] { messageString, messageIcon, messageComponent, messageObject };
        else return null;
    }

    /**
     * Pobiera wybrany komunikat lub typ opcji
     * @param panel Typ komunikatu lub panel Potwiedzenie
     * @return wybrana stała XXX_MESSAGE lub XXX_OPTION z klasy JOptionPane
     */
    public int getType(ButtonPanel panel) {
        String s = panel.getSelection();
        try {
            return JOptionPane.class.getField(s).getInt(null);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Słuchacz akcji przycisku Pokaż wyświetla okno dialogowe potwierdzenia danych wejściowych,
     * komunikatu lub opcji w zależności od wyboru typu panelu
     */
    private class ShowAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (typePanel.getSelection().equals("Potwierdzenie")) {
                JOptionPane.showConfirmDialog(OptionDialogTestFrame.this,
                        getMessage(), "Tytuł", getType(optionTypePanel), getType(messageTypePanel));
            } else if (typePanel.getSelection().equals("Dane wejściowe")) {
                if (inputPanel.getSelection().equals("Pole tekstowe"))
                    JOptionPane.showInputDialog(OptionDialogTestFrame.this, getMessage(), "Tytuł", getType(messageTypePanel));
                else
                    JOptionPane.showInputDialog(OptionDialogTestFrame.this, getMessage(), "Tytuł", getType(messageTypePanel),
                            null, new String[]{"Żółty", "Niebieski", "Czerwony"}, "Niebieski");
            } else if (typePanel.getSelection().equals("Komunikat")) {
                JOptionPane.showMessageDialog(OptionDialogTestFrame.this, getMessage(), "Tytuł", getType(messageTypePanel));
            } else if (typePanel.getSelection().equals("Opcja")) {
                JOptionPane.showOptionDialog(OptionDialogTestFrame.this, getMessage(), "Tytuł", getType(optionTypePanel),
                        getType(messageTypePanel), null, getOptions(), getOptions()[0]);
            }
        }
    }

    /**
     * Komponent z pomalowaną powierzchnią
     */
    class SampleComponent extends JComponent {

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1);
            g2.setPaint(Color.YELLOW);
            g2.fill(rect);
            g2.setPaint(Color.BLUE);
            g2.draw(rect);
        }

        public Dimension getPreferredSize() {
            return new Dimension(10, 10);
        }
    }

    class ButtonPanel extends JPanel {
        private ButtonGroup group;

        /**
         * Tworzy panel przycisków
         * @param title Tytuł wyświetlany w obramowaniu
         * @param options Tablica etykiet przełączników
         */
        public ButtonPanel(String title, String... options) {
            setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            group = new ButtonGroup();

            //Utworzenie po jednym przełączniku dla każdej opcji
            for(String option : options) {
                JRadioButton b = new JRadioButton(option);
                b.setActionCommand(option);
                add(b);
                group.add(b);
                b.setSelected(option == options[0]);
            }
        }

        /**
         * Pobiera aktualnie wybraną opcję
          * @return Zwraca etykietę aktualnie wybranego przełącznika
         */
        public String getSelection() {
            return group.getSelection().getActionCommand();
        }
    }
}
