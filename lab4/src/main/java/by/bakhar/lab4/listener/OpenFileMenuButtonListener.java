package by.bakhar.lab4.listener;


import by.bakhar.lab4.reader.CustomReader;
import by.bakhar.lab4.swing.CustomFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OpenFileMenuButtonListener implements ActionListener {
    private static final String CURRENT_DIRECTORY_PATH = "src/main/resources";
    private final CustomFrame frame;

    public OpenFileMenuButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser(CURRENT_DIRECTORY_PATH);
        int result = jFileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String message = "File " + jFileChooser.getSelectedFile() + " was chosen";
            JOptionPane.showMessageDialog(jFileChooser, message, "Success", JOptionPane.PLAIN_MESSAGE);
            try {
                CustomReader reader = new CustomReader();
                frame.getPanel().getjTextArea().setText(reader.readFromTxt(String.valueOf(jFileChooser.getSelectedFile())));
            } catch (IOException ioException) {
                String errorMessage = "Reading is impossible";
                JOptionPane.showMessageDialog(null, errorMessage, "Fail", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

}
