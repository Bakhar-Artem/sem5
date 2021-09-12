package by.bakhar.lab1.swing;

import by.bakhar.lab1.listener.OpenFileMenuButtonListener;
import by.bakhar.lab1.listener.SaveFileMenuButtonListener;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(CustomFrame frame) {
        JMenu jMenu = new JMenu("option");
        JMenuItem openFileMenu = new JMenuItem("open file");
        openFileMenu.addActionListener(new OpenFileMenuButtonListener(frame));
        JMenuItem saveFileMenu = new JMenuItem("save file");
        saveFileMenu.addActionListener(new SaveFileMenuButtonListener(frame));
        jMenu.add(openFileMenu);
        jMenu.add(saveFileMenu);
        add(jMenu);
    }
}
