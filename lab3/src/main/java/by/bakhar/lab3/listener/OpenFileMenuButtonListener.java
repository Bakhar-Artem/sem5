package by.bakhar.lab3.listener;


import by.bakhar.lab3.swing.CustomFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenFileMenuButtonListener implements ActionListener {
    private static final String FUNCTION_PATH = "src/main/resources/function/functions";
    private final CustomFrame frame;

    public OpenFileMenuButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            DefaultListModel<String> functions = new DefaultListModel<>();
            Files.lines(Paths.get(FUNCTION_PATH), StandardCharsets.UTF_8).forEach(functions::addElement);
            frame.getMethodJList().setModel(functions);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

