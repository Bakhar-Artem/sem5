package by.bakhar.lab1.swing;

import by.bakhar.lab1.listener.EncryptButtonListener;

import javax.swing.*;

public class ButtonPanel extends JPanel {
    public ButtonPanel(CustomFrame frame) {
        JButton encryptButton = new JButton("encrypt");
        encryptButton.setSize(100, 50);
        encryptButton.addActionListener(new EncryptButtonListener(frame));
        add(encryptButton);
    }
}
