package by.bakhar.lab2.swing;

import by.bakhar.lab2.listener.AddStudentButtonListener;
import by.bakhar.lab2.listener.OpenByteMenuButtonListener;
import by.bakhar.lab2.listener.OpenFileMenuButtonListener;
import by.bakhar.lab2.listener.SaveByteMenuButtonListener;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(CustomFrame frame) {
        JMenu jMenu = new JMenu("option");
        JMenuItem openFileMenu = new JMenuItem("open file");
        openFileMenu.addActionListener(new OpenFileMenuButtonListener(frame));
        JMenuItem saveByteMenu = new JMenuItem("save file to bytes");
        saveByteMenu.addActionListener(new SaveByteMenuButtonListener(frame));
        JMenuItem openByteMenu = new JMenuItem("open file from bytes");
        openByteMenu.addActionListener(new OpenByteMenuButtonListener(frame));
        JMenuItem addStudentMenu = new JMenuItem("add student");
        addStudentMenu.addActionListener(new AddStudentButtonListener(frame));
        jMenu.add(openFileMenu);
        jMenu.add(openByteMenu);
        jMenu.add(saveByteMenu);
        jMenu.add(addStudentMenu);
        add(jMenu);
    }
}
