package by.bakhar.lab1.listener;

import by.bakhar.lab1.exception.EncryptException;
import by.bakhar.lab1.service.EncryptService;
import by.bakhar.lab1.service.impl.EncryptServiceImpl;
import by.bakhar.lab1.swing.CustomFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptButtonListener implements ActionListener {
    private final CustomFrame frame;

    public EncryptButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EncryptService encryptService = new EncryptServiceImpl();

        try {
            String encryptedText = encryptService.encrypt(frame.getText());
            frame.setText(encryptedText);
            frame.setTextChanged(true);
            String message = "Text was encrypted";
            JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.PLAIN_MESSAGE);
        } catch (EncryptException encryptException) {
            JOptionPane.showMessageDialog(null, encryptException.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
