package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Prosty program zawierający podstawowe komponenty biblioteki Swing
 * Created by sh00x.dev.
 */
public class BasicComponentsOne extends JFrame {
    private final String DEFAULT_LANGUAGE = "Java 8";

    private final int DEFAULT_FONT_SIZE = 12;
    private final int DEFAULT_TEXT_SIZE = 28;

    private final int DEFAULT_MAIN_GRID_ROWS = 8;
    private final int DEFAULT_MAIN_GRID_COLS = 1;

    private final int BASIC_COMPONENTS_ONE = 1;
    private final int BASIC_COMPONENTS_TWO = 2;
    private final int BASIC_COMPONENTS_THREE = 3;
    private final int BASIC_COMPONENTS_FOUR = 4;
    private final int OPTION_DIALOG_TEST_FRAME = 5;

    private final String TEXT_LABEL_DESC = "Wybrany język";
    private final String STYLE_DESC = "Styl";
    private final String RADIO_BUTTON_DESC = "Wybierz język";
    private final String BORDER_DESC = "Styl obramowania";
    private final String FONT_DESC = "Wybierz czcionkę";
    private final String SLIDER_WINDOW_DESC = "Okno z suwakami";
    private final String TEXT_EDITOR_WINDOW_DESC = "Okno edytora tekstowego";
    private final String GROUP_LAYOUT_WINDOW_DESC = "Okno z rozkładem grupowym";
    private final String OPTION_DIALOG_WINDOW_DESC = "Okno wyboru okna dialogowego";

    private JLabel textLabel;

    private Font mainFont;
    private Font textFont;

    private ButtonGroup buttonGroup;
    private ButtonGroup borderButtonGroup;

    private JComboBox<String> faceCombo;
    private JLabel faceLabel;

    private JPanel mainPanel;
    private JPanel checkBoxPanel;
    private JPanel radioButtonPanel;
    private JPanel borderPanel;
    private JPanel quotePanel;
    private JPanel newWindowPanel;
    private JPanel textEditorPanel;
    private JPanel groupLayoutPanel;
    private JPanel optionDialogPanel;


    /**
     * Głowny konstruktor klasy BasicComponentsOne zawierajacej wszystkie testowane komponenty biblioteki Swing.
     */
    public BasicComponentsOne() {
        //Ustawienia czcionek
        mainFont = new Font(Font.MONOSPACED, Font.PLAIN, DEFAULT_FONT_SIZE);
        textFont = new Font("Ubuntu", Font.PLAIN, DEFAULT_TEXT_SIZE);

        //Ustawienia pola tekstowego
        textLabel = new JLabel(DEFAULT_LANGUAGE, JLabel.CENTER);
        textLabel.setFont(textFont);
        textLabel.setBorder(BorderFactory.createEtchedBorder());
        add(textLabel, BorderLayout.CENTER);

        //Ustawienia JPanel'u zawierającego pozostałe panele
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(DEFAULT_MAIN_GRID_ROWS, DEFAULT_MAIN_GRID_COLS));

