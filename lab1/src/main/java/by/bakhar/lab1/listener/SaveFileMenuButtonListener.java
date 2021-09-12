package by.bakhar.lab1.listener;

import by.bakhar.lab1.swing.CustomFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFileMenuButtonListener implements ActionListener {
    private final CustomFrame frame;

    public SaveFileMenuButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame.getTextChanged()) {
            String text = frame.getText();
            try (FileWriter fileWriter = new FileWriter(frame.getFile())) {
                fileWriter.write(text);
                frame.setTextChanged(false);
                JOptionPane.showMessageDialog(null, "Text was saved", "save dialog", JOptionPane.DEFAULT_OPTION);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }
}
