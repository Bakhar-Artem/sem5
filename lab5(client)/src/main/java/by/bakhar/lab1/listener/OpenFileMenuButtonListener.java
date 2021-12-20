package by.bakhar.lab1.listener;


import by.bakhar.lab1.reader.TextReader;
import by.bakhar.lab1.swing.CustomFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OpenFileMenuButtonListener implements ActionListener {
    private static final String NAME_FILTER = "Text file(.txt)";
    private static final String EXTENSION_FILTER = "txt";
    private final CustomFrame frame;

    public OpenFileMenuButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new FileNameExtensionFilter(NAME_FILTER, EXTENSION_FILTER));
        int result = jFileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String message = "File " + jFileChooser.getSelectedFile() + " was chosen";
            frame.setFile(jFileChooser.getSelectedFile());
            JOptionPane.showMessageDialog(jFileChooser, message, "Success", JOptionPane.DEFAULT_OPTION);
            TextReader reader = new TextReader();
            try {
                String text = reader.readTextFromTxt(jFileChooser.getSelectedFile().toString());
                frame.setText(text);
            } catch (IOException ioException) {
                String errorMessage = "Reading is impossible";
                JOptionPane.showMessageDialog(jFileChooser, errorMessage, "Fail", JOptionPane.DEFAULT_OPTION);
            }
        }
    }

}