        //Konfiguracja JChechBox
        checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new FlowLayout());

        addCheckBox("Pogrubienie");
        addCheckBox("Kursywa");

        //Konfiguracja ButtonGroup dla RadioButton
        buttonGroup = new ButtonGroup();
        radioButtonPanel = new JPanel();
        radioButtonPanel.setLayout(new FlowLayout());

        addRadioButton("C++");
        addRadioButton("C# .NET");
        addRadioButton("Scala");
        addRadioButton("VB .NET");
        addRadioButton("Java 8");


        //Konfiguracja JPanel'u z opcjami ramek
        borderPanel = new JPanel();
        borderPanel.setLayout(new FlowLayout());
        borderButtonGroup = new ButtonGroup();

        addBorderButton("LoweredBevel", BorderFactory.createLoweredBevelBorder());
        addBorderButton("RaisedBevel", BorderFactory.createRaisedBevelBorder());
        addBorderButton("Etched", BorderFactory.createEtchedBorder());
        addBorderButton("Line", BorderFactory.createLineBorder(Color.BLACK));
        addBorderButton("Matte", BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        addBorderButton("Empty", BorderFactory.createEmptyBorder());

        //Konfiguracja pola z cytatem oraz JComboBox
        quotePanel = new JPanel();
        quotePanel.setLayout(new FlowLayout(FlowLayout.TRAILING));

        faceCombo = new JComboBox<>();
        faceLabel = new JLabel("Koń i pies grali w kości z piękną ćmą u źródła.", JLabel.CENTER);

        addComboItem("Serif");
        addComboItem("SansSerif");
        addComboItem("Monospaced");
        addComboItem("Dialog");
        addComboItem("DialogInput");

        //Konfiguracja panelu newWindowPanel oraz dodanie przycisku otwierającego nowa JFrame
        newWindowPanel = new JPanel();
        newWindowPanel.setLayout(new FlowLayout());

        addNewWindowButton(SLIDER_WINDOW_DESC, newWindowPanel, BASIC_COMPONENTS_TWO, 400, 600);

        //Konfiguracja panelu textEditorPanel oraz dodanie przycisku otwierajacego nowa JFrame
        textEditorPanel = new JPanel();
        textEditorPanel.setLayout(new FlowLayout());

        addNewWindowButton(TEXT_EDITOR_WINDOW_DESC, textEditorPanel, BASIC_COMPONENTS_THREE, 500, 400);

        //Konfiguracja panelu groupLayoutPanel, oraz dodanie przycisku otwierajacego nowa JFrame
        groupLayoutPanel = new JPanel();
        groupLayoutPanel.setLayout(new FlowLayout());

        addNewWindowButton("Klient wysyłający pocztę e-mail", groupLayoutPanel, BASIC_COMPONENTS_FOUR, 531, 325);

        //Konfiguracja panelu optionDialogPane
        optionDialogPanel = new JPanel();
        optionDialogPanel.setLayout(new FlowLayout());
        addNewWindowButton(OPTION_DIALOG_WINDOW_DESC, optionDialogPanel, OPTION_DIALOG_TEST_FRAME, 600, 380);

        //Ustawienie domyślnych ramek dla poszczególnych elementów
        setDefaultBorder(textLabel, TEXT_LABEL_DESC);
        setDefaultBorder(checkBoxPanel, STYLE_DESC);
        setDefaultBorder(radioButtonPanel, RADIO_BUTTON_DESC);
        setDefaultBorder(borderPanel, BORDER_DESC);
        setDefaultBorder(quotePanel, FONT_DESC);
        setDefaultBorder(newWindowPanel, SLIDER_WINDOW_DESC);
        setDefaultBorder(textEditorPanel, TEXT_EDITOR_WINDOW_DESC);
        setDefaultBorder(groupLayoutPanel, GROUP_LAYOUT_WINDOW_DESC);
        setDefaultBorder(optionDialogPanel, OPTION_DIALOG_WINDOW_DESC);

        //Dodanie elementów do panelu głównego oraz JFrame
        mainPanel.add(checkBoxPanel);
        mainPanel.add(radioButtonPanel);
        mainPanel.add(borderPanel);
        mainPanel.add(quotePanel);
        mainPanel.add(newWindowPanel);
        mainPanel.add(textEditorPanel);
        mainPanel.add(groupLayoutPanel);
        mainPanel.add(optionDialogPanel);

        add(mainPanel, BorderLayout.SOUTH);
    }

    /**
     * Dodaje RadioButton do grupy przyciskow oraz panelu. Dodaje sluchacza dla kazdego z przyciskow
     * @param name Zawiera String z nazwa jezyka programowania
     */

    public void addRadioButton(String name) {
        boolean selected = name.equals(DEFAULT_LANGUAGE);
        JRadioButton button = new JRadioButton(name, selected);
        buttonGroup.add(button);
        radioButtonPanel.add(button);

        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLabel.setText(name);
            }
        };

        button.addActionListener(radioListener);
    }

    /**
     * Pozwala wybrac styl - Italic, Bold - wyswietlanego napisu
     * @param name Zawiera String z nazwa stylu
     */

    public void addCheckBox(String name) {
        JCheckBox checkBox = new JCheckBox(name);
        checkBoxPanel.add(checkBox);

        ActionListener checkListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mode = 0;
                if (checkBox.isSelected() && checkBox.getText().toUpperCase().equals("POGRUBIENIE")) mode += Font.BOLD;
                if (checkBox.isSelected() && checkBox.getText().toUpperCase().equals("KURSYWA")) mode += Font.ITALIC;
                textLabel.setFont(new Font("Ubuntu", mode, DEFAULT_TEXT_SIZE));
            }
        };

        checkBox.addActionListener(checkListener);
    }

    /**
     * Dodaje RadioButton'y ze stylami ramek mozliwymi do wyswietlenia (nie zawiera mieszania stylow)
     * @param name   Etykieta dla RadioButton zawierajaca nazwe stylu
     * @param border Ramka do ktorej ma byc dodany tytul
     */

    public void addBorderButton(String name, final Border border) {
        boolean selected = name.equals("Etched");
        JRadioButton button = new JRadioButton(name, selected);
        borderButtonGroup.add(button);
        borderPanel.add(button);

        //TODO: Usprawnić tą metodę, aby nie trzeba była ręcznie za każym razem dodawać kolejnych paneli ;_;

        ActionListener borderListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLabel.setBorder(createTitledBorder(TEXT_LABEL_DESC, border));
                checkBoxPanel.setBorder(createTitledBorder(STYLE_DESC, border));
                radioButtonPanel.setBorder(createTitledBorder(RADIO_BUTTON_DESC, border));
                borderPanel.setBorder(createTitledBorder(BORDER_DESC, border));
                quotePanel.setBorder(createTitledBorder(FONT_DESC, border));
                newWindowPanel.setBorder(createTitledBorder(SLIDER_WINDOW_DESC, border));
                textEditorPanel.setBorder(createTitledBorder(TEXT_EDITOR_WINDOW_DESC, border));
                groupLayoutPanel.setBorder(createTitledBorder(GROUP_LAYOUT_WINDOW_DESC, border));
                optionDialogPanel.setBorder(createTitledBorder(OPTION_DIALOG_WINDOW_DESC, border));
            }
        };

        button.addActionListener(borderListener);
    }

    /**
     * Ustawia domyslną ramke i jej wyglad dla okreslonego elementu rozszerzajacego JComponent
     *
     * @param component Element rozszerzajacy JComponent, dla ktorego ma byc ustawiona domyslna ramka
     * @param name      Nazwa ramki ktora ma byc nadana
     */

    public void setDefaultBorder(JComponent component, String name) {
        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched, name, TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, mainFont);
        component.setBorder(titled);
    }

    /**
     * Metoda pozwalająca stworzyc TitledBorder z innych, dowolnych borderow z zachowaniem ich własciwosci
     *
     * @param componentName nazwa komponentu dla ktorego dana ramka jest wyswietlana
     * @param border        ramka do ktorej ma byc dodany tytul
     * @return Zwraca nowa ramke z tytulem
     */

    public Border createTitledBorder(String componentName, Border border) {
        Border tmpBrd = BorderFactory.createTitledBorder(border, componentName,
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, mainFont);
        return tmpBrd;
    }

    /**
     * Pozwala dodawac pozycje do JComboBox (faceCombo) oraz dodaje sluchacza do kazdego elementu
     *
     * @param fontName Nazwa czcionki w systemie uzytkownika, koniecznie napisana poprawnie
     */

    public void addComboItem(String fontName) {
        faceCombo.addItem(fontName);
        quotePanel.add(faceLabel);
        quotePanel.add(faceCombo);

        ActionListener comboListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                faceLabel.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()), Font.PLAIN,
                        DEFAULT_FONT_SIZE));
            }
        };

        faceCombo.addActionListener(comboListener);
    }

    /**
     * Dodaje przycisk do panelu newWindowPanel ze sluchaczem, konfiguruje podstawowe wlasciwosci nowego okna
     * @param name Tekst przycisku newWindowButton
     */

    public void addNewWindowButton(String name, JPanel panel, final int frameNumber, int sizeX, int sizeY) {
        JButton button = new JButton(name);
        panel.add(button);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame frame;
                        if (frameNumber == BASIC_COMPONENTS_ONE) frame = new BasicComponentsOne();
                        else if (frameNumber == BASIC_COMPONENTS_TWO) frame = new BasicComponentsTwo();
                        else if (frameNumber == BASIC_COMPONENTS_THREE) frame = new BasicComponentsThree();
                        else if (frameNumber == BASIC_COMPONENTS_FOUR) frame = new BasicComponentsFour();
                        else if (frameNumber == OPTION_DIALOG_TEST_FRAME) frame = new OptionDialogTestFrame();
                        else {
                            frame = null;
                            System.err.println("Nie istnieje taka JFrame");
                        }
                        frame.setTitle(name);
                        frame.setPreferredSize(new Dimension(sizeX, sizeY));
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.setLocationByPlatform(true);

                        if (frameNumber != BASIC_COMPONENTS_FOUR) frame.pack();

                        frame.setVisible(true);
                    }
                });
            }
        };

        button.addActionListener(listener);
    }
}

