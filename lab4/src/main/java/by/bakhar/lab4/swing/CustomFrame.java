package by.bakhar.lab4.swing;

import by.bakhar.lab4.listener.ExitFileListener;

import javax.swing.*;
import java.awt.*;


public class CustomFrame extends JFrame {
    private TextPanel panel;

    public CustomFrame() {
        super("Session");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new ExitFileListener());
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(new Dimension(500, 350));
        addMenuBar();
        addTextPanel();
        setVisible(true);
    }

    private void addMenuBar() {
        JMenuBar jMenuBar = new MenuBar(this);
        setJMenuBar(jMenuBar);
    }

    private void addTextPanel() {
        panel = new TextPanel(this);
        add(panel);
    }

    public TextPanel getPanel() {
        return panel;
    }


}