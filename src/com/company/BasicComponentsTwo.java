package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Klasa zawierajaca suwaki biblioteki Swing.
 * Created by �ukasz on 2015-07-19.
 */
public class BasicComponentsTwo extends JFrame {
    private final String TEXT_FIELD_START_VALUE = "Obecna warto��: ";

    private JPanel sliderPanel;
    private JTextField sliderTextField;
    private ChangeListener changeListener;

    /**
     * Podstawowy konstruktor okna zawierajacego suwaki Swing.
     */

    public BasicComponentsTwo() {
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());

        //Wsp�lny s�uchacz wszystkich suwak�w
        changeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                sliderTextField.setText(TEXT_FIELD_START_VALUE + source.getValue());
            }
        };

        //Zwyk�y suwak
        JSlider slider = new JSlider();

        addSlider(slider, "Zwyk�y");

        //Suwak z podzia�k�
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        addSlider(slider, "Podzia�ka");

        //Suwak z dosuwaniem ga�ki do najbli�szej kreski
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        addSlider(slider, "Dosuwany");

        //Suwak bez prowadnicy
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(false);

        addSlider(slider, "Bez prowadnicy");

        //Suwak o odwr�conym dzia�aniu
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);

        addSlider(slider, "Odwr�cony");

        //Suwak z etykietami liczbowymi
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        addSlider(slider, "Etykiety");

        //Suwak z etykietami literowymi
        slider = new JSlider();
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        Dictionary<Integer, Component> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("A"));
        labelTable.put(20, new JLabel("B"));
        labelTable.put(40, new JLabel("C"));
        labelTable.put(60, new JLabel("D"));
        labelTable.put(80, new JLabel("E"));
        labelTable.put(100, new JLabel("F"));

        slider.setLabelTable(labelTable);
        addSlider(slider, "Niestandardowe etykiety");

        //Suwak z etykietami ikonowymi
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);    //Dosuwanie
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);

        //Dodawanie obraz�w kart
        //TODO: Brak obraz�w ikon
        labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel(new ImageIcon("nine.gif")));
        labelTable.put(20, new JLabel(new ImageIcon("ten.gif")));
        labelTable.put(40, new JLabel(new ImageIcon("jack.gif")));
        labelTable.put(60, new JLabel(new ImageIcon("queen.gif")));
        labelTable.put(80, new JLabel(new ImageIcon("king.gif")));
        labelTable.put(100, new JLabel(new ImageIcon("ace.gif")));

        slider.setLabelTable(labelTable);
        addSlider(slider, "Ikony");

        //Pole tekstowe obrazuj�ce warto�� i jego pocz�tkowa konfiguracja
        sliderTextField = new JTextField();
        sliderTextField.setEditable(false);
        sliderTextField.setHorizontalAlignment(JTextField.CENTER);
        sliderTextField.setText(TEXT_FIELD_START_VALUE + "[Przesu� suwak]");

        add(sliderPanel, BorderLayout.CENTER);
        add(sliderTextField, BorderLayout.SOUTH);
    }

    /**
     * Dddaje suwak do utworzonego panelu, nadaje mu etykiete, ustawia pozycjonowanie
     * @param s JSlider przekazywany jako parametr
     * @param description Opis dla danego suwaka
     */

    public void addSlider(JSlider s, String description) {
        Border border = BorderFactory.createEtchedBorder();
        Border titledBorder = BorderFactory.createTitledBorder(border, description);
        s.setBorder(titledBorder);

        s.addChangeListener(changeListener);

        JPanel panel = new JPanel();
        panel.add(s);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //TODO: Co to jest GridBagConstraints?!
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = sliderPanel.getComponentCount();
        gbc.anchor = GridBagConstraints.WEST;

        sliderPanel.add(panel, gbc);
    }
}