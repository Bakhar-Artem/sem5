package by.bakhar.lab3.listener;

import by.bakhar.lab3.swing.CustomFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SelectionListListener implements ListSelectionListener {
    private static final String PARAMS = "params";
    private static final String PROP_PATH = "src/main/resources/function/calc.properties";
    private static Properties properties;
    private CustomFrame frame;
    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(PROP_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public SelectionListListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
                String func = frame.getMethodJList().getSelectedValue();
                String func_params = func + "_" + PARAMS;
                JPanel panel = frame.getParamsPanel();
                int params = Integer.parseInt(properties.getProperty(func_params));
                Component[] panels = panel.getComponents();
                for (Component panel1 : panels) {
                    panel1.setVisible(false);
                }
                switch (params) {
                    case 0 -> {
                       panels[3].setVisible(true);
                    }
                    case 1 -> {
                        panels[0].setVisible(true);
                        panels[3].setVisible(true);
                    }
                    case 2 -> {
                        panels[0].setVisible(true);
                        panels[1].setVisible(true);
                        panels[3].setVisible(true);
                    }
                    case 3 -> {
                        panels[0].setVisible(true);
                        panels[1].setVisible(true);
                        panels[2].setVisible(true);
                        panels[3].setVisible(true);
                    }
                }

        }

    }
}
