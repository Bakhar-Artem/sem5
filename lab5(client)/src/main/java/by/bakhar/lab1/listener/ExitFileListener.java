package by.bakhar.lab1.listener;

import by.bakhar.lab1.swing.CustomFrame;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;

public class ExitFileListener implements WindowListener {
    private final CustomFrame frame;

    public ExitFileListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (frame.getTextChanged()) {
            int n = JOptionPane.showConfirmDialog(null, "Save before exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if(n==0){
                String text = frame.getText();
                try (FileWriter fileWriter = new FileWriter(frame.getFile())) {
                    fileWriter.write(text);
                    frame.setTextChanged(false);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
