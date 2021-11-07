package by.bakhar.lab4.swing;

import by.bakhar.lab4.listener.OpenFileMenuButtonListener;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(CustomFrame frame) {
        JMenu jMenu = new JMenu("option");
        JMenuItem openFileMenu = new JMenuItem("open file");
        openFileMenu.addActionListener(new OpenFileMenuButtonListener(frame));
        jMenu.add(openFileMenu);
        add(jMenu);
    }
}
