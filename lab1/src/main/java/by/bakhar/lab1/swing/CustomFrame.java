package by.bakhar.lab1.swing;

import by.bakhar.lab1.listener.ExitFileListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CustomFrame extends JFrame {
    private String text;
    private boolean textChanged = false;
    private File file = null;

    public CustomFrame() {
        super("Encryption");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new ExitFileListener(this));
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(new Dimension(300, 150));
        addMenuBar();
        addButtonPanel();
        setVisible(true);
    }

    private void addMenuBar() {
        JMenuBar jMenuBar = new MenuBar(this);
        setJMenuBar(jMenuBar);
    }

    private void addButtonPanel() {
        JPanel buttonPanel = new ButtonPanel(this);
        add(buttonPanel);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getTextChanged() {
        return textChanged;
    }

    public void setTextChanged(boolean textChanged) {
        this.textChanged = textChanged;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
